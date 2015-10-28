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

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

/**
 * @author liz
 *
 */
class TestPatternPanel extends JPanel implements ReplyAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ThermalCamControlGui gui;
    
    private long testPattern;
    
    private JLabel testPatternLabel = null;
    private JRadioButton testPatternRampRadioButton = null;
    private JRadioButton testPatternOffRadioButton = null;
    private ButtonGroup testPatternButtonGroup = null;
    
    protected TestPatternPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        testPatternLabel = new JLabel();
        testPatternRampRadioButton = new JRadioButton();
        testPatternOffRadioButton = new JRadioButton();
        testPatternButtonGroup = new ButtonGroup();
        
        testPatternButtonGroup.add(testPatternOffRadioButton);
        testPatternButtonGroup.add(testPatternRampRadioButton);

        this.setBorder(BorderFactory.createEtchedBorder());

        testPatternLabel.setFont(new java.awt.Font(null, 1, 15)); // NOI18N
        testPatternLabel.setText("Test Pattern");

        testPatternRampRadioButton.setText("Ramp");
        testPatternRampRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                setTestPatternMessage(ThermalCamArguments.TEST_PATTERN_14BIT_ASCENDING_RAMP.getArg());
            }
        });

        testPatternOffRadioButton.setText("Off");
        testPatternRampRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                setTestPatternMessage(ThermalCamArguments.TEST_PATTERN_OFF.getArg());
            }
        });

        GroupLayout testPatternPanelLayout = new GroupLayout(this);
        this.setLayout(testPatternPanelLayout);
        testPatternPanelLayout.setHorizontalGroup(
            testPatternPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(testPatternPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(testPatternPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(testPatternLabel)
                    .addComponent(testPatternOffRadioButton)
                    .addComponent(testPatternRampRadioButton))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        testPatternPanelLayout.setVerticalGroup(
            testPatternPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(testPatternPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testPatternLabel)
                .addGap(18, 18, 18)
                .addComponent(testPatternOffRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(testPatternRampRadioButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }
    
    protected void getTestPatternMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.TEST_PATTERN_GET);
        gui.sendCommand(msg);
    }
    
    private void setTestPatternMessage(long pattern){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.TEST_PATTERN_SET);
        msg.setArgs(gui.longtoTwoBytes(pattern));
        gui.sendCommand(msg);
    }
    
    protected long getTestPattern(){
        return this.testPattern;
    }
    
    protected void setTestPattern(long pattern){
        if(pattern == ThermalCamArguments.TEST_PATTERN_OFF.getArg()){
            this.testPattern = pattern;
            testPatternOffRadioButton.setSelected(true);
        } else if (pattern == ThermalCamArguments.TEST_PATTERN_14BIT_ASCENDING_RAMP.getArg()){
            this.testPattern = pattern;
            testPatternRampRadioButton.setSelected(true);
        } 
    }
    


    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.TEST_PATTERN_GET.getFunctionCode()){
            setTestPattern(gui.twoBytesToLong(rec.getArgs()));
        }
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeIfNoReply(pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeIfNoReply(ThermalCamControl sent) {
        gui.sendCommand(sent);        
    }

}
