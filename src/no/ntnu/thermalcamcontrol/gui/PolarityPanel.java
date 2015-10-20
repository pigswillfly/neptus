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

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author liz
 *
 */
class PolarityPanel extends JPanel {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected PolarityPanel(){
        super();
        initialize();
    }

    private void initialize(){
        JLabel polarityLabel = new JLabel();

        this.setBorder(BorderFactory.createEtchedBorder());

        ArrayList<String> mList = new ArrayList<String>(2);
        mList.add("WhiteHot");
        mList.add("BlackHot");
        JComboBox<?> polarityComboBox = new JComboBox<Object>(mList.toArray(new String[mList.size()]));

        polarityLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        polarityLabel.setText("Polarity / Palette");

        GroupLayout polarityPanelLayout = new GroupLayout(this);
        this.setLayout(polarityPanelLayout);
        polarityPanelLayout.setHorizontalGroup(
            polarityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(polarityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(polarityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(polarityLabel)
                    .addComponent(polarityComboBox, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        polarityPanelLayout.setVerticalGroup(
            polarityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(polarityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(polarityLabel)
                .addGap(26, 26, 26)
                .addComponent(polarityComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }
}
