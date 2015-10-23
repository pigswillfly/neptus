/*
 * Copyright (c) 2004-2015 Universidade do Porto - Faculdade de Engenharia
 * Laboratório de Sistemas e Tecnologia Subaquática (LSTS)
 * All rights reserved.
 * Rua Dr. Roberto Frias s/n, sala I203, 4200-465 Porto, Portugal
 *
 * This file is part of Neptus, Command and Control Framework.
 *
 * Commercial Licence Usage
 * Licencees holding valid commercial Neptus licences may use this file
 * in accordance with the commercial licence agreement provided with the
 * Software or, alternatively, in accordance with the terms contained in a
 * written agreement between you and Universidade do Porto. For licensing
 * terms, conditions, and further information contact lsts@fe.up.pt.
 *
 * European Union Public Licence - EUPL v.1.1 Usage
 * Alternatively, this file may be used under the terms of the EUPL,
 * Version 1.1 only (the "Licence"), appearing in the file LICENSE.md
 * included in the packaging of this file. You may not use this work
 * except in compliance with the Licence. Unless required by applicable
 * law or agreed to in writing, software distributed under the Licence is
 * distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF
 * ANY KIND, either express or implied. See the Licence for the specific
 * language governing permissions and limitations at
 * https://www.lsts.pt/neptus/licence.
 *
 * For more information please see <http://lsts.fe.up.pt/neptus>.
 *
 * Author: liz
 * Oct 16, 2015
 */
package no.ntnu.thermalcamcontrol.gui;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;
import javax.swing.JPanel;

import com.google.common.eventbus.Subscribe;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;
import pt.lsts.neptus.console.ConsoleLayout;
import pt.lsts.neptus.console.ConsolePanel;
import pt.lsts.neptus.console.plugins.MainVehicleChangeListener;
import pt.lsts.neptus.plugins.PluginDescription;
import pt.lsts.neptus.plugins.PluginDescription.CATEGORY;
import pt.lsts.neptus.util.ImageUtils;

/**
 * @author Elizabeth Roy
 *
 */
