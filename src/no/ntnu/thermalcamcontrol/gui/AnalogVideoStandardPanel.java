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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;

/**
 * @author liz
 *
 */
class AnalogVideoStandardPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected AnalogVideoStandardPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        
        JLabel videoStandardLabel = new JLabel();
        JLabel videoStandardNote1Label = new JLabel();
        JLabel videoStandardNote2Label = new JLabel();
        JRadioButton videoStandardNTSCRadioButton = new JRadioButton();
        JRadioButton videoStandardPALRadioButton = new JRadioButton();
        ButtonGroup videoStandardButtonGroup = new ButtonGroup();
        videoStandardButtonGroup.add(videoStandardNTSCRadioButton);
        videoStandardButtonGroup.add(videoStandardPALRadioButton);

        this.setBorder(BorderFactory.createEtchedBorder());

        videoStandardNote1Label.setText("Note: Perform FFC ");

        videoStandardNote2Label.setText("after switching");

        videoStandardNTSCRadioButton.setText("NTSC");

        videoStandardPALRadioButton.setText("PAL");

        videoStandardLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        videoStandardLabel.setText("Video Standard");

        GroupLayout videoStandardPanelLayout = new GroupLayout(this);
        this.setLayout(videoStandardPanelLayout);
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
    }
}
