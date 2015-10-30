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

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

/**
 * @author liz
 *
 */
class XpBusControlPanel extends JPanel implements ReplyAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ThermalCamControlGui gui;
    
    private int xpBusControl;
    
    private JRadioButton xpBusControl14bitRadioButton = null;
    private JLabel xpBusControlLabel = null;
    private JRadioButton xpBusControlOffRadioButton = null;
    private JRadioButton xpBusControl8bitRadioButton = null;
    private ButtonGroup xpBusControlButtonGroup = null;
    
    protected XpBusControlPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        
        xpBusControl14bitRadioButton = new JRadioButton();
        xpBusControlLabel = new JLabel();
        xpBusControlOffRadioButton = new JRadioButton();
        xpBusControl8bitRadioButton = new JRadioButton();
        xpBusControlButtonGroup = new ButtonGroup();
        
        xpBusControlButtonGroup.add(xpBusControlOffRadioButton);
        xpBusControlButtonGroup.add(xpBusControl8bitRadioButton);
        xpBusControlButtonGroup.add(xpBusControl14bitRadioButton);
        
        this.setBorder(BorderFactory.createEtchedBorder());

        xpBusControlLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        xpBusControlLabel.setText("XP Bus Control");
        
        xpBusControlOffRadioButton.setText("Off");
        
        xpBusControl14bitRadioButton.setText("14-bit Filtered");
        xpBusControl14bitRadioButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setXpBusControlMessage(ThermalCamArguments.CMOS_BIT_DEPTH_14.getArg());
            }
        });

        xpBusControl8bitRadioButton.setText("8-bit");
        xpBusControl8bitRadioButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setXpBusControlMessage(ThermalCamArguments.CMOS_BIT_DEPTH_8.getArg());
            }
        });
        
        GroupLayout xpBusControlPanelLayout = new GroupLayout(this);
        this.setLayout(xpBusControlPanelLayout);
        xpBusControlPanelLayout.setHorizontalGroup(
            xpBusControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(xpBusControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(xpBusControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(xpBusControlLabel)
                    .addComponent(xpBusControl14bitRadioButton)
                    .addComponent(xpBusControlOffRadioButton)
                    .addComponent(xpBusControl8bitRadioButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        xpBusControlPanelLayout.setVerticalGroup(
            xpBusControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(xpBusControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xpBusControlLabel)
                .addGap(18, 18, 18)
                .addComponent(xpBusControlOffRadioButton)
                .addGap(18, 18, 18)
                .addComponent(xpBusControl8bitRadioButton)
                .addGap(18, 18, 18)
                .addComponent(xpBusControl14bitRadioButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }
    
    protected void getXpBusControlMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET_SUB);
        msg.setArgs(gui.longtoTwoBytes(ThermalCamArguments.CMOS_BIT_DEPTH_GET.getArg()));
        gui.sendCommand(msg);
    }
    
    protected void setXpBusControlMessage(long setting){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_SET_SUB);
        byte[] args = {(byte)ThermalCamArguments.CMOS_BIT_DEPTH_SET.getArg(), (byte)setting};
        msg.setArgs(args);
        gui.sendCommand(msg);
    }
    
    protected int getXpBusControl(){
        return this.xpBusControl;
    }
    
    protected void setXpBusControl(int setting){
        if(setting == (int) ThermalCamArguments.CMOS_BIT_DEPTH_8.getArg()){
            this.xpBusControl = setting;
            greyOut(false);
            xpBusControl8bitRadioButton.setSelected(true);
        } else if(setting == (int) ThermalCamArguments.CMOS_BIT_DEPTH_14.getArg()){
            this.xpBusControl = setting;
            greyOut(false);
            xpBusControl14bitRadioButton.setSelected(true);    
        } else {
            xpBusControlOffRadioButton.setSelected(true);
        }
    }
    
    protected void greyOut(boolean greyOut){
        if(greyOut)
            xpBusControlOffRadioButton.setSelected(true);
        xpBusControl8bitRadioButton.setEnabled(!greyOut);
        xpBusControl14bitRadioButton.setEnabled(!greyOut);
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if((rec.getFunction() == ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET_SUB.getFunctionCode()) 
                &&(((int)sent.getArgs()[0] == (int)ThermalCamArguments.CMOS_BIT_DEPTH_GET.getArg()))
                || ((int)sent.getArgs()[0] == (int)ThermalCamArguments.CMOS_BIT_DEPTH_SET.getArg())){
                   setXpBusControl((int)gui.twoBytesToLong(rec.getArgs()));
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
