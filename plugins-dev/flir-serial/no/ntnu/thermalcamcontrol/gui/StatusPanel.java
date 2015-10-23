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
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

/**
 * @author liz
 *
 */
class StatusPanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JLabel StatusLabel = null;
    private JLabel fpaTempLabel = null;
    private JLabel line10Label = null;
    private JLabel line11Label = null;
    private JLabel line12Label = null;
    private JLabel line13Label = null;
    private JLabel line1Label = null;
    private JLabel line2Label = null;
    private JLabel line3Label = null;
    private JLabel line4Label = null;
    private JLabel line5Label = null;
    private JLabel line6Label = null;
    private JLabel line7Label = null;
    private JLabel line8Label = null;
    private JLabel line9Label = null;
    private JLabel partNumberLabel = null;
    private JLabel serialNumberLabel = null;
    private JLabel systemStatusLabel = null;
    private JPanel systemStatusPanel = null;
    
    protected StatusPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        systemStatusPanel = new JPanel();
        systemStatusLabel = new JLabel();
        StatusLabel = new JLabel();
        line1Label = new JLabel();
        line2Label = new JLabel();
        line3Label = new JLabel();
        line4Label = new JLabel();
        line5Label = new JLabel();
        line6Label = new JLabel();
        line7Label = new JLabel();
        line8Label = new JLabel();
        line9Label = new JLabel();
        line10Label = new JLabel();
        line11Label = new JLabel();
        line12Label = new JLabel();
        line13Label = new JLabel();
        partNumberLabel = new JLabel();
        serialNumberLabel = new JLabel();
        fpaTempLabel = new JLabel();

        systemStatusPanel.setBorder(BorderFactory.createEtchedBorder());

        systemStatusLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        systemStatusLabel.setText("System Status");

        StatusLabel.setText("Ready.");

        GroupLayout systemStatusPanelLayout = new GroupLayout(systemStatusPanel);
        systemStatusPanel.setLayout(systemStatusPanelLayout);
        systemStatusPanelLayout.setHorizontalGroup(
            systemStatusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(systemStatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(systemStatusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(systemStatusLabel)
                    .addComponent(StatusLabel)
                    .addComponent(line1Label)
                    .addComponent(line2Label)
                    .addComponent(line3Label)
                    .addComponent(line4Label)
                    .addComponent(line5Label)
                    .addComponent(line6Label)
                    .addComponent(line7Label)
                    .addComponent(line8Label)
                    .addComponent(line9Label)
                    .addComponent(line10Label)
                    .addComponent(line11Label)
                    .addComponent(line12Label)
                    .addComponent(line13Label))
                .addContainerGap(669, Short.MAX_VALUE))
        );
        systemStatusPanelLayout.setVerticalGroup(
            systemStatusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(systemStatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(systemStatusLabel)
                .addGap(18, 18, 18)
                .addComponent(StatusLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line1Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line2Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line3Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line4Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line5Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line6Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line7Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line8Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line9Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line10Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line11Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line12Label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line13Label)
                .addContainerGap(281, Short.MAX_VALUE))
        );

        partNumberLabel.setText("Part Number:");

        serialNumberLabel.setText("Serial Number:");

        fpaTempLabel.setText("FPA Temp: °C  ");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(partNumberLabel)
                .addGap(192, 192, 192)
                .addComponent(serialNumberLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fpaTempLabel)
                .addGap(158, 158, 158))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(systemStatusPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(systemStatusPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(partNumberLabel)
                    .addComponent(serialNumberLabel)
                    .addComponent(fpaTempLabel))
                .addContainerGap(102, Short.MAX_VALUE))
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
