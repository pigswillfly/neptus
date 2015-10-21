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
 * Oct 20, 2015
 */
package no.ntnu.thermalcamcontrol.gui;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

/**
 * @author liz
 *
 */
class FfcPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    

    private JLabel ffcLabel = null;
    private JRadioButton ffcAuto = null;
    private JRadioButton ffcManual = null;
    private JRadioButton ffcExternal = null;
    private ButtonGroup ffcButtonGroup = null;
    private JLabel ffcIntervalLabel = null;
    private JTextField ffcIntervalText = null;
    private JLabel ffcIntervalUnitLabel = null;
    private JLabel lowGainFFCIntervalLabel = null;
    private JTextField lowGainFFCIntervalText = null;
    private JLabel lowGainFFCIntervalUnitLabel = null;
    private JLabel tempChangeLabel = null;
    private JTextField tempChangeText = null;
    private JLabel tempChangeUnitLabel = null;
    private JLabel lowGainTempChangeLabel = null;
    private JTextField lowGainTempChangeText = null;
    private JLabel lowGainTempChangeUnitLabel = null;
    private JButton doFFCButton = null;
    private JPanel ssnPanel = null;
    
    protected FfcPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
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
        ssnPanel = new SsnPanel();
        
        ffcButtonGroup.add(ffcManual);
        ffcButtonGroup.add(ffcAuto);
        ffcButtonGroup.add(ffcExternal);
        
        this.setBorder(BorderFactory.createEtchedBorder());

        ffcAuto.setText("Auto");

        tempChangeUnitLabel.setText("0.1 °C");

        ffcLabel.setFont(new java.awt.Font(null, 1, 15)); // NOI18N
        ffcLabel.setText("Flat Field Correction");

        lowGainTempChangeLabel.setFont(new java.awt.Font(null, 0, 12)); // NOI18N
        lowGainTempChangeLabel.setText("Low Gain Temp Change");

        ffcManual.setText("Manual");

        doFFCButton.setText("Do FFC");

        tempChangeLabel.setFont(new java.awt.Font(null, 0, 12)); // NOI18N
        tempChangeLabel.setText("Temp Change");

        lowGainFFCIntervalUnitLabel.setText("frames");

        ffcIntervalUnitLabel.setText("frames");

        ffcIntervalLabel.setFont(new java.awt.Font(null, 0, 12)); // NOI18N
        ffcIntervalLabel.setText("FFC Interval");

        lowGainFFCIntervalLabel.setFont(new java.awt.Font(null, 0, 12)); // NOI18N
        lowGainFFCIntervalLabel.setText("Low Gain FFC Interval");

        lowGainTempChangeUnitLabel.setText("0.1 °C");

        ffcExternal.setText("External");

        GroupLayout ffcPanelLayout = new GroupLayout(this);
        this.setLayout(ffcPanelLayout);
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
    }
    
}
