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
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

/**
 * @author liz
 *
 */
class OrientationPanel extends JPanel {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected OrientationPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        JCheckBox orientationInvertCheckBox = new JCheckBox();
        JCheckBox orientationRevertCheckBox = new JCheckBox();
        JLabel orientationLabel = new JLabel();

        this.setBorder(BorderFactory.createEtchedBorder());

        orientationInvertCheckBox.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        orientationInvertCheckBox.setText("Invert (Flip the image vertically)");

        orientationRevertCheckBox.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        orientationRevertCheckBox.setText("Revert (Flip the image horizontally)");

        orientationLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        orientationLabel.setText("Orientation");

        GroupLayout orientationPanelLayout = new GroupLayout(this);
        this.setLayout(orientationPanelLayout);
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
    }  

}
