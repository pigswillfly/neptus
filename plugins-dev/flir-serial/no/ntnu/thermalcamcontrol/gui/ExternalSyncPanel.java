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
class ExternalSyncPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private JLabel externalSyncLabel = null;
    private JRadioButton externalSyncSlaveRadioButton = null;
    private JRadioButton externalSyncMasterRadioButton = null;
    private JRadioButton externalSyncDisableRadioButton = null;
    private ButtonGroup externalSyncButtonGroup = null;

    protected ExternalSyncPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        externalSyncLabel = new JLabel();
        externalSyncSlaveRadioButton = new JRadioButton();
        externalSyncMasterRadioButton = new JRadioButton();
        externalSyncDisableRadioButton = new JRadioButton();
        externalSyncButtonGroup = new ButtonGroup();
        
        externalSyncButtonGroup.add(externalSyncDisableRadioButton);
        externalSyncButtonGroup.add(externalSyncSlaveRadioButton);
        externalSyncButtonGroup.add(externalSyncMasterRadioButton);

        this.setBorder(BorderFactory.createEtchedBorder());

        externalSyncSlaveRadioButton.setText("Slave");
        externalSyncMasterRadioButton.setText("Master");
        externalSyncDisableRadioButton.setText("Disable");

        externalSyncLabel.setFont(new java.awt.Font(null, 1, 15)); // NOI18N
        externalSyncLabel.setText("External Sync");

        GroupLayout externalSyncPanelLayout = new GroupLayout(this);
        this.setLayout(externalSyncPanelLayout);
        externalSyncPanelLayout.setHorizontalGroup(
            externalSyncPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(externalSyncPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(externalSyncPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(externalSyncDisableRadioButton)
                    .addComponent(externalSyncLabel)
                    .addComponent(externalSyncSlaveRadioButton)
                    .addComponent(externalSyncMasterRadioButton))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        externalSyncPanelLayout.setVerticalGroup(
            externalSyncPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(externalSyncPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(externalSyncLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(externalSyncDisableRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(externalSyncSlaveRadioButton)
                .addGap(12, 12, 12)
                .addComponent(externalSyncMasterRadioButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        externalSyncDisableRadioButton.setSelected(true);
    }
}
