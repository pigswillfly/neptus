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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.JPanel;

import pt.lsts.neptus.util.GuiUtils;
import pt.lsts.neptus.util.ImageUtils;

/**
 * @author Elizabeth Roy
 *
 */
public class ThermalCamControlGui extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
 //   private static ImageIcon ICON = new ImageIcon(ImageUtils.getImage(
 //           "images/thermal_cam.png").getScaledInstance(16, 16, Image.SCALE_SMOOTH));
 //   private static ImageIcon ICON_BIG = new ImageIcon(ImageUtils.getImage(
 //           "images/thermal_cam.png").getScaledInstance(48, 48, Image.SCALE_SMOOTH));
//    private static ImageIcon GREEN_LIGHT = new ImageIcon(ImageUtils.getImage(
 //           "images/green_light.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH));
 //   private static ImageIcon YELLOW_LIGHT = new ImageIcon(ImageUtils.getImage(
 //           "images/yellow_light.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH));   
    private static ImageIcon RED_LIGHT = new ImageIcon(ImageUtils.getImage(
            "images/red_light.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH));
      
    private JTabbedPane tabPanel = null;
    private JPanel bottomPanel = null;
    private static JMenuBar thermalCamMenuBar = null;
    
    public ThermalCamControlGui(){
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
        add(contentPanel, BorderLayout.CENTER);
        
        // Send IMC message function code 0x00 to verify camera connection
        // How to get reply? 
        
    }
    
    private JTabbedPane getTabPanel(){

        if(tabPanel == null){
        
            tabPanel = new JTabbedPane();
            //tabPanel.setVerifyInputWhenFocusTarget(false);
            // tabPane.add("Status", new StatusPanel());
             tabPanel.addTab("Setup", new SetupPanel());
             JTabbedPane videoTab = new JTabbedPane();
             videoTab.addTab("Analog", new AnalogPanel());
             videoTab.addTab("Digital", new DigitalPanel());
             tabPanel.addTab("Video", videoTab);
            // tabPane.addTab("AGC", new agcPanel());
            // tabPane.addTab("Thermal", new ThermalPanel());
        }
        
        return tabPanel;
    }

    private JPanel getBottomPanel(){
        
        if(bottomPanel == null){
            
            bottomPanel = new JPanel();
            JLabel connectedLabel = new JLabel();
            JLabel partNumberLabel = new JLabel();
            JLabel serialNumberLabel = new JLabel();
            
            bottomPanel.setPreferredSize(new java.awt.Dimension(866, 60));
            connectedLabel.setIcon(RED_LIGHT);
            connectedLabel.setText("Not connected");
            partNumberLabel.setText("Part #:");
            serialNumberLabel.setText("Serial #:");
            
            GroupLayout bottomPanelLayout = new GroupLayout(bottomPanel);
            bottomPanel.setLayout(bottomPanelLayout);
            bottomPanelLayout.setHorizontalGroup(
                bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(connectedLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
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
                        .addComponent(partNumberLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serialNumberLabel)
                    .addContainerGap())
            );
        }
        return bottomPanel;
    }
    
    private static JMenuBar getMenuBar(){
        
        if(thermalCamMenuBar == null){
            
            thermalCamMenuBar = new JMenuBar();
            JMenu viewMenu = new JMenu();
            JMenu cameraMenu = new JMenu();
            JMenu toolsMenu = new JMenu();
            
            viewMenu.setText("View");
            thermalCamMenuBar.add(viewMenu);
    
            cameraMenu.setText("Camera");
            thermalCamMenuBar.add(cameraMenu);
    
            toolsMenu.setText("Tools");
            thermalCamMenuBar.add(toolsMenu);
        }
        
        return thermalCamMenuBar;
    }
    
    /**
     * 
     */
    public static JFrame getFrame() {
        JFrame frame = GuiUtils.testFrame(new ThermalCamControlGui());
        frame.setSize(875,750);
        frame.setLocation(500,100);
        frame.setTitle("FLIR Tau 2 Camera Control GUI");       
        frame.setJMenuBar(getMenuBar());
        GuiUtils.setLookAndFeel();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        return frame;
    }
    
}
