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
import javax.swing.JRadioButton;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 * @author liz
 *
 */
class DigitalPanel extends JPanel implements ReplyAction{

    private static final long serialVersionUID = 1L;

    private ThermalCamControlGui gui;
    
    private boolean digitalOutputEnabled;
    
    private XpBusOutputPanel xpBusOutputPanel = null;
    private XpBusControlPanel xpBusControlPanel = null;
    private EightBitOptionsPanel eightBitOptionsPanel = null;
    private LvdsControlPanel lvdsControlPanel = null;
    private EightBitColorControlPanel eightBitColorControlPanel = null;

    private JPanel digitalOutputPanel = null;
    private JLabel digitalOutputLabel = null;
    private JCheckBox digitalOutputEnableCheckBox = null;

    public DigitalPanel(ThermalCamControlGui gui) {
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize() {

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(getXpBusOutputPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getDigitalOutputPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(getLVDSControlPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getXpBusControlPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(getEightBitOptionsPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(getEightBitColorControlPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(getEightBitColorControlPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(getDigitalOutputPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getLVDSControlPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(getXpBusControlPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getXpBusOutputPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(getEightBitOptionsPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }

    protected XpBusOutputPanel getXpBusOutputPanel(){   
        
        if(xpBusOutputPanel == null)    
            xpBusOutputPanel = new XpBusOutputPanel(this.gui);
        return xpBusOutputPanel;
    }
    
    protected XpBusControlPanel getXpBusControlPanel(){
        
        if(xpBusControlPanel == null)
            xpBusControlPanel = new XpBusControlPanel(this.gui);
        return xpBusControlPanel;
        
    }
    
    protected EightBitColorControlPanel getEightBitColorControlPanel(){

        if(eightBitColorControlPanel == null)
            eightBitColorControlPanel = new EightBitColorControlPanel(this.gui);
        return eightBitColorControlPanel;
    }

    protected LvdsControlPanel getLVDSControlPanel(){
            
        if(lvdsControlPanel == null)
            lvdsControlPanel = new LvdsControlPanel(this.gui);
        return lvdsControlPanel;
    }
    
    protected EightBitOptionsPanel getEightBitOptionsPanel(){
    
        if(eightBitOptionsPanel == null)
            eightBitOptionsPanel = new EightBitOptionsPanel(this.gui);
        return eightBitOptionsPanel;
    }                                                            

    
    protected JPanel getDigitalOutputPanel(){
        if(digitalOutputPanel == null){
            
            digitalOutputPanel = new JPanel();
            digitalOutputLabel = new JLabel();
            digitalOutputEnableCheckBox = new JCheckBox();
            
            digitalOutputPanel.setBorder(BorderFactory.createEtchedBorder());

            digitalOutputLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
            digitalOutputLabel.setText("Digital Output");

            digitalOutputEnableCheckBox.setText("Digital Output Enabled");
            digitalOutputEnableCheckBox.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    boolean enable = digitalOutputEnableCheckBox.isSelected();
                    setDigitalOutputEnableMessage(enable);
                    greyOut(!enable);                    
                }
            });
            digitalOutputEnableCheckBox.setSelected(false);
            
            GroupLayout digitalOutputPanelLayout = new GroupLayout(digitalOutputPanel);
            digitalOutputPanel.setLayout(digitalOutputPanelLayout);
            digitalOutputPanelLayout.setHorizontalGroup(
                digitalOutputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(digitalOutputPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(digitalOutputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(digitalOutputLabel)
                        .addComponent(digitalOutputEnableCheckBox))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            digitalOutputPanelLayout.setVerticalGroup(
                digitalOutputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(digitalOutputPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(digitalOutputLabel)
                    .addGap(18, 18, 18)
                    .addComponent(digitalOutputEnableCheckBox)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }
        return digitalOutputPanel;
    }
    
    protected void setDigitalOutputEnableMessage(boolean enable){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_SET);
        long arg = ThermalCamArguments.DIGITAL_OUTPUT_DISABLED.getArg();
        if(enable)
            arg = ThermalCamArguments.DIGITAL_OUTPUT_ENABLED.getArg();
        msg.setArgs(gui.longtoTwoBytes(arg));
        gui.sendCommand(msg);
    }
    
    protected void getDigitalOutputEnableMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET);
        gui.sendCommand(msg);
    }
    
    protected void enableDigitalOutput(boolean enable){
        this.digitalOutputEnabled = enable;
        greyOut(!enable);
    }
    
    protected boolean isDigitalOutputEnabled(){
        return this.digitalOutputEnabled;
    }
    
    protected void greyOut(boolean greyOut){
        this.getXpBusOutputPanel().greyOut(greyOut);
        this.getXpBusControlPanel().greyOut(greyOut);
        this.getLVDSControlPanel().greyOut(greyOut);
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET.getFunctionCode()){
            if(sent.getByteCount() == ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET.getCmdByteCount()){
                if((int)rec.getArgs()[1] == (int)ThermalCamArguments.DIGITAL_OUTPUT_ENABLED.getArg()){
                    enableDigitalOutput(true);
                } else if ((int)rec.getArgs()[1] == (int)ThermalCamArguments.DIGITAL_OUTPUT_DISABLED.getArg()){
                    enableDigitalOutput(false);
                }             
            } else {
                long subFunc = sent.getArgs()[0];
                if (subFunc == 0x00){
                    if((int)sent.getArgs()[1] == (int)ThermalCamArguments.DIGITAL_OUTPUT_ENABLED.getArg()){
                        enableDigitalOutput(true);
                    } else if ((int)sent.getArgs()[1] == (int)ThermalCamArguments.DIGITAL_OUTPUT_DISABLED.getArg()){
                        enableDigitalOutput(false);
                    }
                    
                } else if((subFunc == ThermalCamArguments.XP_MODE_GET.getArg()) 
                        || (subFunc == ThermalCamArguments.XP_MODE_SET.getArg())){
                    this.getXpBusOutputPanel().executeOnReply(sent, rec);
                    
                } else if ((subFunc == ThermalCamArguments.CMOS_BIT_DEPTH_GET.getArg())
                        || (subFunc == ThermalCamArguments.CMOS_BIT_DEPTH_SET.getArg())){
                    this.getXpBusControlPanel().executeOnReply(sent, rec);
                    
                } else if ((subFunc == ThermalCamArguments.DIGITAL_EZOOM_GET.getArg()) 
                        || (subFunc == ThermalCamArguments.DIGITAL_EZOOM_SET.getArg())){
                    this.getEightBitOptionsPanel().executeOnReply(sent, rec);
                    
                }  else if ((subFunc == ThermalCamArguments.DIGITAL_BAYER_ENCODE_GET.getArg()) 
                        || (subFunc == ThermalCamArguments.DIGITAL_BAYER_ENCODE_SET.getArg())){
                    this.getEightBitColorControlPanel().executeOnReply(sent, rec);
                    
                }  else if ((subFunc == ThermalCamArguments.LVDS_BIT_DEPTH_GET.getArg()) 
                        || (subFunc == ThermalCamArguments.LVDS_BIT_DEPTH_SET.getArg())
                        || (subFunc == ThermalCamArguments.LVDS_OUTPUT_ENABLE_GET.getArg())
                        || (subFunc == ThermalCamArguments.LVDS_OUTPUT_ENABLE_SET.getArg())){
                    this.getLVDSControlPanel().executeOnReply(sent, rec);
                    
                }
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


