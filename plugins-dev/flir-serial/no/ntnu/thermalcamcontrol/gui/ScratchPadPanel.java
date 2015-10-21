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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

/**
 * @author liz
 *
 */
class ScratchPadPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private JLabel scratchPadLabel = null;
    private JButton scratchPadWriteButton = null;
    private JButton scratchPadReadButton = null;
    private JScrollPane scratchPadScrollPane = null;
    private JTextArea scratchPadText = null;
    
    protected ScratchPadPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        scratchPadLabel = new JLabel();
        scratchPadWriteButton = new JButton();
        scratchPadReadButton = new JButton();
        scratchPadScrollPane = new JScrollPane();
        scratchPadText = new JTextArea();

        this.setBorder(BorderFactory.createEtchedBorder());

        scratchPadLabel.setFont(new java.awt.Font(null, 1, 15)); // NOI18N
        scratchPadLabel.setText("Scratch Pad");

        scratchPadWriteButton.setText("Write");

        scratchPadReadButton.setText("Read");

        scratchPadText.setColumns(20);
        scratchPadText.setRows(5);
        scratchPadScrollPane.setViewportView(scratchPadText);

        GroupLayout scratchPadPanelLayout = new GroupLayout(this);
        this.setLayout(scratchPadPanelLayout);
        scratchPadPanelLayout.setHorizontalGroup(
            scratchPadPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(scratchPadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scratchPadPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scratchPadLabel)
                    .addGroup(scratchPadPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(scratchPadPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(scratchPadPanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(scratchPadReadButton)
                                .addGap(42, 42, 42)
                                .addComponent(scratchPadWriteButton))
                            .addComponent(scratchPadScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        scratchPadPanelLayout.setVerticalGroup(
            scratchPadPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(scratchPadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scratchPadLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scratchPadScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scratchPadPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(scratchPadWriteButton)
                    .addComponent(scratchPadReadButton))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }

}
