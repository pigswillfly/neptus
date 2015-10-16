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

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.BorderFactory;
import javax.swing.LayoutStyle;

/**
 * @author liz
 *
 */
class DigitalPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public DigitalPanel() {
        initComponents();
    }
    
    private void initComponents() {

        xpBusOutputButtonGroup = new ButtonGroup();
        xpBusControlButtonGroup = new ButtonGroup();
        lvdsControlButtonGroup = new ButtonGroup();
        bayerOrderButtonGroup = new ButtonGroup();
        yOrderButtonGroup = new ButtonGroup();
        ySubSamplingButtonGroup = new ButtonGroup();
        xpBusOutputPanel = new JPanel();
        xpBusOutputLabel = new JLabel();
        xpBusOutputCMOSRadioButton = new JRadioButton();
        xpBusOutputNoneRadioButton = new JRadioButton();
        xpBusOutputBT656RadioButton = new JRadioButton();
        xpBusControlPanel = new JPanel();
        xpBusControl14bitRadioButton = new JRadioButton();
        xpBusControlLabel = new JLabel();
        xpBusControlOffRadioButton = new JRadioButton();
        xpBusControl8bitRadioButton = new JRadioButton();
        eightBitDigitalChannelColorControlPanel = new JPanel();
        eightBitDigitalChannelColorControlLabel = new JLabel();
        bayerOrderPanel = new JPanel();
        bayerOrderGBFilterRadioButton = new JRadioButton();
        bayerOrderGRFilterRadioButton = new JRadioButton();
        bayerOrderRGFilterRadioButton = new JRadioButton();
        bayerOrderLabel = new JLabel();
        bayerOrderBGFilterRadioButton = new JRadioButton();
        ySubSamplingPanel = new JPanel();
        ySubSamplingLabel = new JLabel();
        ySubSamplingCenterRadioButton = new JRadioButton();
        ySubSamplingPositedRadioButton = new JRadioButton();
        yOrderPanel = new JPanel();
        yOrderLabel = new JLabel();
        cFirstRadioButton = new JRadioButton();
        yFirstRadioButton = new JRadioButton();
        colorizationEnableCheckBox = new JCheckBox();
        lvdsControlPanel = new JPanel();
        lvdsControl8bitRadioButton = new JRadioButton();
        lvdsControlOffRadioButton = new JRadioButton();
        lvdsControl14bitRadioButton = new JRadioButton();
        lvdsControlLabel = new JLabel();
        eightBitDigitalChannelOptionsPanel = new JPanel();
        eightBitDigitalChannelOptionsLabel = new JLabel();
        digitalEZoomEnableCheckBox = new JCheckBox();

        xpBusOutputButtonGroup.add(xpBusOutputNoneRadioButton);
        xpBusOutputButtonGroup.add(xpBusOutputBT656RadioButton);
        xpBusOutputButtonGroup.add(xpBusOutputCMOSRadioButton);

        xpBusControlButtonGroup.add(xpBusControlOffRadioButton);
        xpBusControlButtonGroup.add(xpBusControl8bitRadioButton);
        xpBusControlButtonGroup.add(xpBusControl14bitRadioButton);

        lvdsControlButtonGroup.add(lvdsControlOffRadioButton);
        lvdsControlButtonGroup.add(lvdsControl8bitRadioButton);
        lvdsControlButtonGroup.add(lvdsControl14bitRadioButton);

        bayerOrderButtonGroup.add(bayerOrderGBFilterRadioButton);
        bayerOrderButtonGroup.add(bayerOrderGRFilterRadioButton);
        bayerOrderButtonGroup.add(bayerOrderRGFilterRadioButton);
        bayerOrderButtonGroup.add(bayerOrderBGFilterRadioButton);

        yOrderButtonGroup.add(cFirstRadioButton);
        yOrderButtonGroup.add(yFirstRadioButton);

        ySubSamplingButtonGroup.add(ySubSamplingCenterRadioButton);
        ySubSamplingButtonGroup.add(ySubSamplingPositedRadioButton);

        xpBusOutputPanel.setBorder(BorderFactory.createEtchedBorder());

        xpBusOutputLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        xpBusOutputLabel.setText("XP Bus Output");

        xpBusOutputCMOSRadioButton.setText("CMOS");

        xpBusOutputNoneRadioButton.setText("None");

        xpBusOutputBT656RadioButton.setText("BT.656");

        GroupLayout xpBusOutputPanelLayout = new GroupLayout(xpBusOutputPanel);
        xpBusOutputPanel.setLayout(xpBusOutputPanelLayout);
        xpBusOutputPanelLayout.setHorizontalGroup(
            xpBusOutputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(xpBusOutputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(xpBusOutputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(xpBusOutputLabel)
                    .addGroup(xpBusOutputPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(xpBusOutputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(xpBusOutputCMOSRadioButton)
                            .addComponent(xpBusOutputBT656RadioButton)
                            .addComponent(xpBusOutputNoneRadioButton))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        xpBusOutputPanelLayout.setVerticalGroup(
            xpBusOutputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(xpBusOutputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xpBusOutputLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xpBusOutputNoneRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xpBusOutputBT656RadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xpBusOutputCMOSRadioButton)
                .addContainerGap())
        );

        xpBusOutputNoneRadioButton.setSelected(true);

        xpBusControlPanel.setBorder(BorderFactory.createEtchedBorder());

        xpBusControl14bitRadioButton.setText("14-bit Filtered");

        xpBusControlLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        xpBusControlLabel.setText("XP Bus Control");

        xpBusControlOffRadioButton.setText("Off");

        xpBusControl8bitRadioButton.setText("8-bit");

        GroupLayout xpBusControlPanelLayout = new GroupLayout(xpBusControlPanel);
        xpBusControlPanel.setLayout(xpBusControlPanelLayout);
        xpBusControlPanelLayout.setHorizontalGroup(
            xpBusControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(xpBusControlPanelLayout.createSequentialGroup()
                .addGroup(xpBusControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(xpBusControlPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(xpBusControlLabel))
                    .addGroup(xpBusControlPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(xpBusControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(xpBusControlOffRadioButton)
                            .addComponent(xpBusControl8bitRadioButton)
                            .addComponent(xpBusControl14bitRadioButton))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        xpBusControlPanelLayout.setVerticalGroup(
            xpBusControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(xpBusControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xpBusControlLabel)
                .addGap(18, 18, 18)
                .addComponent(xpBusControlOffRadioButton)
                .addGap(10, 10, 10)
                .addComponent(xpBusControl8bitRadioButton)
                .addGap(10, 10, 10)
                .addComponent(xpBusControl14bitRadioButton)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        xpBusControlOffRadioButton.setSelected(true);

        eightBitDigitalChannelColorControlPanel.setBorder(BorderFactory.createEtchedBorder());

        eightBitDigitalChannelColorControlLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        eightBitDigitalChannelColorControlLabel.setText("8-bit Digital Channel Colorization Controls");

        bayerOrderPanel.setBorder(BorderFactory.createEtchedBorder());

        bayerOrderGBFilterRadioButton.setText("GB Filter");

        bayerOrderGRFilterRadioButton.setText("GR Filter");

        bayerOrderRGFilterRadioButton.setText("RG Filter");

        bayerOrderLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        bayerOrderLabel.setText("Bayer Order");

        bayerOrderBGFilterRadioButton.setText("BG Filter");

        GroupLayout bayerOrderPanelLayout = new GroupLayout(bayerOrderPanel);
        bayerOrderPanel.setLayout(bayerOrderPanelLayout);
        bayerOrderPanelLayout.setHorizontalGroup(
            bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bayerOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(bayerOrderLabel)
                    .addGroup(bayerOrderPanelLayout.createSequentialGroup()
                        .addGroup(bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(bayerOrderGRFilterRadioButton)
                            .addComponent(bayerOrderGBFilterRadioButton))
                        .addGap(32, 32, 32)
                        .addGroup(bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(bayerOrderBGFilterRadioButton)
                            .addComponent(bayerOrderRGFilterRadioButton))))
                .addContainerGap())
        );
        bayerOrderPanelLayout.setVerticalGroup(
            bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bayerOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bayerOrderLabel)
                .addGap(18, 18, 18)
                .addGroup(bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bayerOrderGRFilterRadioButton)
                    .addComponent(bayerOrderBGFilterRadioButton))
                .addGap(7, 7, 7)
                .addGroup(bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bayerOrderGBFilterRadioButton)
                    .addComponent(bayerOrderRGFilterRadioButton))
                .addContainerGap())
        );

        bayerOrderGRFilterRadioButton.setSelected(true);

        ySubSamplingPanel.setBorder(BorderFactory.createEtchedBorder());

        ySubSamplingLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        ySubSamplingLabel.setText("YCbCr Sub-Sampling");

        ySubSamplingCenterRadioButton.setText("422 Center");

        ySubSamplingPositedRadioButton.setText("422 Posited");

        GroupLayout ySubSamplingPanelLayout = new GroupLayout(ySubSamplingPanel);
        ySubSamplingPanel.setLayout(ySubSamplingPanelLayout);
        ySubSamplingPanelLayout.setHorizontalGroup(
            ySubSamplingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ySubSamplingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ySubSamplingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(ySubSamplingLabel)
                    .addGroup(ySubSamplingPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(ySubSamplingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(ySubSamplingPositedRadioButton)
                            .addComponent(ySubSamplingCenterRadioButton))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ySubSamplingPanelLayout.setVerticalGroup(
            ySubSamplingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ySubSamplingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ySubSamplingLabel)
                .addGap(18, 18, 18)
                .addComponent(ySubSamplingCenterRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ySubSamplingPositedRadioButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        yOrderPanel.setBorder(BorderFactory.createEtchedBorder());

        yOrderLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        yOrderLabel.setText("YCbCr Order");

        cFirstRadioButton.setText("CbYCrY");
        cFirstRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cFirstRadioButtonActionPerformed(evt);
            }
        });

        yFirstRadioButton.setText("YCbYCr");

        GroupLayout yOrderPanelLayout = new GroupLayout(yOrderPanel);
        yOrderPanel.setLayout(yOrderPanelLayout);
        yOrderPanelLayout.setHorizontalGroup(
            yOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(yOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(yOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(yOrderLabel)
                    .addGroup(yOrderPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(yOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(yFirstRadioButton)
                            .addComponent(cFirstRadioButton))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        yOrderPanelLayout.setVerticalGroup(
            yOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(yOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yOrderLabel)
                .addGap(18, 18, 18)
                .addComponent(cFirstRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yFirstRadioButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        colorizationEnableCheckBox.setText("Colorization Enable");

        GroupLayout eightBitDigitalChannelColorControlPanelLayout = new GroupLayout(eightBitDigitalChannelColorControlPanel);
        eightBitDigitalChannelColorControlPanel.setLayout(eightBitDigitalChannelColorControlPanelLayout);
        eightBitDigitalChannelColorControlPanelLayout.setHorizontalGroup(
            eightBitDigitalChannelColorControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitDigitalChannelColorControlPanelLayout.createSequentialGroup()
                .addGroup(eightBitDigitalChannelColorControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(eightBitDigitalChannelColorControlPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(eightBitDigitalChannelColorControlLabel))
                    .addGroup(eightBitDigitalChannelColorControlPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(eightBitDigitalChannelColorControlPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ySubSamplingPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yOrderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bayerOrderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(GroupLayout.Alignment.LEADING, eightBitDigitalChannelColorControlPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(colorizationEnableCheckBox)))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        eightBitDigitalChannelColorControlPanelLayout.setVerticalGroup(
            eightBitDigitalChannelColorControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitDigitalChannelColorControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eightBitDigitalChannelColorControlLabel)
                .addGap(18, 18, 18)
                .addComponent(bayerOrderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ySubSamplingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yOrderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(colorizationEnableCheckBox)
                .addGap(21, 21, 21))
        );

        lvdsControlPanel.setBorder(BorderFactory.createEtchedBorder());

        lvdsControl8bitRadioButton.setText("8-bit");

        lvdsControlOffRadioButton.setText("Off");

        lvdsControl14bitRadioButton.setText("14-bit Filtered");

        lvdsControlLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lvdsControlLabel.setText("LVDS Control");

        GroupLayout lvdsControlPanelLayout = new GroupLayout(lvdsControlPanel);
        lvdsControlPanel.setLayout(lvdsControlPanelLayout);
        lvdsControlPanelLayout.setHorizontalGroup(
            lvdsControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(lvdsControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lvdsControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(lvdsControlPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(lvdsControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lvdsControlOffRadioButton)
                            .addComponent(lvdsControl8bitRadioButton)
                            .addComponent(lvdsControl14bitRadioButton)))
                    .addComponent(lvdsControlLabel))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        lvdsControlPanelLayout.setVerticalGroup(
            lvdsControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(lvdsControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lvdsControlLabel)
                .addGap(18, 18, 18)
                .addComponent(lvdsControlOffRadioButton)
                .addGap(10, 10, 10)
                .addComponent(lvdsControl8bitRadioButton)
                .addGap(10, 10, 10)
                .addComponent(lvdsControl14bitRadioButton)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        xpBusControlOffRadioButton.setSelected(true);

        eightBitDigitalChannelOptionsPanel.setBorder(BorderFactory.createEtchedBorder());

        eightBitDigitalChannelOptionsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        eightBitDigitalChannelOptionsLabel.setText("8-bit Digital Channel Options");

        digitalEZoomEnableCheckBox.setText("Digital EZoom enable");
        digitalEZoomEnableCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitalEZoomEnableCheckBoxActionPerformed(evt);
            }
        });

        GroupLayout eightBitDigitalChannelOptionsPanelLayout = new GroupLayout(eightBitDigitalChannelOptionsPanel);
        eightBitDigitalChannelOptionsPanel.setLayout(eightBitDigitalChannelOptionsPanelLayout);
        eightBitDigitalChannelOptionsPanelLayout.setHorizontalGroup(
            eightBitDigitalChannelOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitDigitalChannelOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eightBitDigitalChannelOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(eightBitDigitalChannelOptionsLabel)
                    .addGroup(eightBitDigitalChannelOptionsPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(digitalEZoomEnableCheckBox)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        eightBitDigitalChannelOptionsPanelLayout.setVerticalGroup(
            eightBitDigitalChannelOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitDigitalChannelOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eightBitDigitalChannelOptionsLabel)
                .addGap(18, 18, 18)
                .addComponent(digitalEZoomEnableCheckBox)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(xpBusOutputPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eightBitDigitalChannelOptionsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(xpBusControlPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lvdsControlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(eightBitDigitalChannelColorControlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(xpBusOutputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eightBitDigitalChannelOptionsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(eightBitDigitalChannelColorControlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(xpBusControlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lvdsControlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void cFirstRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void digitalEZoomEnableCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                           
        // TODO add your handling code here:
    }                                                          


    // Variables declaration - do not modify                     
    private JRadioButton bayerOrderBGFilterRadioButton;
    private ButtonGroup bayerOrderButtonGroup;
    private JRadioButton bayerOrderGBFilterRadioButton;
    private JRadioButton bayerOrderGRFilterRadioButton;
    private JLabel bayerOrderLabel;
    private JPanel bayerOrderPanel;
    private JRadioButton bayerOrderRGFilterRadioButton;
    private JRadioButton cFirstRadioButton;
    private JCheckBox colorizationEnableCheckBox;
    private JCheckBox digitalEZoomEnableCheckBox;
    private JLabel eightBitDigitalChannelColorControlLabel;
    private JPanel eightBitDigitalChannelColorControlPanel;
    private JLabel eightBitDigitalChannelOptionsLabel;
    private JPanel eightBitDigitalChannelOptionsPanel;
    private JRadioButton lvdsControl14bitRadioButton;
    private JRadioButton lvdsControl8bitRadioButton;
    private ButtonGroup lvdsControlButtonGroup;
    private JLabel lvdsControlLabel;
    private JRadioButton lvdsControlOffRadioButton;
    private JPanel lvdsControlPanel;
    private JRadioButton xpBusControl14bitRadioButton;
    private JRadioButton xpBusControl8bitRadioButton;
    private ButtonGroup xpBusControlButtonGroup;
    private JLabel xpBusControlLabel;
    private JRadioButton xpBusControlOffRadioButton;
    private JPanel xpBusControlPanel;
    private JRadioButton xpBusOutputBT656RadioButton;
    private ButtonGroup xpBusOutputButtonGroup;
    private JRadioButton xpBusOutputCMOSRadioButton;
    private JLabel xpBusOutputLabel;
    private JRadioButton xpBusOutputNoneRadioButton;
    private JPanel xpBusOutputPanel;
    private JRadioButton yFirstRadioButton;
    private ButtonGroup yOrderButtonGroup;
    private JLabel yOrderLabel;
    private JPanel yOrderPanel;
    private ButtonGroup ySubSamplingButtonGroup;
    private JRadioButton ySubSamplingCenterRadioButton;
    private JLabel ySubSamplingLabel;
    private JPanel ySubSamplingPanel;
    private JRadioButton ySubSamplingPositedRadioButton;
    // End of variables declaration                   
}
