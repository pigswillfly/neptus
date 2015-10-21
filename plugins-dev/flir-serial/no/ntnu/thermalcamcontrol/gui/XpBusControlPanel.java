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

/**
 * @author liz
 *
 */
class XpBusControlPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private JRadioButton xpBusControl14bitRadioButton = null;
    private JLabel xpBusControlLabel = null;
    private JRadioButton xpBusControlOffRadioButton = null;
    private JRadioButton xpBusControl8bitRadioButton = null;
    private ButtonGroup xpBusControlButtonGroup = null;
    
    protected XpBusControlPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        
        xpBusControl14bitRadioButton = new JRadioButton();
        xpBusControlLabel = new JLabel();
        xpBusControlOffRadioButton = new JRadioButton();
        xpBusControl8bitRadioButton = new JRadioButton();
        xpBusControlButtonGroup = new ButtonGroup();
        
        xpBusControlButtonGroup.add(xpBusControlOffRadioButton);
        xpBusControlButtonGroup.add(xpBusControl8bitRadioButton);
        xpBusControlButtonGroup.add(xpBusControl14bitRadioButton);
        
        this.setBorder(BorderFactory.createEtchedBorder());

        xpBusControl14bitRadioButton.setText("14-bit Filtered");

        xpBusControlLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        xpBusControlLabel.setText("XP Bus Control");

        xpBusControlOffRadioButton.setText("Off");

        xpBusControl8bitRadioButton.setText("8-bit");

        GroupLayout xpBusControlPanelLayout = new GroupLayout(this);
        this.setLayout(xpBusControlPanelLayout);
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

    }
}
