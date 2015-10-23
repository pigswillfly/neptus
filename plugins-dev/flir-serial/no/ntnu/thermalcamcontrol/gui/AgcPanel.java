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
 * Oct 23, 2015
 */
package no.ntnu.thermalcamcontrol.gui;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

import javax.swing.JPanel;

/**
 * @author liz
 *
 */
public class AgcPanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify                     
    private JComboBox<String> agcAutoPresetsComboBox;
    private JLabel agcAutoPresetsLabel;
    private JRadioButton agcModeAutoRadioButton;
    private JRadioButton agcModeLinearRadioButton;
    private JRadioButton agcModeManualRadioButton;
    private ButtonGroup agcModesButtonGroup;
    private JLabel agcModesLabel;

    protected AgcPanel(){
        super();
        initialize();
    }
    
    private void initialize(){

        agcModesButtonGroup = new ButtonGroup();
        agcModesLabel = new JLabel();
        agcModeManualRadioButton = new JRadioButton();
        agcModeLinearRadioButton = new JRadioButton();
        agcModeAutoRadioButton = new JRadioButton();
        agcAutoPresetsComboBox = new JComboBox<String>();
        agcAutoPresetsLabel = new JLabel();

        agcModesButtonGroup.add(agcModeManualRadioButton);
        agcModesButtonGroup.add(agcModeLinearRadioButton);
        agcModesButtonGroup.add(agcModeAutoRadioButton);

        this.setBorder(BorderFactory.createEtchedBorder());

        agcModesLabel.setFont(new java.awt.Font(null, 1, 15)); // NOI18N
        agcModesLabel.setText("AGC Modes");

        agcModeManualRadioButton.setText("Manual");
        agcModeLinearRadioButton.setText("Linear");
        agcModeAutoRadioButton.setText("Auto");

        agcAutoPresetsLabel.setText("Auto presets");

        GroupLayout agcModesPanelLayout = new GroupLayout(this);
        this.setLayout(agcModesPanelLayout);
        agcModesPanelLayout.setHorizontalGroup(
            agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(agcModesPanelLayout.createSequentialGroup()
                .addGroup(agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(agcModesPanelLayout.createSequentialGroup()
                        .addGroup(agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(agcModesPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(agcModesLabel))
                            .addGroup(agcModesPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(agcModeAutoRadioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(agcModeLinearRadioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(agcModeManualRadioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, agcModesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(agcAutoPresetsLabel)
                            .addComponent(agcAutoPresetsComboBox, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        agcModesPanelLayout.setVerticalGroup(
            agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(agcModesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agcModesLabel)
                .addGap(18, 18, 18)
                .addComponent(agcModeManualRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agcModeLinearRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agcModeAutoRadioButton)
                .addGap(18, 18, 18)
                .addComponent(agcAutoPresetsLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agcAutoPresetsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeIfNoReply(pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeIfNoReply(ThermalCamControl sent) {
        // TODO Auto-generated method stub
        
    }

}
