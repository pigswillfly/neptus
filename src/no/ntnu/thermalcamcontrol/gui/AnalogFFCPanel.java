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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author liz
 *
 */
class AnalogFFCPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected AnalogFFCPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        
        JLabel analogFFCLabel = new JLabel();
        JLabel ffcWarningLabel = new JLabel();
        JTextField ffcWarningText = new JTextField();
        JLabel ffcWarningUnitLabel = new JLabel();
        
        this.setBorder(BorderFactory.createEtchedBorder());

        analogFFCLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        analogFFCLabel.setText("FFC");

        ffcWarningLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        ffcWarningLabel.setText("FFC Warning: ");

        ffcWarningUnitLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        ffcWarningUnitLabel.setText("frames");

        GroupLayout analogFFCPanelLayout = new GroupLayout(this);
        this.setLayout(analogFFCPanelLayout);
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
    }
}
