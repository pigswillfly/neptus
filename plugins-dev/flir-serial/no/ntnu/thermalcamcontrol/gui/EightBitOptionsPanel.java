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

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

/**
 * @author liz
 *
 */
class EightBitOptionsPanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ThermalCamControlGui gui;
    
    private boolean digitalEZoomEnabled;
    
    private JLabel eightBitOptionsLabel = null; 
    private JCheckBox digitalEZoomEnableCheckBox = null;
    
    protected EightBitOptionsPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        eightBitOptionsLabel = new JLabel(); 
        digitalEZoomEnableCheckBox = new JCheckBox();
        
        this.setBorder(BorderFactory.createEtchedBorder());

        eightBitOptionsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        eightBitOptionsLabel.setText("8-bit Digital Channel Options");

        digitalEZoomEnableCheckBox.setText("Digital EZoom enable");
        digitalEZoomEnableCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setDigitalEZoomEnableMessage(digitalEZoomEnableCheckBox.isSelected());
            }
        });

        GroupLayout eightBitOptionsPanelLayout = new GroupLayout(this);
        this.setLayout(eightBitOptionsPanelLayout);
        eightBitOptionsPanelLayout.setHorizontalGroup(
            eightBitOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eightBitOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(eightBitOptionsLabel)
                    .addGroup(eightBitOptionsPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(digitalEZoomEnableCheckBox)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        eightBitOptionsPanelLayout.setVerticalGroup(
            eightBitOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eightBitOptionsLabel)
                .addGap(18, 18, 18)
                .addComponent(digitalEZoomEnableCheckBox)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void setDigitalEZoomEnableMessage(boolean enable){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_SET_SUB);
        long arg = ThermalCamArguments.DIGITAL_EZOOM_DISABLE.getArg();
        if(enable)
            arg = ThermalCamArguments.DIGITAL_EZOOM_ENABLE.getArg();
        byte[] args = {(byte)ThermalCamArguments.DIGITAL_EZOOM_SET.getArg(), (byte)arg};
        msg.setArgs(args);
        gui.sendCommand(msg);
    }   
    
    protected void getDigitalEZoomEnableMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET_SUB);
        msg.setArgs(gui.longtoTwoBytes(ThermalCamArguments.DIGITAL_EZOOM_GET.getArg()));
        gui.sendCommand(msg);
    }
    
    protected boolean isDigitalEZoomEnabled(){
        return this.digitalEZoomEnabled;
    }
    
    protected void enableDigitalEZoom(boolean enable){
        this.digitalEZoomEnabled = enable;
        digitalEZoomEnableCheckBox.setSelected(enable);
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if((rec.getFunction() == ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET_SUB.getFunctionCode()) 
                &&(((int)sent.getArgs()[0] == (int)ThermalCamArguments.DIGITAL_EZOOM_GET.getArg()))
                || ((int)sent.getArgs()[0] == (int)ThermalCamArguments.DIGITAL_EZOOM_SET.getArg())){
                   if(rec.getArgs()[1] == ThermalCamArguments.DIGITAL_EZOOM_ENABLE.getArg())
                       enableDigitalEZoom(true);
                   else 
                       enableDigitalEZoom(false);                   
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
