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
    private static final String FPA_SIZE = String.valueOf(ThermalCamArguments.FPA_WIDTH.getArg()) + "x" + String.valueOf(ThermalCamArguments.FPA_HEIGHT.getArg());

/*
    private static ImageIcon ICON = new ImageIcon(ImageUtils.getImage(
            "images/thermal_cam.png").getScaledInstance(16, 16, Image.SCALE_SMOOTH));
    private static ImageIcon ICON_BIG = new ImageIcon(ImageUtils.getImage(
            "images/thermal_cam.png").getScaledInstance(48, 48, Image.SCALE_SMOOTH));
*/
    private static ImageIcon GREEN_LIGHT = new ImageIcon(ImageUtils.getImage(
            "images/green_light.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    private static ImageIcon YELLOW_LIGHT = new ImageIcon(ImageUtils.getImage(
            "images/yellow_light.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH));   
    private static ImageIcon RED_LIGHT = new ImageIcon(ImageUtils.getImage(
            "images/red_light.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH));
          
    private ThermalCamSettings factorySettings = null;
    private ThermalCamSettings savedSettings = null;
    
    private JTabbedPane tabPanel = null;
    private StatusPanel statusPanel = null;
    private SetupPanel setupPanel = null;
    private JTabbedPane videoPanel = null;
    private AnalogPanel analogPanel = null;
    private DigitalPanel digitalPanel = null;
    private JTabbedPane agcPanel = null;
    private AGCDDEPanel agcDdePanel = null;
    private RoiPanel roiPanel = null;
    private JPanel thermalPanel = null;
    
    private JMenuBar thermalCamMenuBar = null;
    private JPanel bottomPanel = null;
    private JLabel connectedLabel = null;
    private JLabel partNumberLabel = null;
    private JLabel serialNumberLabel = null;
    private JLabel fpaSizeLabel = null;
    private JLabel statusLabel = null;
    private List<ThermalCamControl> msgSentList = new Vector<ThermalCamControl>();
    
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
                    .addComponent(getTabPanel())
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(getBottomPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        this.setLayout(new BorderLayout());
        this.add(contentPanel, BorderLayout.CENTER);
        
        factorySettings = new ThermalCamSettings(this);
        savedSettings = new ThermalCamSettings(this);
        
        setupHomePanels();
               
        sendConnectRequest(); 
    }
    
    private void askForCurrentSettings(){
        this.getSetupPanel().getFFCPanel().getFFCSettingsMessage();
        this.getSetupPanel().getExternalSyncPanel().getExternalSyncMessage();
        this.getSetupPanel().getGainModePanel().getGainModeMessage();
        this.getSetupPanel().getTestPatternPanel().getTestPatternMessage();
        this.getAgcDdePanel().getEnhancePanel().getEnhanceSettings();
        this.getAgcDdePanel().getManualParamPanel().getManualParams();
        this.getAgcDdePanel().getAgcModesPanel().getAgcModeMessage();
        this.getAgcDdePanel().getEnhancePanel().getEnhanceSettings();
        this.getRoiPanel().getRoiCoordinatesMessage();
        this.getStatusPanel().getNumbersMessages();
        this.getStatusPanel().getFpaTempMessage();
        this.getAnalogPanel().getOrientationPanel().getOrientationMessage();
        this.getAnalogPanel().getPanZoomPanel().getPanZoomMessages();
        this.getAnalogPanel().getPolarityPanel().getPaletteMessage();
        this.getAnalogPanel().getAnalogVideoOnOffPanel().getVideoModeMessage();
        this.getAnalogPanel().getAnalogVideoStandardPanel().getVideoStandardMessage();
        this.getAnalogPanel().getAnalogFFCPanel().getFfcWarningTimeMessage();
        this.getAnalogPanel().getAnalogVideoColorPanel().getColorEnabledMessage();
    }
    
    private void setupHomePanels(){
        for(ThermalCamFunctionCodes code: ThermalCamFunctionCodes.values()){
            try{
                String homePanel = code.getHomePanel();
                switch(homePanel){
                    case "StatusPanel":
                        code.setReplyAction(getStatusPanel());
                        break;
                    case "FfcPanel":
                        code.setReplyAction(this.getSetupPanel().getFFCPanel());
                        break;
                    case "GainModePanel":
                        code.setReplyAction(this.getSetupPanel().getGainModePanel());
                        break;
                    case "SettingsButtonsPanel":
                        code.setReplyAction(this.getSetupPanel().getSettingsButtonsPanel());
                        break;
                    case "TestPatternPanel":
                        code.setReplyAction(this.getSetupPanel().getTestPatternPanel());
                        break;
                    case "ExternalSyncPanel":
                        code.setReplyAction(this.getSetupPanel().getExternalSyncPanel());
                        break;
                    case "EnhancePanel":
                        code.setReplyAction(this.getAgcDdePanel().getEnhancePanel());
                        break;
                    case "ManualParamPanel":
                        code.setReplyAction(this.getAgcDdePanel().getManualParamPanel());
                        break;
                    case "AgcModesPanel":
                        code.setReplyAction(this.getAgcDdePanel().getAgcModesPanel());
                        break;
                    case "RoiPanel":
                        code.setReplyAction(this.getRoiPanel());
                        break;
                    case "OrientationPanel":
                        code.setReplyAction(this.getAnalogPanel().getOrientationPanel());
                        break;
                    case "PanZoomPanel":
                        code.setReplyAction(this.getAnalogPanel().getPanZoomPanel());
                        break;
                    case "PolarityPanel":
                        code.setReplyAction(this.getAnalogPanel().getPolarityPanel());
                        break;
                    case "AnalogVideoOnOffPanel":
                        code.setReplyAction(this.getAnalogPanel().getAnalogVideoOnOffPanel());
                        break;
                    case "AnalogVideoStandardPanel":
                        code.setReplyAction(this.getAnalogPanel().getAnalogVideoStandardPanel());
                        break;
                    case "AnalogFFCPanel":
                        code.setReplyAction(this.getAnalogPanel().getAnalogFFCPanel());
                        break;
                    case "AnalogVideoColorPanel":
                        code.setReplyAction(this.getAnalogPanel().getAnalogVideoColorPanel());
                        break;
                    default:
                        code.setReplyAction(this);
                }
            }
            catch(NullPointerException e){
                code.setReplyAction(this);
            }
        }
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
    
    protected void sendCommand(ThermalCamControl msg){
        addToMsgSentList(msg);
        send(msg);
    }
    
    private void addToMsgSentList(ThermalCamControl msg){
        if(msgSentList == null){
            msgSentList = new Vector<ThermalCamControl>();
        }
        msgSentList.add(msg);
    }
    
    /** Thermal Cam Control message listener **/
    
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
                            UseThermalCamMsgUpdater.callOnReply(code.getReplyAction(), sent, msg);
                        }
                    }
                    else{
                        // Send again, no reply
                        for(ThermalCamFunctionCodes code: ThermalCamFunctionCodes.values()){
                            if(code.getFunctionCode() == msg.getFunction()){
                                UseThermalCamMsgUpdater.callIfNoReply(code.getReplyAction(), sent);
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

    /** Field setters and getters **/
    
    protected void setSerialNumber(long num) {
        serialNumberLabel.setText(String.valueOf(num));
    }
    
    protected void setPartNumber(String num){
        partNumberLabel.setText(num);
    }
    
    private void updateStatus(int status){
        for(ThermalCamStatus s : ThermalCamStatus.values()){
            if(s.getStatusCode() == status){
                this.getStatusPanel().updateStatus(s);
                this.statusLabel.setText(s.getStatusDescription());
            }
        }
    }

    private void updateConnected(boolean connected){
        if(connected == true){
            if(connectedLabel.getIcon() == YELLOW_LIGHT){
                askForCurrentSettings();
            }
            connectedLabel.setIcon(GREEN_LIGHT);
            connectedLabel.setText("Connected");
        }
        else{
            connectedLabel.setIcon(RED_LIGHT);
            connectedLabel.setText("Not connected");
        }
    }
    
    protected ThermalCamSettings getFactorySettings(){
        return factorySettings;
    }
    
    protected ThermalCamSettings getSavedSettings(){
        return savedSettings;
    }
 
    /** Reply Action Interface **/
    
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.NO_OP.getFunctionCode()){
            updateConnected(true);
        }
    }
    
    @Override
    public void executeIfNoReply(ThermalCamControl sent){
        sendCommand(sent);
    }
  
    /** Panel Access Functions **/
    
    public StatusPanel getStatusPanel(){
        if(statusPanel == null){
            statusPanel = new StatusPanel(this);
        }
        return statusPanel;
    }
    
    public SetupPanel getSetupPanel(){
        if(setupPanel == null){
            setupPanel = new SetupPanel(this);
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
            analogPanel = new AnalogPanel(this);
        }
        return analogPanel;
    }
    
    public DigitalPanel getDigitalPanel(){
        if(digitalPanel == null){
            digitalPanel = new DigitalPanel();
        }
        return digitalPanel;
    }
    
    public JTabbedPane getAgcPanel(){
        if(agcPanel == null){
            agcPanel = new JTabbedPane();
            agcPanel.addTab("AGC/DDE", getAgcDdePanel());
            agcPanel.addTab("ROI", getRoiPanel());
        }
        return agcPanel;
    }

    public AGCDDEPanel getAgcDdePanel(){
        if(agcDdePanel == null){
            agcDdePanel = new AGCDDEPanel(this);
        }
        return agcDdePanel;
    }
    
    public RoiPanel getRoiPanel(){
        if(roiPanel == null){
            roiPanel = new RoiPanel(this);
        }
        return roiPanel;
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
            fpaSizeLabel = new JLabel();
            
            bottomPanel.setPreferredSize(new java.awt.Dimension(866, 64));
            connectedLabel.setIcon(RED_LIGHT);
            connectedLabel.setText("Not connected");
            partNumberLabel.setText("Part #:");
            serialNumberLabel.setText("Serial #:");
            statusLabel.setText("No status");
            fpaSizeLabel.setText("FPA size: " + FPA_SIZE);
            
            GroupLayout bottomPanelLayout = new GroupLayout(bottomPanel);
            bottomPanel.setLayout(bottomPanelLayout);
            bottomPanelLayout.setHorizontalGroup(
                bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(connectedLabel)
                    .addGap(103, 103, 103)
                    .addComponent(statusLabel)
                    .addGap(176, 176, 176)
                    .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(serialNumberLabel)
                        .addGroup(bottomPanelLayout.createSequentialGroup()
                            .addComponent(partNumberLabel)
                            .addGap(9, 9, 9)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                    .addComponent(fpaSizeLabel)
                    .addGap(108, 108, 108))
            );
            bottomPanelLayout.setVerticalGroup(
                bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(bottomPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(connectedLabel)
                        .addComponent(partNumberLabel)
                        .addComponent(statusLabel)
                        .addComponent(fpaSizeLabel))
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
    
    /** Helper functions for getting and setting ThermalCamControl IMC Message args **/
    
    protected long twoBytesToLong(byte[] array){
        return (long)((array[0] & 0xFF) << 8) | (array[1] & 0xFF);
    }

    protected long fourBytesToLong(byte[] array){
        return (long)(((array[0] & 0xFF) << 24) 
                | ((array[1] & 0xFF) << 16) 
                | ((array[2] & 0xFF) << 8) 
                | (array[3] & 0xFF));
    }
    
    protected byte[] longtoTwoBytes(long arg){
        byte[] ret = new byte[2];
        ret[0] = (byte) (arg & 0xFF);
        ret[1] = (byte) ((arg >> 8) & 0xFF);
        return ret;
    }
        
    protected boolean isWithinRange(long min, long max, long value){
        return ((value < max)&&(value > min));
    }
    
    protected byte[] concatenate(byte[] first, byte[] second){
        byte[] asOne = new byte[first.length + second.length];
        System.arraycopy(first, 0, asOne, 0, first.length);
        System.arraycopy(second, 0, asOne, first.length, second.length);
        return asOne;
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