@PluginDescription(name = "FLIR Tau 2 Camera Controller", author = "lizroy", version = "0.1", category = CATEGORY.INTERFACE)
public class ThermalCamControlGui extends ConsolePanel implements MainVehicleChangeListener, ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static ImageIcon ICON = new ImageIcon(ImageUtils.getImage(
            "images/thermal_cam.png").getScaledInstance(16, 16, Image.SCALE_SMOOTH));
    private static ImageIcon ICON_BIG = new ImageIcon(ImageUtils.getImage(
            "images/thermal_cam.png").getScaledInstance(48, 48, Image.SCALE_SMOOTH));
    private static ImageIcon GREEN_LIGHT = new ImageIcon(ImageUtils.getImage(
            "images/green_light.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    private static ImageIcon YELLOW_LIGHT = new ImageIcon(ImageUtils.getImage(
            "images/yellow_light.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH));   
    private static ImageIcon RED_LIGHT = new ImageIcon(ImageUtils.getImage(
            "images/red_light.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH));
      
    private JTabbedPane tabPanel = null;
    private JPanel statusPanel = null;
    private SetupPanel setupPanel = null;
    private JTabbedPane videoPanel = null;
    private AnalogPanel analogPanel = null;
    private DigitalPanel digitalPanel = null;
    private JPanel agcPanel = null;
    private JPanel thermalPanel = null;
    
    private JPanel bottomPanel = null;
    private JLabel connectedLabel = null;
    private JLabel partNumberLabel = null;
    private JLabel serialNumberLabel = null;
    private JLabel statusLabel = null;
    private List<ThermalCamControl> msgSentList = new Vector<ThermalCamControl>();
    
    private JMenuBar thermalCamMenuBar = null;
    
    //private PeriodicThermalCamConnectedQuery connectionStatusUpdater = null;
    
    public ThermalCamControlGui(ConsoleLayout console){
        super(console);
        initialize();
    }
    
    private void initialize(){
        
        JPanel contentPanel = new JPanel();
        GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(getBottomPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addComponent(getTabPanel())
        );
        contentPanelLayout.setVerticalGroup(
                contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(tabPanel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bottomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        this.setLayout(new BorderLayout());
        this.add(contentPanel, BorderLayout.CENTER);
        
        sendConnectRequest();
        
    }
    
    private void sendConnectRequest(){
        if(connectedLabel.getIcon() == RED_LIGHT){
            connectedLabel.setIcon(YELLOW_LIGHT);
            connectedLabel.setText("Connecting...");
        }
        ThermalCamControl msg = new ThermalCamControl();
        msg.setProcessCode(ThermalCamFunctionCodes.NO_OP.getFunctionCode());
        send(msg);  
    }
    
    // Thermal Cam Control message listener
    @Subscribe
    public void on(ThermalCamControl msg){
        if(msg.getSourceName().equals(getConsole().getMainSystem())){
            if(msg.getProcessCode() == 0x6E){
                // Valid message
                updateStatus(msg.getStatus());
            
                for(ThermalCamControl sent: msgSentList){
                    
                    if(sent.getFunction() == msg.getFunction()){
                        // Reply received
                        for(ThermalCamFunctionCodes code: ThermalCamFunctionCodes.values()){
                            if (code.getFunctionCode() == msg.getFunction()){
                                UseThermalCamMsgUpdater.callOnReply(code, sent, msg);
                            }
                        }
                    }
                    else{
                        // Send again, no reply
                        for(ThermalCamFunctionCodes code: ThermalCamFunctionCodes.values()){
                            if(code.getFunctionCode() == msg.getFunction()){
                                UseThermalCamMsgUpdater.callIfNoReply(code, sent);
                            }
                        }
                    } 
                    msgSentList.remove(sent);
                }
            }
            else{
                
            }
        }
    }
       
    public void addToMsgSentList(ThermalCamControl msg){
        if(msgSentList == null){
            msgSentList = new Vector<ThermalCamControl>();
        }
        msgSentList.add(msg);
    }

    private void updateSerialNumber(byte[] args) {
        serialNumberLabel.setText(args.toString());
    }
    
    private void updateCamPartNumber(byte[] args){
        partNumberLabel.setText(args.toString());
    }
    
    private void updateStatus(short status){
        switch(status){
            case 0x00:
                statusLabel.setText("CAM OK");
                break;
            case 0x01:
                
                break;
            default: 
                statusLabel.setText("No status");
        }
    }
    
    private void updateConnected(boolean connected){
        if(connected == true){
            connectedLabel.setIcon(GREEN_LIGHT);
            connectedLabel.setText("Connected");
        }
        else{
            connectedLabel.setIcon(RED_LIGHT);
            connectedLabel.setText("Not connected");
        }
    }
 
    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseMsgUpdater.MsgUpdater#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {

        if(rec.getFunction() == ThermalCamFunctionCodes.NO_OP.getFunctionCode()){
            updateConnected(true);
        }
        else if(rec.getFunction() == ThermalCamFunctionCodes.SERIAL_NUMBER.getFunctionCode()){
            updateSerialNumber(rec.getArgs());
        }
        else if(rec.getFunction() == ThermalCamFunctionCodes.CAMERA_PART_GET.getFunctionCode()){
            updateCamPartNumber(rec.getArgs());
        }
    }
    
    @Override
    public void executeIfNoReply(ThermalCamControl sent){
        // check message and send again
    }

    
    /** Panel Access Functions **/
    
    public JPanel getStatusPanel(){
        if(statusPanel == null){
            statusPanel = new JPanel();
        }
        return statusPanel;
    }
    
    public SetupPanel getSetupPanel(){
        if(setupPanel == null){
            setupPanel = new SetupPanel();
        }
        return setupPanel;
    }
    
    public JTabbedPane getVideoPanel(){
        if(videoPanel == null){
            videoPanel = new JTabbedPane();
            videoPanel.addTab("Analog", getAnalogPanel());
            videoPanel.addTab("Digital", getDigitalPanel());
        }
        return videoPanel;
    }
    
    public AnalogPanel getAnalogPanel(){
        if(analogPanel == null){
            analogPanel = new AnalogPanel();
        }
        return analogPanel;
    }
    
    public DigitalPanel getDigitalPanel(){
        if(digitalPanel == null){
            digitalPanel = new DigitalPanel();
        }
        return digitalPanel;
    }

    public JPanel getAgcPanel(){
        if(agcPanel == null){
            agcPanel = new JPanel();
        }
        return agcPanel;
    }
    
    public JPanel getThermalPanel(){
        if(thermalPanel == null){
            thermalPanel = new JPanel();
        }
        return thermalPanel;
    }
    
    /** GUI Construction Functions **/
    
    private JTabbedPane getTabPanel(){

        if(tabPanel == null){
        
            tabPanel = new JTabbedPane();
            tabPanel.setVerifyInputWhenFocusTarget(false);
            tabPanel.addTab("Status", getStatusPanel());
            tabPanel.addTab("Setup", getSetupPanel());
            tabPanel.addTab("Video", getVideoPanel());
            tabPanel.addTab("AGC", getAgcPanel());
            tabPanel.addTab("Thermal", getThermalPanel());
          
        }
        
        return tabPanel;
    }

    private JPanel getBottomPanel(){
        
        if(bottomPanel == null){
            
            bottomPanel = new JPanel();
            connectedLabel = new JLabel();
            partNumberLabel = new JLabel();
            serialNumberLabel = new JLabel();
            statusLabel = new JLabel();
            
            bottomPanel.setPreferredSize(new java.awt.Dimension(866, 60));
            connectedLabel.setIcon(RED_LIGHT);
            connectedLabel.setText("Not connected");
            partNumberLabel.setText("Part #:");
            serialNumberLabel.setText("Serial #:");
            statusLabel.setText("No status");
            
            GroupLayout bottomPanelLayout = new GroupLayout(bottomPanel);
            bottomPanel.setLayout(bottomPanelLayout);
            bottomPanelLayout.setHorizontalGroup(
                bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(connectedLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                    .addComponent(statusLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                    .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(serialNumberLabel)
                        .addComponent(partNumberLabel))
                    .addGap(225, 225, 225))
            );
            bottomPanelLayout.setVerticalGroup(
                bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(bottomPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(connectedLabel)
                        .addComponent(statusLabel)
                        .addComponent(partNumberLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serialNumberLabel)
                    .addContainerGap())
            );
        }
        return bottomPanel;
    }
    
    public JMenuBar getMenuBar(){
        
        if(thermalCamMenuBar == null){
            
            thermalCamMenuBar = new JMenuBar();
            JMenu viewMenu = new JMenu();
            JMenu cameraMenu = new JMenu();
            JMenu toolsMenu = new JMenu();
            JMenuItem connectMenuItem = new JMenuItem();
            
            viewMenu.setText("View");
            thermalCamMenuBar.add(viewMenu);
    
            cameraMenu.add(connectMenuItem);
            cameraMenu.setText("Camera");
            thermalCamMenuBar.add(cameraMenu);
    
            toolsMenu.setText("Tools");
            thermalCamMenuBar.add(toolsMenu);
        }
        
        return thermalCamMenuBar;
    }

    
    /* (non-Javadoc)
     * @see pt.lsts.neptus.console.ConsolePanel#cleanSubPanel()
     */
    @Override
    public void cleanSubPanel() {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see pt.lsts.neptus.console.ConsolePanel#initSubPanel()
     */
    @Override
    public void initSubPanel() {
        // TODO Auto-generated method stub
        
    }

   

    
}
