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
 * Oct 16, 2015
 */
package no.ntnu.thermalcamcontrol.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;

/**
 * @author liz
 *
 */
class DigitalPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private JPanel xpBusOutputPanel = null;
    private JPanel xpBusControlPanel = null;
    private JPanel eightBitDigitalChannelOptionsPanel = null;
    private JPanel lvdsControlPanel = null;
    private JPanel eightBitDigitalChannelColorControlPanel = null;


    public DigitalPanel() {
        super();
        initialize();
    }
    
    private void initialize() {

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(getXpBusOutputPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getEightBitDigitalChannelOptionsPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(getXpBusControlPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getLVDSControlPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(getEightBitDigitalChannelColorControlPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(getXpBusOutputPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(getEightBitDigitalChannelOptionsPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(getEightBitDigitalChannelColorControlPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(getXpBusControlPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(getLVDSControlPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private JPanel getXpBusOutputPanel(){   
        
        if(xpBusOutputPanel == null)    
            xpBusOutputPanel = new XpBusOutputPanel();
        return xpBusOutputPanel;
    }
    
    private JPanel getXpBusControlPanel(){
        
        if(xpBusControlPanel == null)
            xpBusControlPanel = new JPanel();
        return xpBusControlPanel;
        
    }
    
    private JPanel getEightBitDigitalChannelColorControlPanel(){

        if(eightBitDigitalChannelColorControlPanel == null)
            eightBitDigitalChannelColorControlPanel = new EightBitDigitalChannelColorControlPanel();
        return eightBitDigitalChannelColorControlPanel;
    }

    private JPanel getLVDSControlPanel(){
            
        if(lvdsControlPanel == null)
            lvdsControlPanel = new LvdsControlPanel();
        return lvdsControlPanel;
    }
    
    private JPanel getEightBitDigitalChannelOptionsPanel(){
    
        if(eightBitDigitalChannelOptionsPanel == null)
            eightBitDigitalChannelOptionsPanel = new EightBitDigitalChannelOptionsPanel();
        return eightBitDigitalChannelOptionsPanel;
    }                                                            
                                                      
                
}
