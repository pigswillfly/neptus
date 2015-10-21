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
class XpBusOutputPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private JLabel xpBusOutputLabel = null;
    private JRadioButton xpBusOutputCMOSRadioButton = null;
    private JRadioButton xpBusOutputNoneRadioButton = null;
    private JRadioButton xpBusOutputBT656RadioButton = null;
    private ButtonGroup xpBusOutputButtonGroup = null;
    
    protected XpBusOutputPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        xpBusOutputLabel = new JLabel();
        xpBusOutputCMOSRadioButton = new JRadioButton();
        xpBusOutputNoneRadioButton = new JRadioButton();
        xpBusOutputBT656RadioButton = new JRadioButton();
        xpBusOutputButtonGroup = new ButtonGroup();
        
        xpBusOutputButtonGroup.add(xpBusOutputNoneRadioButton);
        xpBusOutputButtonGroup.add(xpBusOutputBT656RadioButton);
        xpBusOutputButtonGroup.add(xpBusOutputCMOSRadioButton);
        
        this.setBorder(BorderFactory.createEtchedBorder());

        xpBusOutputLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        xpBusOutputLabel.setText("XP Bus Output");

        xpBusOutputCMOSRadioButton.setText("CMOS");

        xpBusOutputNoneRadioButton.setText("None");

        xpBusOutputBT656RadioButton.setText("BT.656");

        GroupLayout xpBusOutputPanelLayout = new GroupLayout(this);
        this.setLayout(xpBusOutputPanelLayout);
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
       
        askForCurrentSetting();
    }

    private void askForCurrentSetting(){
        xpBusOutputNoneRadioButton.setSelected(true);
    }
}
