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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

import javax.swing.JPanel;

/**
 * @author liz
 *
 */
public class AgcPanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static final long[] DEFAULT = {0, 0};
    private static final long[] SKY_SEA = {0, 0};
    private static final long[] INDOORS = {0, 0};
    private static final long[] OUTDOORS = {0, 0};
    private static final long[] FACE_DEF = {0, 0};
    private static final String[] NOT_ON_AUTO = {""};
    private static final String[] AGC_AUTO_PRESETS = {"Default", "Sky/Sea", "Indoors", "Outdoors", "Face Definition"};
    private static final long[] AGC_AUTO_CONTRAST = {DEFAULT[0], SKY_SEA[0], INDOORS[0], OUTDOORS[0], FACE_DEF[0]};
    private static final long[] AGC_AUTO_BRIGHTNESS = {DEFAULT[1], SKY_SEA[1], INDOORS[1], OUTDOORS[1], FACE_DEF[1]};
    
    private ThermalCamControlGui gui;
    
    private long agcMode;
    
    // Variables declaration - do not modify                     
    private JComboBox<String> agcAutoPresetsComboBox;
    private JLabel agcAutoPresetsLabel;
    private JRadioButton agcModeAutoRadioButton;
    private JRadioButton agcModeLinearRadioButton;
    private JRadioButton agcModeManualRadioButton;
    private ButtonGroup agcModesButtonGroup;
    private JLabel agcModesLabel;

    protected AgcPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){

        agcModesButtonGroup = new ButtonGroup();
        agcModesLabel = new JLabel();
        agcModeManualRadioButton = new JRadioButton();
        agcModeLinearRadioButton = new JRadioButton();
        agcModeAutoRadioButton = new JRadioButton();
        agcAutoPresetsComboBox = new JComboBox<String>();
        agcAutoPresetsLabel = new JLabel();

        agcModesButtonGroup.add(agcModeManualRadioButton);
        agcModesButtonGroup.add(agcModeLinearRadioButton);
        agcModesButtonGroup.add(agcModeAutoRadioButton);

        this.setBorder(BorderFactory.createEtchedBorder());

        agcModesLabel.setFont(new java.awt.Font(null, 1, 15)); // NOI18N
        agcModesLabel.setText("AGC Modes");

        agcModeManualRadioButton.setText("Manual");
        agcModeManualRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAgcModeMessage(ThermalCamArguments.AGC_MODE_MANUAL.getArg());
                agcAutoPresetsComboBox.setModel(new DefaultComboBoxModel<String>(NOT_ON_AUTO));
            }
        });
        agcModeLinearRadioButton.setText("Linear");
        agcModeLinearRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAgcModeMessage(ThermalCamArguments.AGC_MODE_LINEAR.getArg());
                agcAutoPresetsComboBox.setModel(new DefaultComboBoxModel<String>(NOT_ON_AUTO));
            }
        });
        agcModeAutoRadioButton.setText("Auto");
        agcModeAutoRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAgcModeMessage(ThermalCamArguments.AGC_MODE_AUTO_BRIGHT.getArg());
                agcAutoPresetsComboBox.setModel(new DefaultComboBoxModel<String>(AGC_AUTO_PRESETS));
            }
        });       

        agcAutoPresetsLabel.setText("Auto presets");
        agcAutoPresetsComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(getAgcMode() == ThermalCamArguments.AGC_MODE_AUTO_BRIGHT.getArg()){
                    invokeAgcAutoPresets(agcAutoPresetsComboBox.getSelectedIndex());
                }
            }
        });
        
        
        GroupLayout agcModesPanelLayout = new GroupLayout(this);
        this.setLayout(agcModesPanelLayout);
        agcModesPanelLayout.setHorizontalGroup(
            agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(agcModesPanelLayout.createSequentialGroup()
                .addGroup(agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(agcModesPanelLayout.createSequentialGroup()
                        .addGroup(agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(agcModesPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(agcModesLabel))
                            .addGroup(agcModesPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(agcModeAutoRadioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(agcModeLinearRadioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(agcModeManualRadioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, agcModesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(agcAutoPresetsLabel)
                            .addComponent(agcAutoPresetsComboBox, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        agcModesPanelLayout.setVerticalGroup(
            agcModesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(agcModesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agcModesLabel)
                .addGap(18, 18, 18)
                .addComponent(agcModeManualRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agcModeLinearRadioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agcModeAutoRadioButton)
                .addGap(18, 18, 18)
                .addComponent(agcAutoPresetsLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agcAutoPresetsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

    }
    
    protected long getAgcMode(){
        return this.agcMode;
    }
    
    protected void setAgcMode(long mode){
        if(mode == ThermalCamArguments.AGC_MODE_AUTO_BRIGHT.getArg()){
            this.agcMode = mode;
            agcModeAutoRadioButton.setSelected(true);
        } else if (mode == ThermalCamArguments.AGC_MODE_MANUAL.getArg()){
            this.agcMode = mode;
            agcModeManualRadioButton.setSelected(true);
        } else if (mode == ThermalCamArguments.AGC_MODE_LINEAR.getArg()){
            this.agcMode = mode;
            agcModeLinearRadioButton.setSelected(true);
        } else {
            agcModeLinearRadioButton.setSelected(false);
            agcModeAutoRadioButton.setSelected(false);
            agcModeManualRadioButton.setSelected(false);
        }
    }
    
    private void setAgcModeMessage(long mode){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.AGC_TYPE_SET);
        msg.setArgs(gui.longtoTwoBytes(mode));
        gui.sendCommand(msg);
    }
    
    protected void getAgcModeMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.AGC_TYPE_GET);
        gui.sendCommand(msg);
    }
    
    private void invokeAgcAutoPresets(int index){
        gui.getAgcDdePanel().getManualParamPanel().setContrastMessage(AGC_AUTO_CONTRAST[index]);
        gui.getAgcDdePanel().getManualParamPanel().setBrightnessMessage(AGC_AUTO_BRIGHTNESS[index]);
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.AGC_TYPE_GET.getFunctionCode()){
            if((sent.getByteCount() == 0) || (sent.getArgs()[0] == 0x00)){
                // agc mode set or get
                setAgcMode(gui.twoBytesToLong(rec.getArgs()));
            } else if (gui.twoBytesToLong(sent.getArgs()) == ThermalCamArguments.AGC_SSO_PERCENT.getArg()){
                if(rec.getByteCount() > 0){
                    gui.getAgcDdePanel().getEnhancePanel().setSso(gui.twoBytesToLong(rec.getArgs()));
                } else {
                    gui.getAgcDdePanel().getEnhancePanel().setSso(gui.twoBytesToLong(sent.getArgs()[2], sent.getArgs()[3]));
                }
            } else if ((gui.twoBytesToLong(sent.getArgs()) == ThermalCamArguments.AGC_INFO_THRESHOLD.getArg())
                    && (rec.getByteCount() > 0)){
                if(rec.getByteCount() > 0){
                    //setAgcInfoThreshold(gui.twoBytesToLong(rec.getArgs()));
                } else {
                    //setAgcInfoThreshold(gui.twoBytesToLong(sent.getArgs()[2], sent.getArgs()[3]));
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
