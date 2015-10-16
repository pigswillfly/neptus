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

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.JPanel;

/**
 * @author liz
 *
 */
class AnalogPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public AnalogPanel() {
        initComponents();
    }
                        
    private void initComponents() {

        zoomButtonGroup = new ButtonGroup();
        analogVideoOnOffButtonGroup = new ButtonGroup();
        analogVideoColorButtonGroup = new ButtonGroup();
        videoStandardButtonGroup = new ButtonGroup();
        orientationPanel = new JPanel();
        orientationInvertCheckBox = new JCheckBox();
        orientationRevertCheckBox = new JCheckBox();
        orientationLabel = new JLabel();
        polarityPanel = new JPanel();
        polarityLabel = new JLabel();
        analogFFCPanel = new JPanel();
        analogFFCLabel = new JLabel();
        ffcWarningText = new JTextField();
        ffcWarningLabel = new JLabel();
        ffcWarningUnitLabel = new JLabel();
        analogVidoColorPanel = new JPanel();
        analogVideoColorRadioButton = new JRadioButton();
        analogVideoMonochromeRadioButton = new JRadioButton();
        analogVideoColorLabel = new JLabel();
        analogVidOnOffPanel = new JPanel();
        analogVideoOnRadioButton = new JRadioButton();
        analogVideoOffRadioButton = new JRadioButton();
        analogVideoOnOffLabel = new JLabel();
        panZoomPanel = new JPanel();
        zoom2xRadioButton = new JRadioButton();
        unzoomRadioButton = new JRadioButton();
        zoom8xRadioButton = new JRadioButton();
        panZoomLabel = new JLabel();
        eZoomPanel = new JPanel();
        eightXLabel = new JLabel();
        eZoomLabel = new JLabel();
        oneXLabel = new JLabel();
        eZoomSlider = new JSlider();
        zoom4xRadioButton = new JRadioButton();
        eZoomText = new JTextField();
        eZoomValueLabel = new JLabel();
        panSliderPanel = new JPanel();
        horizontalPanSlider = new JSlider();
        panPanel = new JPanel();
        panLabel = new JLabel();
        panCenterButton = new JButton();
        panFineCheckBox = new JCheckBox();
        panText = new JTextField();
        verticalPanSlider = new JSlider();
        videoStandardPanel = new JPanel();
        videoStandardNote1Label = new JLabel();
        videoStandardNote2Label = new JLabel();
        videoStandardNTSCRadioButton = new JRadioButton();
        videoStandardPALRadioButton = new JRadioButton();
        videoStandardLabel = new JLabel();

        zoomButtonGroup.add(unzoomRadioButton);
        zoomButtonGroup.add(zoom2xRadioButton);
        zoomButtonGroup.add(zoom4xRadioButton);
        zoomButtonGroup.add(zoom8xRadioButton);

        analogVideoOnOffButtonGroup.add(analogVideoOnRadioButton);
        analogVideoOnOffButtonGroup.add(analogVideoOffRadioButton);

        analogVideoColorButtonGroup.add(analogVideoColorRadioButton);
        analogVideoColorButtonGroup.add(analogVideoMonochromeRadioButton);

        videoStandardButtonGroup.add(videoStandardNTSCRadioButton);
        videoStandardButtonGroup.add(videoStandardPALRadioButton);

        orientationPanel.setBorder(BorderFactory.createEtchedBorder());

        orientationInvertCheckBox.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        orientationInvertCheckBox.setText("Invert (Flip the image vertically)");
        orientationInvertCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orientationInvertCheckBoxActionPerformed(evt);
            }
        });

        orientationRevertCheckBox.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        orientationRevertCheckBox.setText("Revert (Flip the image horizontally)");

        orientationLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        orientationLabel.setText("Orientation");

        GroupLayout orientationPanelLayout = new GroupLayout(orientationPanel);
        orientationPanel.setLayout(orientationPanelLayout);
        orientationPanelLayout.setHorizontalGroup(
            orientationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(orientationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orientationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(orientationLabel)
                    .addComponent(orientationRevertCheckBox)
                    .addComponent(orientationInvertCheckBox))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        orientationPanelLayout.setVerticalGroup(
            orientationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(orientationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orientationLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orientationInvertCheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orientationRevertCheckBox)
                .addContainerGap())
        );

        polarityPanel.setBorder(BorderFactory.createEtchedBorder());

        ArrayList<String> mList = new ArrayList<String>(2);
        mList.add("WhiteHot");
        mList.add("BlackHot");
        polarityComboBox = new JComboBox<Object>(mList.toArray(new String[mList.size()]));

        polarityLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        polarityLabel.setText("Polarity / Palette");

        GroupLayout polarityPanelLayout = new GroupLayout(polarityPanel);
        polarityPanel.setLayout(polarityPanelLayout);
        polarityPanelLayout.setHorizontalGroup(
            polarityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(polarityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(polarityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(polarityLabel)
                    .addComponent(polarityComboBox, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        polarityPanelLayout.setVerticalGroup(
            polarityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(polarityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(polarityLabel)
                .addGap(26, 26, 26)
                .addComponent(polarityComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        analogFFCPanel.setBorder(BorderFactory.createEtchedBorder());

        analogFFCLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        analogFFCLabel.setText("FFC");

        ffcWarningLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        ffcWarningLabel.setText("FFC Warning: ");

        ffcWarningUnitLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        ffcWarningUnitLabel.setText("frames");

        GroupLayout analogFFCPanelLayout = new GroupLayout(analogFFCPanel);
        analogFFCPanel.setLayout(analogFFCPanelLayout);
        analogFFCPanelLayout.setHorizontalGroup(
            analogFFCPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(analogFFCPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analogFFCPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(analogFFCLabel)
                    .addGroup(analogFFCPanelLayout.createSequentialGroup()
                        .addComponent(ffcWarningLabel)
                        .addGap(2, 2, 2)
                        .addComponent(ffcWarningText, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(ffcWarningUnitLabel)))
                .addContainerGap())
        );
        analogFFCPanelLayout.setVerticalGroup(
            analogFFCPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(analogFFCPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(analogFFCLabel)
                .addGap(26, 26, 26)
                .addGroup(analogFFCPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ffcWarningLabel)
                    .addComponent(ffcWarningText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ffcWarningUnitLabel))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        analogVidoColorPanel.setBorder(BorderFactory.createEtchedBorder());

        analogVideoColorRadioButton.setText("Color");

        analogVideoMonochromeRadioButton.setText("Monochrome");

        analogVideoColorLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        analogVideoColorLabel.setText("Video Color");

        GroupLayout analogVidoColorPanelLayout = new GroupLayout(analogVidoColorPanel);
        analogVidoColorPanel.setLayout(analogVidoColorPanelLayout);
        analogVidoColorPanelLayout.setHorizontalGroup(
            analogVidoColorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(analogVidoColorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analogVidoColorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(analogVideoColorLabel)
                    .addGroup(analogVidoColorPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(analogVidoColorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(analogVideoMonochromeRadioButton)
                            .addComponent(analogVideoColorRadioButton))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        analogVidoColorPanelLayout.setVerticalGroup(
            analogVidoColorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(analogVidoColorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(analogVideoColorLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analogVideoColorRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analogVideoMonochromeRadioButton)
                .addContainerGap())
        );

        analogVideoMonochromeRadioButton.setSelected(true);

        analogVidOnOffPanel.setBorder(BorderFactory.createEtchedBorder());

        analogVideoOnRadioButton.setText("On");

        analogVideoOffRadioButton.setText("Off");

        analogVideoOnOffLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        analogVideoOnOffLabel.setText("Video On / Off");

        GroupLayout analogVidOnOffPanelLayout = new GroupLayout(analogVidOnOffPanel);
        analogVidOnOffPanel.setLayout(analogVidOnOffPanelLayout);
        analogVidOnOffPanelLayout.setHorizontalGroup(
            analogVidOnOffPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(analogVidOnOffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analogVidOnOffPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(analogVideoOnOffLabel)
                    .addGroup(analogVidOnOffPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(analogVidOnOffPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(analogVideoOffRadioButton)
                            .addComponent(analogVideoOnRadioButton))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        analogVidOnOffPanelLayout.setVerticalGroup(
            analogVidOnOffPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(analogVidOnOffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(analogVideoOnOffLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analogVideoOnRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analogVideoOffRadioButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        analogVideoOnRadioButton.setSelected(true);

        panZoomPanel.setBorder(BorderFactory.createEtchedBorder());

        zoom2xRadioButton.setText("Zoom 2x");

        unzoomRadioButton.setText("Unzoom");
        unzoomRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unzoomRadioButtonActionPerformed(evt);
            }
        });

        zoom8xRadioButton.setText("Zoom 8x");

        panZoomLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        panZoomLabel.setText("Pan & Zoom");

        eightXLabel.setText("8x");

        eZoomLabel.setText("EZoom");

        oneXLabel.setText("1x");

        eZoomSlider.setMajorTickSpacing(1);
        eZoomSlider.setMaximum(8);
        eZoomSlider.setMinimum(1);
        eZoomSlider.setPaintLabels(true);
        eZoomSlider.setSnapToTicks(true);
        eZoomSlider.setValue(1);
        eZoomSlider.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                eZoomSliderPropertyChange(evt);
            }
        });

        GroupLayout eZoomPanelLayout = new GroupLayout(eZoomPanel);
        eZoomPanel.setLayout(eZoomPanelLayout);
        eZoomPanelLayout.setHorizontalGroup(
            eZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eZoomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(eZoomPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(oneXLabel)
                        .addGap(41, 41, 41)
                        .addComponent(eZoomLabel)
                        .addGap(45, 45, 45)
                        .addComponent(eightXLabel))
                    .addComponent(eZoomSlider, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        eZoomPanelLayout.setVerticalGroup(
            eZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eZoomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eZoomSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(eZoomLabel)
                    .addComponent(eightXLabel)
                    .addComponent(oneXLabel))
                .addContainerGap())
        );

        zoom4xRadioButton.setText("Zoom 4x");

        eZoomText.setText("1.00");
        eZoomText.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                eZoomTextPropertyChange(evt);
            }
        });

        eZoomValueLabel.setText("EZoom Value (1x - 8x)");

        horizontalPanSlider.setMajorTickSpacing(5);
        horizontalPanSlider.setMaximum(40);
        horizontalPanSlider.setMinimum(-40);
        horizontalPanSlider.setMinorTickSpacing(1);
        horizontalPanSlider.setValue(0);

        panLabel.setText("Pan:");

        panCenterButton.setText("Center");

        panFineCheckBox.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        panFineCheckBox.setText("Fine");

        panText.setText("(0,0)");

        GroupLayout panPanelLayout = new GroupLayout(panPanel);
        panPanel.setLayout(panPanelLayout);
        panPanelLayout.setHorizontalGroup(
            panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panFineCheckBox, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                    .addGroup(GroupLayout.Alignment.TRAILING, panPanelLayout.createSequentialGroup()
                        .addComponent(panLabel)
                        .addGap(18, 18, 18)))
                .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panCenterButton)
                    .addComponent(panText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panPanelLayout.setVerticalGroup(
            panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(panLabel)
                    .addComponent(panText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(panCenterButton)
                    .addComponent(panFineCheckBox))
                .addContainerGap())
        );

        verticalPanSlider.setMajorTickSpacing(5);
        verticalPanSlider.setMaximum(40);
        verticalPanSlider.setMinimum(-40);
        verticalPanSlider.setMinorTickSpacing(1);
        verticalPanSlider.setOrientation(JSlider.VERTICAL);
        verticalPanSlider.setValue(0);

        GroupLayout panSliderPanelLayout = new GroupLayout(panSliderPanel);
        panSliderPanel.setLayout(panSliderPanelLayout);
        panSliderPanelLayout.setHorizontalGroup(
            panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panSliderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panSliderPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(panPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(horizontalPanSlider, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verticalPanSlider, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panSliderPanelLayout.setVerticalGroup(
            panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panSliderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(verticalPanSlider, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panSliderPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(panPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(horizontalPanSlider, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        GroupLayout panZoomPanelLayout = new GroupLayout(panZoomPanel);
        panZoomPanel.setLayout(panZoomPanelLayout);
        panZoomPanelLayout.setHorizontalGroup(
            panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panZoomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panZoomLabel)
                    .addComponent(panSliderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panZoomPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panZoomPanelLayout.createSequentialGroup()
                                .addComponent(unzoomRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(zoom4xRadioButton))
                            .addGroup(panZoomPanelLayout.createSequentialGroup()
                                .addComponent(zoom2xRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(zoom8xRadioButton))
                            .addComponent(eZoomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panZoomPanelLayout.createSequentialGroup()
                                .addComponent(eZoomValueLabel)
                                .addGap(18, 18, 18)
                                .addComponent(eZoomText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panZoomPanelLayout.setVerticalGroup(
            panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panZoomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panZoomLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(unzoomRadioButton)
                    .addComponent(zoom4xRadioButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(zoom2xRadioButton)
                    .addComponent(zoom8xRadioButton))
                .addGap(12, 12, 12)
                .addComponent(eZoomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(eZoomText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(eZoomValueLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panSliderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        unzoomRadioButton.setSelected(true);

        videoStandardPanel.setBorder(BorderFactory.createEtchedBorder());

        videoStandardNote1Label.setText("Note: Perform FFC ");

        videoStandardNote2Label.setText("after switching");

        videoStandardNTSCRadioButton.setText("NTSC");

        videoStandardPALRadioButton.setText("PAL");

        videoStandardLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        videoStandardLabel.setText("Video Standard");

        GroupLayout videoStandardPanelLayout = new GroupLayout(videoStandardPanel);
        videoStandardPanel.setLayout(videoStandardPanelLayout);
        videoStandardPanelLayout.setHorizontalGroup(
            videoStandardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(videoStandardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(videoStandardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(videoStandardPanelLayout.createSequentialGroup()
                        .addComponent(videoStandardNTSCRadioButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(videoStandardPALRadioButton))
                    .addComponent(videoStandardLabel)
                    .addComponent(videoStandardNote1Label)
                    .addComponent(videoStandardNote2Label))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        videoStandardPanelLayout.setVerticalGroup(
            videoStandardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(videoStandardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(videoStandardLabel)
                .addGap(18, 18, 18)
                .addGroup(videoStandardPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(videoStandardPALRadioButton)
                    .addComponent(videoStandardNTSCRadioButton))
                .addGap(18, 18, 18)
                .addComponent(videoStandardNote1Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(videoStandardNote2Label)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        videoStandardPALRadioButton.setSelected(true);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(panZoomPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orientationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(polarityPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(analogVidOnOffPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(videoStandardPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(analogFFCPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(analogVidoColorPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(analogFFCPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orientationPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(polarityPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panZoomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(analogVidOnOffPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(analogVidoColorPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(videoStandardPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void orientationInvertCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        // TODO add your handling code here:
    }                                                         

    private void unzoomRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void eZoomSliderPropertyChange(java.beans.PropertyChangeEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void eZoomTextPropertyChange(java.beans.PropertyChangeEvent evt) {                                         
        // TODO add your handling code here:
    }                                        


    // Variables declaration - do not modify                     
    private JLabel analogFFCLabel;
    private JPanel analogFFCPanel;
    private JPanel analogVidOnOffPanel;
    private ButtonGroup analogVideoColorButtonGroup;
    private JLabel analogVideoColorLabel;
    private JRadioButton analogVideoColorRadioButton;
    private JRadioButton analogVideoMonochromeRadioButton;
    private JRadioButton analogVideoOffRadioButton;
    private ButtonGroup analogVideoOnOffButtonGroup;
    private JLabel analogVideoOnOffLabel;
    private JRadioButton analogVideoOnRadioButton;
    private JPanel analogVidoColorPanel;
    private JLabel eZoomLabel;
    private JPanel eZoomPanel;
    private JSlider eZoomSlider;
    private JTextField eZoomText;
    private JLabel eZoomValueLabel;
    private JLabel eightXLabel;
    private JLabel ffcWarningLabel;
    private JTextField ffcWarningText;
    private JLabel ffcWarningUnitLabel;
    private JSlider horizontalPanSlider;
    private JLabel oneXLabel;
    private JCheckBox orientationInvertCheckBox;
    private JLabel orientationLabel;
    private JPanel orientationPanel;
    private JCheckBox orientationRevertCheckBox;
    private JButton panCenterButton;
    private JCheckBox panFineCheckBox;
    private JLabel panLabel;
    private JPanel panPanel;
    private JPanel panSliderPanel;
    private JTextField panText;
    private JLabel panZoomLabel;
    private JPanel panZoomPanel;
    private JComboBox<?> polarityComboBox;
    private JLabel polarityLabel;
    private JPanel polarityPanel;
    private JRadioButton unzoomRadioButton;
    private JSlider verticalPanSlider;
    private ButtonGroup videoStandardButtonGroup;
    private JLabel videoStandardLabel;
    private JRadioButton videoStandardNTSCRadioButton;
    private JLabel videoStandardNote1Label;
    private JLabel videoStandardNote2Label;
    private JRadioButton videoStandardPALRadioButton;
    private JPanel videoStandardPanel;
    private JRadioButton zoom2xRadioButton;
    private JRadioButton zoom4xRadioButton;
    private JRadioButton zoom8xRadioButton;
    private ButtonGroup zoomButtonGroup;
    
}
