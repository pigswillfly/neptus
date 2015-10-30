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
class LvdsControlPanel extends JPanel implements ReplyAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ThermalCamControlGui gui;
    
    private int lvdsControl;
    private boolean lvdsEnabled;
    
    private JRadioButton lvdsControl8bitRadioButton = null;
    private JRadioButton lvdsControlOffRadioButton = null;
    private JRadioButton lvdsControl14bitRadioButton = null;
    private JLabel lvdsControlLabel = null;
    private ButtonGroup lvdsControlButtonGroup = null;
    
    protected LvdsControlPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        lvdsControl8bitRadioButton = new JRadioButton();
        lvdsControlOffRadioButton = new JRadioButton();
        lvdsControl14bitRadioButton = new JRadioButton();
        lvdsControlLabel = new JLabel();
        lvdsControlButtonGroup = new ButtonGroup();    
        
        lvdsControlButtonGroup.add(lvdsControlOffRadioButton);
        lvdsControlButtonGroup.add(lvdsControl8bitRadioButton);
        lvdsControlButtonGroup.add(lvdsControl14bitRadioButton);
        
        this.setBorder(BorderFactory.createEtchedBorder());
        
        lvdsControlOffRadioButton.setText("Off");
        lvdsControlOffRadioButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setLvdsEnableMessage(false);
            }
        });

        lvdsControl8bitRadioButton.setText("8-bit");
        lvdsControl8bitRadioButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setLvdsEnableMessage(true);
                setLvdsControlMessage(ThermalCamArguments.LVDS_BIT_DEPTH_8.getArg());
            }
        });

        lvdsControl14bitRadioButton.setText("14-bit Filtered");
        lvdsControl14bitRadioButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setLvdsEnableMessage(true);
                setLvdsControlMessage(ThermalCamArguments.LVDS_BIT_DEPTH_14.getArg());
            }
        });

        lvdsControlLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lvdsControlLabel.setText("LVDS Control");

        GroupLayout lvdsControlPanelLayout = new GroupLayout(this);
        this.setLayout(lvdsControlPanelLayout);
        lvdsControlPanelLayout.setHorizontalGroup(
            lvdsControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(lvdsControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lvdsControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lvdsControlLabel)
                    .addComponent(lvdsControlOffRadioButton)
                    .addComponent(lvdsControl8bitRadioButton)
                    .addComponent(lvdsControl14bitRadioButton))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        lvdsControlPanelLayout.setVerticalGroup(
            lvdsControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(lvdsControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lvdsControlLabel)
                .addGap(18, 18, 18)
                .addComponent(lvdsControlOffRadioButton)
                .addGap(18, 18, 18)
                .addComponent(lvdsControl8bitRadioButton)
                .addGap(18, 18, 18)
                .addComponent(lvdsControl14bitRadioButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    
    protected void getLVDSEnableMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET_SUB);
        msg.setArgs(gui.longtoTwoBytes(ThermalCamArguments.LVDS_OUTPUT_ENABLE_GET.getArg()));
        gui.sendCommand(msg);
    }
    
    protected void setLvdsEnableMessage(boolean enable){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_SET_SUB);
        long arg = ThermalCamArguments.LVDS_MODE_DISABLED.getArg();
        if(enable)
            arg = ThermalCamArguments.LVDS_MODE_ENABLED.getArg();
        byte[] args = {(byte)ThermalCamArguments.LVDS_OUTPUT_ENABLE_SET.getArg(), (byte)arg};
        msg.setArgs(args);
        gui.sendCommand(msg);
    }
    
    protected void getLvdsControlMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET_SUB);
        msg.setArgs(gui.longtoTwoBytes(ThermalCamArguments.LVDS_BIT_DEPTH_GET.getArg()));
        gui.sendCommand(msg);
    }
    
    protected void setLvdsControlMessage(long setting){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_SET_SUB);
        byte[] args = {(byte)ThermalCamArguments.LVDS_BIT_DEPTH_SET.getArg(), (byte)setting};
        msg.setArgs(args);
        gui.sendCommand(msg);
    }
    
    protected boolean isLvdsEnabled(){
        return this.lvdsEnabled;
    }
    
    protected void enableLvdsOutput(boolean enable){
        this.lvdsEnabled = enable;
    }
    
    protected int getLvdsControl(){
        return this.lvdsControl;
    }
    
    protected void setLvdsControl(int setting){
        if(setting == (int) ThermalCamArguments.LVDS_BIT_DEPTH_8.getArg()){
            this.lvdsControl = setting;
            greyOut(false);
            lvdsControl8bitRadioButton.setSelected(true);
        } else if(setting == (int) ThermalCamArguments.LVDS_BIT_DEPTH_14.getArg()){
            this.lvdsControl = setting;
            greyOut(false);
            lvdsControl14bitRadioButton.setSelected(true);    
        } else {
            lvdsControlOffRadioButton.setSelected(true);
        }
    }
    
    protected void greyOut(boolean greyOut){
        if(greyOut)
            lvdsControlOffRadioButton.setSelected(true);
        lvdsControl8bitRadioButton.setEnabled(!greyOut);
        lvdsControl14bitRadioButton.setEnabled(!greyOut);
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET_SUB.getFunctionCode()){ 
            if(((int)sent.getArgs()[0] == (int)ThermalCamArguments.LVDS_BIT_DEPTH_GET.getArg()) 
            || ((int)sent.getArgs()[0] == (int)ThermalCamArguments.LVDS_BIT_DEPTH_SET.getArg())){
                setLvdsControl((int)gui.twoBytesToLong(rec.getArgs()));
            } else if (((int)sent.getArgs()[0] == (int)ThermalCamArguments.LVDS_OUTPUT_ENABLE_GET.getArg()) 
                    || ((int)sent.getArgs()[0] == (int)ThermalCamArguments.LVDS_OUTPUT_ENABLE_SET.getArg())){
                if(rec.getArgs()[1] == ThermalCamArguments.LVDS_MODE_ENABLED.getArg())
                    enableLvdsOutput(true);
                else 
                    enableLvdsOutput(false);                   
            }
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
