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
class AnalogVideoOnOffPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private JRadioButton analogVideoOnRadioButton = null;
    private JRadioButton analogVideoOffRadioButton = null;
    private JLabel analogVideoOnOffLabel = null;
    private ButtonGroup analogVideoOnOffButtonGroup = null;
    
    protected AnalogVideoOnOffPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        analogVideoOnRadioButton = new JRadioButton();
        analogVideoOffRadioButton = new JRadioButton();
        analogVideoOnOffLabel = new JLabel();
        analogVideoOnOffButtonGroup = new ButtonGroup();
        
        analogVideoOnOffButtonGroup.add(analogVideoOnRadioButton);
        analogVideoOnOffButtonGroup.add(analogVideoOffRadioButton);
        
        this.setBorder(BorderFactory.createEtchedBorder());

        analogVideoOnRadioButton.setText("On");

        analogVideoOffRadioButton.setText("Off");

        analogVideoOnOffLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        analogVideoOnOffLabel.setText("Video On / Off");

        GroupLayout analogVideoOnOffPanelLayout = new GroupLayout(this);
        this.setLayout(analogVideoOnOffPanelLayout);
        analogVideoOnOffPanelLayout.setHorizontalGroup(
            analogVideoOnOffPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(analogVideoOnOffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analogVideoOnOffPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(analogVideoOnOffLabel)
                    .addGroup(analogVideoOnOffPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(analogVideoOnOffPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(analogVideoOffRadioButton)
                            .addComponent(analogVideoOnRadioButton))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        analogVideoOnOffPanelLayout.setVerticalGroup(
            analogVideoOnOffPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(analogVideoOnOffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(analogVideoOnOffLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analogVideoOnRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analogVideoOffRadioButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        askForCurrentSetting();
    }

    private void askForCurrentSetting(){
        // send message to find out current setting
        analogVideoOnRadioButton.setSelected(true);
    }
    
}
