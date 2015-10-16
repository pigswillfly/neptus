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

//import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.BorderFactory;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;

//import pt.lsts.neptus.util.GuiUtils;

/**
 * @author liz
 *
 */
class SetupPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
    // Variable Declarations
    private JPanel          ffcPanel;
    private JLabel          ffcLabel;    
    private JRadioButton    ffcAuto;
    private JRadioButton    ffcManual;   
    private JRadioButton    ffcExternal;    
    private ButtonGroup     ffcButtonGroup;
    private JLabel          ffcIntervalLabel;
    private JTextField      ffcIntervalText;
    private JLabel          ffcIntervalUnitLabel;
    private JLabel          lowGainFFCIntervalLabel;
    private JTextField      lowGainFFCIntervalText;
    private JLabel          lowGainFFCIntervalUnitLabel;
    private JLabel          tempChangeLabel;
    private JTextField      tempChangeText;
    private JLabel          tempChangeUnitLabel;    
    private JLabel          lowGainTempChangeLabel;
    private JTextField      lowGainTempChangeText;
    private JLabel          lowGainTempChangeUnitLabel;     
    private JButton         doFFCButton;
    
    private JPanel          ssnPanel;    
    private JLabel          ssnLabel;
    private JCheckBox       enableSSNCheckbox;    
    private JCheckBox       withShutterCheckbox;
    private JComboBox<?>    ssnComboBox;

    private JPanel          operatingModePanel;    
    private JLabel          operatingModeLabel;   
    private JRadioButton    operatingModeFrozenRadioButton;
    private JRadioButton    operatingModeRealTimeRadioButton;  
    private ButtonGroup     operatingModeButtonGroup;    
    
    private JPanel          gainModePanel;
    private JLabel          gainModeLabel;
    private JRadioButton    gainModeAutoRadioButton;
    private JRadioButton    gainModeHighRadioButton;
    private JRadioButton    gainModeLowRadioButton;
    private ButtonGroup     gainModeButtonGroup;
    
    private JPanel          testPatternPanel;
    private JLabel          testPatternLabel;
    private JRadioButton    testPatternOffRadioButton;
    private JRadioButton    testPatternRampRadioButton;
    private ButtonGroup     testPatternButtonGroup;

    private JPanel          externalSyncPanel;  
    private JLabel          externalSyncLabel;
    private JRadioButton    externalSyncDisableRadioButton;
    private JRadioButton    externalSyncMasterRadioButton;
    private JRadioButton    externalSyncSlaveRadioButton;
    private ButtonGroup     externalSyncButtonGroup; 
    
    private JPanel          scratchPadPanel;
    private JLabel          scratchPadLabel;
    private JScrollPane     scratchPadScrollPane;
    private JTextArea       scratchPadText;
    private JButton         scratchPadReadButton;
    private JButton         scratchPadWriteButton;
    
    private JPanel          settingsButtonsPanel;
    private JButton         saveSettingsButton;
    private JButton         factoryDefaultsButton;  
    private JButton         resetCameraButton;

    
    public SetupPanel() {
        initialize();
    }
                        
    private void initialize() {
        
        // FFC Panel
        ffcPanel = new JPanel();
        ffcLabel = new JLabel();
        ffcAuto = new JRadioButton();
        ffcManual = new JRadioButton();
        ffcExternal = new JRadioButton();
        ffcButtonGroup = new ButtonGroup();
        ffcIntervalLabel = new JLabel();
        ffcIntervalText = new JTextField();
        ffcIntervalUnitLabel = new JLabel();
        lowGainFFCIntervalLabel = new JLabel();
        lowGainFFCIntervalText = new JTextField();
        lowGainFFCIntervalUnitLabel = new JLabel();
        tempChangeLabel = new JLabel();
        tempChangeText = new JTextField();
        tempChangeUnitLabel = new JLabel();
        lowGainTempChangeLabel = new JLabel();
        lowGainTempChangeText = new JTextField();
        lowGainTempChangeUnitLabel = new JLabel();
        doFFCButton = new JButton();
        ssnPanel = new JPanel();
        ssnLabel = new JLabel();
        enableSSNCheckbox = new JCheckBox();
        withShutterCheckbox = new JCheckBox();
        ssnComboBox = new JComboBox<Object>();
        
        // Operating Mode Panel
        operatingModePanel = new JPanel();
        operatingModeLabel = new JLabel();
        operatingModeRealTimeRadioButton = new JRadioButton();
        operatingModeFrozenRadioButton = new JRadioButton();
        operatingModeButtonGroup = new ButtonGroup();
        
        // Test Pattern Panel
        testPatternPanel = new JPanel();
        testPatternLabel = new JLabel();
        testPatternRampRadioButton = new JRadioButton();
        testPatternOffRadioButton = new JRadioButton();
        testPatternButtonGroup = new ButtonGroup();
        
        // Gain Mode Panel
        gainModePanel = new JPanel();
        gainModeLabel = new JLabel();
        gainModeLowRadioButton = new JRadioButton();
        gainModeHighRadioButton = new JRadioButton();
        gainModeAutoRadioButton = new JRadioButton();
        gainModeButtonGroup = new ButtonGroup();
        
        // External Sync Panel
        externalSyncPanel = new JPanel();
        externalSyncLabel = new JLabel();
        externalSyncSlaveRadioButton = new JRadioButton();
        externalSyncMasterRadioButton = new JRadioButton();
        externalSyncDisableRadioButton = new JRadioButton();
        externalSyncButtonGroup = new ButtonGroup();

        // Scratch Pad Panel
        scratchPadPanel = new JPanel();
        scratchPadLabel = new JLabel();
        scratchPadWriteButton = new JButton();
        scratchPadReadButton = new JButton();
        scratchPadScrollPane = new JScrollPane();
        scratchPadText = new JTextArea();
        
        // Settings Buttons Panel
        settingsButtonsPanel = new JPanel();
        factoryDefaultsButton = new JButton();
        resetCameraButton = new JButton();
        saveSettingsButton = new JButton();

        // Button Groups
        ffcButtonGroup.add(ffcManual);
        ffcButtonGroup.add(ffcAuto);
        ffcButtonGroup.add(ffcExternal);

        operatingModeButtonGroup.add(operatingModeFrozenRadioButton);
        operatingModeButtonGroup.add(operatingModeRealTimeRadioButton);

        gainModeButtonGroup.add(gainModeAutoRadioButton);
        gainModeButtonGroup.add(gainModeLowRadioButton);
        gainModeButtonGroup.add(gainModeHighRadioButton);

        testPatternButtonGroup.add(testPatternOffRadioButton);
        testPatternButtonGroup.add(testPatternRampRadioButton);

        externalSyncButtonGroup.add(externalSyncDisableRadioButton);
        externalSyncButtonGroup.add(externalSyncSlaveRadioButton);
        externalSyncButtonGroup.add(externalSyncMasterRadioButton);

        
        /* FFC Panel */
        ffcPanel.setBorder(BorderFactory.createEtchedBorder());
        ffcPanel.setToolTipText("");

        ffcAuto.setText("Auto");
        ffcAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ffcAutoActionPerformed(evt);
            }
        });

        tempChangeUnitLabel.setText("0.1 °C");

        ffcLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        ffcLabel.setText("Flat Field Correction");

        lowGainFFCIntervalText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowGainFFCIntervalTextActionPerformed(evt);
            }
        });

        lowGainTempChangeLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lowGainTempChangeLabel.setText("Low Gain Temp Change");

        ffcManual.setText("Manual");
        ffcManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ffcManualActionPerformed(evt);
            }
        });

        ssnPanel.setBorder(BorderFactory.createEtchedBorder());

        enableSSNCheckbox.setText("Enable SSN");

        ssnLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        ssnLabel.setText("SSN");

        withShutterCheckbox.setText("With Shutter");

        GroupLayout ssnPanelLayout = new GroupLayout(ssnPanel);
        ssnPanel.setLayout(ssnPanelLayout);
        ssnPanelLayout.setHorizontalGroup(
            ssnPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ssnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ssnPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(ssnLabel)
                    .addComponent(enableSSNCheckbox)
                    .addGroup(ssnPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(ssnPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(withShutterCheckbox)
                            .addComponent(ssnComboBox, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ssnPanelLayout.setVerticalGroup(
            ssnPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ssnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ssnLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enableSSNCheckbox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(withShutterCheckbox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ssnComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        doFFCButton.setText("Do FFC");

        tempChangeLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        tempChangeLabel.setText("Temp Change");

        lowGainFFCIntervalUnitLabel.setText("frames");

        ffcIntervalUnitLabel.setText("frames");

        lowGainTempChangeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowGainTempChangeTextActionPerformed(evt);
            }
        });

        ffcIntervalLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        ffcIntervalLabel.setText("FFC Interval");

        lowGainFFCIntervalLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lowGainFFCIntervalLabel.setText("Low Gain FFC Interval");

        lowGainTempChangeUnitLabel.setText("0.1 °C");

        ffcExternal.setText("External");

        GroupLayout ffcPanelLayout = new GroupLayout(ffcPanel);
        ffcPanel.setLayout(ffcPanelLayout);
        ffcPanelLayout.setHorizontalGroup(
            ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ffcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ssnPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ffcLabel, GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.LEADING, ffcPanelLayout.createSequentialGroup()
                        .addComponent(ffcManual)
                        .addGap(18, 18, 18)
                        .addComponent(ffcAuto)
                        .addGap(18, 18, 18)
                        .addComponent(ffcExternal))
                    .addComponent(doFFCButton)
                    .addGroup(ffcPanelLayout.createSequentialGroup()
                        .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(ffcIntervalLabel)
                            .addComponent(lowGainTempChangeLabel)
                            .addComponent(tempChangeLabel)
                            .addComponent(lowGainFFCIntervalLabel))
                        .addGap(18, 18, 18)
                        .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(ffcPanelLayout.createSequentialGroup()
                                .addComponent(lowGainTempChangeText, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lowGainTempChangeUnitLabel))
                            .addGroup(ffcPanelLayout.createSequentialGroup()
                                .addComponent(tempChangeText)
                                .addGap(18, 18, 18)
                                .addComponent(tempChangeUnitLabel))
                            .addGroup(ffcPanelLayout.createSequentialGroup()
                                .addComponent(lowGainFFCIntervalText)
                                .addGap(18, 18, 18)
                                .addComponent(lowGainFFCIntervalUnitLabel))
                            .addGroup(ffcPanelLayout.createSequentialGroup()
                                .addComponent(ffcIntervalText)
                                .addGap(18, 18, 18)
                                .addComponent(ffcIntervalUnitLabel)))))
                .addContainerGap())
        );

        ffcPanelLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {ffcIntervalText, lowGainFFCIntervalText, lowGainTempChangeText, tempChangeText});

        ffcPanelLayout.setVerticalGroup(
            ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ffcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ffcLabel)
                .addGap(18, 18, 18)
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ffcManual)
                    .addComponent(ffcAuto)
                    .addComponent(ffcExternal))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ffcIntervalText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ffcIntervalLabel)
                    .addComponent(ffcIntervalUnitLabel))
                .addGap(18, 18, 18)
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lowGainFFCIntervalText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowGainFFCIntervalLabel)
                    .addComponent(lowGainFFCIntervalUnitLabel))
                .addGap(18, 18, 18)
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tempChangeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tempChangeLabel)
                    .addComponent(tempChangeUnitLabel))
                .addGap(18, 18, 18)
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lowGainTempChangeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowGainTempChangeLabel)
                    .addComponent(lowGainTempChangeUnitLabel))
                .addGap(18, 18, 18)
                .addComponent(doFFCButton)
                .addGap(18, 18, 18)
                .addComponent(ssnPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        ffcManual.setSelected(true);

        operatingModePanel.setBorder(BorderFactory.createEtchedBorder());

        operatingModeLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        operatingModeLabel.setText("Operating Mode");

        operatingModeRealTimeRadioButton.setText("Real Time");

        operatingModeFrozenRadioButton.setText("Frozen");

        GroupLayout operatingModePanelLayout = new GroupLayout(operatingModePanel);
        operatingModePanel.setLayout(operatingModePanelLayout);
        operatingModePanelLayout.setHorizontalGroup(
            operatingModePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(operatingModePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(operatingModePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(operatingModeFrozenRadioButton)
                    .addComponent(operatingModeRealTimeRadioButton)
                    .addComponent(operatingModeLabel))
                .addContainerGap())
        );
        operatingModePanelLayout.setVerticalGroup(
            operatingModePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(operatingModePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(operatingModeLabel)
                .addGap(18, 18, 18)
                .addComponent(operatingModeRealTimeRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(operatingModeFrozenRadioButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        operatingModeRealTimeRadioButton.setSelected(true);

        testPatternPanel.setBorder(BorderFactory.createEtchedBorder());

        testPatternLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        testPatternLabel.setText("Test Pattern");

        testPatternRampRadioButton.setText("Ramp");

        testPatternOffRadioButton.setText("Off");

        GroupLayout testPatternPanelLayout = new GroupLayout(testPatternPanel);
        testPatternPanel.setLayout(testPatternPanelLayout);
        testPatternPanelLayout.setHorizontalGroup(
            testPatternPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(testPatternPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(testPatternPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(testPatternLabel)
                    .addComponent(testPatternOffRadioButton)
                    .addComponent(testPatternRampRadioButton))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        testPatternPanelLayout.setVerticalGroup(
            testPatternPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(testPatternPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testPatternLabel)
                .addGap(18, 18, 18)
                .addComponent(testPatternOffRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(testPatternRampRadioButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        testPatternOffRadioButton.setSelected(true);

        externalSyncPanel.setBorder(BorderFactory.createEtchedBorder());

        externalSyncSlaveRadioButton.setText("Slave");

        externalSyncMasterRadioButton.setText("Master");
        externalSyncMasterRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                externalSyncMasterRadioButtonActionPerformed(evt);
            }
        });

        externalSyncDisableRadioButton.setText("Disable");

        externalSyncLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        externalSyncLabel.setText("External Sync");

        GroupLayout externalSyncPanelLayout = new GroupLayout(externalSyncPanel);
        externalSyncPanel.setLayout(externalSyncPanelLayout);
        externalSyncPanelLayout.setHorizontalGroup(
            externalSyncPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(externalSyncPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(externalSyncPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(externalSyncDisableRadioButton)
                    .addComponent(externalSyncLabel)
                    .addComponent(externalSyncSlaveRadioButton)
                    .addComponent(externalSyncMasterRadioButton))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        externalSyncPanelLayout.setVerticalGroup(
            externalSyncPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(externalSyncPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(externalSyncLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(externalSyncDisableRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(externalSyncSlaveRadioButton)
                .addGap(12, 12, 12)
                .addComponent(externalSyncMasterRadioButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        externalSyncDisableRadioButton.setSelected(true);

        gainModePanel.setBorder(BorderFactory.createEtchedBorder());

        gainModeLowRadioButton.setText("Low");

        gainModeHighRadioButton.setText("High");

        gainModeAutoRadioButton.setText("Auto");

        gainModeLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        gainModeLabel.setText("Gain Mode");

        GroupLayout gainModePanelLayout = new GroupLayout(gainModePanel);
        gainModePanel.setLayout(gainModePanelLayout);
        gainModePanelLayout.setHorizontalGroup(
            gainModePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(gainModePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gainModePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(gainModeAutoRadioButton)
                    .addComponent(gainModeLabel)
                    .addComponent(gainModeLowRadioButton)
                    .addComponent(gainModeHighRadioButton))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        gainModePanelLayout.setVerticalGroup(
            gainModePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(gainModePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gainModeLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gainModeAutoRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gainModeLowRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gainModeHighRadioButton)
                .addContainerGap())
        );

        gainModeAutoRadioButton.setSelected(true);

        scratchPadPanel.setBorder(BorderFactory.createEtchedBorder());

        scratchPadLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        scratchPadLabel.setText("Scratch Pad");

        scratchPadWriteButton.setText("Write");

        scratchPadReadButton.setText("Read");

        scratchPadText.setColumns(20);
        scratchPadText.setRows(5);
        scratchPadScrollPane.setViewportView(scratchPadText);

        GroupLayout scratchPadPanelLayout = new GroupLayout(scratchPadPanel);
        scratchPadPanel.setLayout(scratchPadPanelLayout);
        scratchPadPanelLayout.setHorizontalGroup(
            scratchPadPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(scratchPadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scratchPadPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scratchPadLabel)
                    .addGroup(scratchPadPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(scratchPadPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(scratchPadPanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(scratchPadReadButton)
                                .addGap(42, 42, 42)
                                .addComponent(scratchPadWriteButton))
                            .addComponent(scratchPadScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        scratchPadPanelLayout.setVerticalGroup(
            scratchPadPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(scratchPadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scratchPadLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scratchPadScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scratchPadPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(scratchPadWriteButton)
                    .addComponent(scratchPadReadButton))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        factoryDefaultsButton.setText("Factory Defaults");

        resetCameraButton.setText("Reset Camera");

        saveSettingsButton.setText("Save Settings");

        GroupLayout settingsButtonsPanelLayout = new GroupLayout(settingsButtonsPanel);
        settingsButtonsPanel.setLayout(settingsButtonsPanelLayout);
        settingsButtonsPanelLayout.setHorizontalGroup(
            settingsButtonsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, settingsButtonsPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveSettingsButton)
                .addGap(84, 84, 84)
                .addComponent(factoryDefaultsButton)
                .addGap(80, 80, 80)
                .addComponent(resetCameraButton)
                .addGap(71, 71, 71))
        );
        settingsButtonsPanelLayout.setVerticalGroup(
            settingsButtonsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(settingsButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingsButtonsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(saveSettingsButton)
                    .addGroup(settingsButtonsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(factoryDefaultsButton)
                        .addComponent(resetCameraButton)))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(settingsButtonsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ffcPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(operatingModePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gainModePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(testPatternPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(externalSyncPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(scratchPadPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(testPatternPanel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(operatingModePanel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(gainModePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(externalSyncPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(scratchPadPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(ffcPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(settingsButtonsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void ffcAutoActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void lowGainFFCIntervalTextActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void ffcManualActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void lowGainTempChangeTextActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    private void externalSyncMasterRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                              
        // TODO add your handling code here:
    }                                                             

    // Variables declaration - do not modify                     

    // End of variables declaration          

}
