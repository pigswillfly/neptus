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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
class OperatingModePanel extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @SuppressWarnings("unused")
    private ThermalCamControlGui gui;
    
    private boolean frozen;
    
    private JLabel operatingModeLabel = null;
    private JRadioButton operatingModeRealTimeRadioButton = null;
    private JRadioButton operatingModeFrozenRadioButton = null;
    private ButtonGroup operatingModeButtonGroup = null;
    
    protected OperatingModePanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        operatingModeLabel = new JLabel();
        operatingModeRealTimeRadioButton = new JRadioButton();
        operatingModeFrozenRadioButton = new JRadioButton();
        operatingModeButtonGroup = new ButtonGroup();
        
        operatingModeButtonGroup.add(operatingModeFrozenRadioButton);
        operatingModeButtonGroup.add(operatingModeRealTimeRadioButton);

        this.setBorder(BorderFactory.createEtchedBorder());

        operatingModeLabel.setFont(new java.awt.Font(null, 1, 15)); // NOI18N
        operatingModeLabel.setText("Operating Mode");

        operatingModeRealTimeRadioButton.setText("Real Time");
        operatingModeRealTimeRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                gui.getAnalogPanel().getAnalogVideoOnOffPanel().operatingModeChange(true);
            }
        });

        operatingModeFrozenRadioButton.setText("Frozen");
        operatingModeRealTimeRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                gui.getAnalogPanel().getAnalogVideoOnOffPanel().operatingModeChange(false);
            }
        });

        GroupLayout operatingModePanelLayout = new GroupLayout(this);
        this.setLayout(operatingModePanelLayout);
        operatingModePanelLayout.setHorizontalGroup(
            operatingModePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(operatingModePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(operatingModePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(operatingModeFrozenRadioButton)
                    .addComponent(operatingModeRealTimeRadioButton)
                    .addComponent(operatingModeLabel))
                .addContainerGap())
        );
        operatingModePanelLayout.setVerticalGroup(
            operatingModePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(operatingModePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(operatingModeLabel)
                .addGap(18, 18, 18)
                .addComponent(operatingModeRealTimeRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(operatingModeFrozenRadioButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }
    
    protected boolean isFrozen(){
        return this.frozen;
    }
    
    protected void freeze(boolean freeze){
        this.frozen = freeze;
    }

}
