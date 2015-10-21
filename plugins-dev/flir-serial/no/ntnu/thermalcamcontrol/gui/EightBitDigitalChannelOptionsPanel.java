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

/**
 * @author liz
 *
 */
class EightBitDigitalChannelOptionsPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private JLabel eightBitDigitalChannelOptionsLabel = null; 
    private JCheckBox digitalEZoomEnableCheckBox = null;
    
    protected EightBitDigitalChannelOptionsPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        eightBitDigitalChannelOptionsLabel = new JLabel(); 
        digitalEZoomEnableCheckBox = new JCheckBox();
        
        this.setBorder(BorderFactory.createEtchedBorder());

        eightBitDigitalChannelOptionsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        eightBitDigitalChannelOptionsLabel.setText("8-bit Digital Channel Options");

        digitalEZoomEnableCheckBox.setText("Digital EZoom enable");
        digitalEZoomEnableCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                digitalEZoomEnableCheckBoxActionPerformed(evt);
            }
        });

        GroupLayout eightBitDigitalChannelOptionsPanelLayout = new GroupLayout(this);
        this.setLayout(eightBitDigitalChannelOptionsPanelLayout);
        eightBitDigitalChannelOptionsPanelLayout.setHorizontalGroup(
            eightBitDigitalChannelOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitDigitalChannelOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eightBitDigitalChannelOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(eightBitDigitalChannelOptionsLabel)
                    .addGroup(eightBitDigitalChannelOptionsPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(digitalEZoomEnableCheckBox)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        eightBitDigitalChannelOptionsPanelLayout.setVerticalGroup(
            eightBitDigitalChannelOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitDigitalChannelOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eightBitDigitalChannelOptionsLabel)
                .addGap(18, 18, 18)
                .addComponent(digitalEZoomEnableCheckBox)
                .addContainerGap())
        );
    }

    private void digitalEZoomEnableCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                           
      
    }   
    
}
