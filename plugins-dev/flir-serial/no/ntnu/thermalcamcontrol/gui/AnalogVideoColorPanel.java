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
class AnalogVideoColorPanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ThermalCamControlGui gui;
    
    private boolean colorEnabled;
    
    private JRadioButton analogVideoColorRadioButton = null;
    private JRadioButton analogVideoMonochromeRadioButton = null;
    private JLabel analogVideoColorLabel = null;
    
    protected AnalogVideoColorPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){

        analogVideoColorRadioButton = new JRadioButton();
        analogVideoMonochromeRadioButton = new JRadioButton();
        analogVideoColorLabel = new JLabel();
        
        ButtonGroup analogVideoColorButtonGroup = new ButtonGroup();
        analogVideoColorButtonGroup.add(analogVideoColorRadioButton);
        analogVideoColorButtonGroup.add(analogVideoMonochromeRadioButton);
        
        this.setBorder(BorderFactory.createEtchedBorder());

        analogVideoColorRadioButton.setText("Color");        
        analogVideoColorRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setColorEnabledMessage(true);
            }
        });

        analogVideoMonochromeRadioButton.setText("Monochrome");
        analogVideoColorRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setColorEnabledMessage(false);
            }
        });

        analogVideoColorLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        analogVideoColorLabel.setText("Video Color");

        GroupLayout analogVideoColorPanelLayout = new GroupLayout(this);
        this.setLayout(analogVideoColorPanelLayout);
        analogVideoColorPanelLayout.setHorizontalGroup(
            analogVideoColorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(analogVideoColorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(analogVideoColorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(analogVideoColorLabel)
                    .addGroup(analogVideoColorPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(analogVideoColorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(analogVideoMonochromeRadioButton)
                            .addComponent(analogVideoColorRadioButton))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        analogVideoColorPanelLayout.setVerticalGroup(
            analogVideoColorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(analogVideoColorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(analogVideoColorLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analogVideoColorRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(analogVideoMonochromeRadioButton)
                .addContainerGap())
        );       
    }
    
    protected void setColorEnabledMessage(boolean enable){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.VIDEO_COLOR_MODE_SET);
        long arg = 0;
        if(enable)
            arg = ThermalCamArguments.COLOR_MODE_COLOR_ENABLED.getArg();
        msg.setArgs(gui.longtoTwoBytes(arg));
        gui.sendCommand(msg);
    }
    
    protected void getColorEnabledMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.VIDEO_COLOR_MODE_GET);
        gui.sendCommand(msg);
    }
    
    protected void enableColor(boolean enable){
        this.colorEnabled = enable;
        if(enable)
            analogVideoColorRadioButton.setSelected(true);
        else
            analogVideoMonochromeRadioButton.setSelected(true);
    }

    protected boolean isColorEnabled(){
        return this.colorEnabled;
    }
    
    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.VIDEO_COLOR_MODE_GET.getFunctionCode()){
            enableColor((gui.twoBytesToLong(rec.getArgs()) == ThermalCamArguments.COLOR_MODE_COLOR_ENABLED.getArg()));
        }
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeIfNoReply(pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeIfNoReply(ThermalCamControl sent) {
        // TODO Auto-generated method stub
        
    }

}
