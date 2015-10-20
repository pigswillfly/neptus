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
class LvdsControlPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected LvdsControlPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        JRadioButton lvdsControl8bitRadioButton = new JRadioButton();
        JRadioButton lvdsControlOffRadioButton = new JRadioButton();
        JRadioButton lvdsControl14bitRadioButton = new JRadioButton();
        JLabel lvdsControlLabel = new JLabel();
        ButtonGroup lvdsControlButtonGroup = new ButtonGroup();        
        lvdsControlButtonGroup.add(lvdsControlOffRadioButton);
        lvdsControlButtonGroup.add(lvdsControl8bitRadioButton);
        lvdsControlButtonGroup.add(lvdsControl14bitRadioButton);
        
        this.setBorder(BorderFactory.createEtchedBorder());

        lvdsControl8bitRadioButton.setText("8-bit");

        lvdsControlOffRadioButton.setText("Off");

        lvdsControl14bitRadioButton.setText("14-bit Filtered");

        lvdsControlLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lvdsControlLabel.setText("LVDS Control");

        GroupLayout lvdsControlPanelLayout = new GroupLayout(this);
        this.setLayout(lvdsControlPanelLayout);
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
    }
}
