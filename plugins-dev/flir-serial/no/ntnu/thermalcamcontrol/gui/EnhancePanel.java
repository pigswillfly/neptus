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
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

/**
 * @author liz
 *
 */
class EnhancePanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ThermalCamControlGui gui;
    private static final int ACE_MIN = -8;
    private static final int ACE_MAX = 8;
    private static final int DDE_MIN = 0;
    private static final int DDE_MAX = 63;
    private static final int SSO_MIN = 0;
    private static final int SSO_MAX = 100;
    
    // States as known by camera
    private int ace;
    private int dde;
    private int sso;
    
    private JLabel aceLabel = null;
    private JLabel aceMaxLabel = null;
    private JLabel aceMinLabel = null;
    private JLabel aceNoteLine1 = null;
    private JLabel aceNoteLine2 = null;
    private JSlider aceSlider = null;
    private JTextField aceTextField = null;
    private JLabel ddeLabel = null;
    private JLabel ddeMaxLabel = null;
    private JLabel ddeMinLabel = null;
    private JLabel ddeNoteLine1 = null;
    private JLabel ddeNoteLine2 = null;
    private JLabel ddeNoteLine3 = null;
    private JSlider ddeSlider = null;
    private JTextField ddeTextField = null;
    private JLabel enhanceLabel = null;
    private JLabel ssoLabel = null;
    private JLabel ssoMaxLabel = null;
    private JLabel ssoMinLabel = null;
    private JLabel ssoNote = null;
    private JSlider ssoSlider = null;
    private JTextField ssoTextField = null;
    
    protected EnhancePanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
       
        enhanceLabel = new JLabel();
        ddeLabel = new JLabel();
        ddeSlider = new JSlider();
        ddeTextField = new JTextField();
        ddeMinLabel = new JLabel();
        ddeMaxLabel = new JLabel();
        ddeNoteLine1 = new JLabel();
        ddeNoteLine2 = new JLabel();
        ddeNoteLine3 = new JLabel();
        aceLabel = new JLabel();
        aceSlider = new JSlider();
        aceTextField = new JTextField();
        aceMinLabel = new JLabel();
        aceMaxLabel = new JLabel();
        aceNoteLine1 = new JLabel();
        aceNoteLine2 = new JLabel(); 
        ssoLabel = new JLabel();
        ssoSlider = new JSlider();
        ssoTextField = new JTextField();
        ssoMinLabel = new JLabel();
        ssoMaxLabel = new JLabel();
        ssoNote = new JLabel();
        
        this.setBorder(BorderFactory.createEtchedBorder());

        enhanceLabel.setText("Enhancements");

        ddeSlider.setMajorTickSpacing(1);
        ddeSlider.setMaximum((int)DDE_MAX);
        ddeSlider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                ddeTextField.setText(String.valueOf(ddeSlider.getValue()));
                setDdeMessage(ddeSlider.getValue());
            }
        });
        ddeMinLabel.setText(String.valueOf(DDE_MIN));
        ddeMaxLabel.setText(String.valueOf(DDE_MAX));
        ddeLabel.setText("DDE");
        ddeTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                int value = DDE_MAX + 1;
                try {
                    value = Integer.parseInt(ddeTextField.getText());
                } catch(NumberFormatException error){
                    ddeTextField.setText(String.valueOf(getAce()));
                }
                if(gui.isWithinRange(DDE_MIN, DDE_MAX, value)){
                    ddeSlider.setValue(value);
                } else {
                    ddeTextField.setText(String.valueOf(getAce()));
                }
            }
        });

        aceLabel.setText("ACE (Active Contrast Enhancement)");
        aceSlider.setMaximum(8);
        aceSlider.setMinimum(-8);
        aceSlider.setToolTipText("");
        aceSlider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                aceTextField.setText(String.valueOf(aceSlider.getValue()));
                setAceMessage(aceSlider.getValue());
            }
        });
        aceMinLabel.setText(String.valueOf(ACE_MIN));
        aceMaxLabel.setText(String.valueOf(ACE_MAX));
        aceTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                int value = ACE_MAX + 1;
                try {
                    value = Integer.parseInt(aceTextField.getText());
                } catch(NumberFormatException error){
                    aceTextField.setText(String.valueOf(getAce()));
                }
                if(gui.isWithinRange(ACE_MIN, ACE_MAX, value)){
                    aceSlider.setValue(value);
                } else {
                    aceTextField.setText(String.valueOf(getAce()));
                }
            }
        });

        ssoLabel.setText("SSO (Smart Scene Optimization)");
        ssoSlider.setToolTipText("");
        ssoSlider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                ssoTextField.setText(String.valueOf(ssoSlider.getValue()));
                setSsoMessage(ssoSlider.getValue());
            }
        });
        ssoMinLabel.setText(String.valueOf(SSO_MIN));
        ssoMaxLabel.setText(String.valueOf(SSO_MAX));
        ssoTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                int value = SSO_MAX + 1;
                try {
                    value = Integer.parseInt(ssoTextField.getText());
                } catch(NumberFormatException error){
                    ssoTextField.setText(String.valueOf(sso));
                }
                if(gui.isWithinRange(SSO_MIN, SSO_MAX, value)){
                    ssoSlider.setValue(value);
                } else {
                    ssoTextField.setText(String.valueOf(getSso()));
                }
            }
        });

        ddeNoteLine1.setFont(new java.awt.Font(null, 0, 10)); // NOI18N
        ddeNoteLine1.setText("NOTE: A DDE value of 17 is neutral and will have no effect. Values 0-16 will soften the image, values");
        ddeNoteLine2.setFont(new java.awt.Font(null, 0, 10)); // NOI18N
        ddeNoteLine2.setText("17-39 are normal values for sharpening the image, and values 40-63 are for extreme sharpening and ");
        ddeNoteLine3.setFont(new java.awt.Font(null, 0, 10)); // NOI18N
        ddeNoteLine3.setText("are not recommended.");

        aceNoteLine1.setFont(new java.awt.Font(null, 0, 10)); // NOI18N
        aceNoteLine1.setText("NOTE: A value of 0 is neutral. Negative values will effectively decrease contrast by making dark regions");
        aceNoteLine2.setFont(new java.awt.Font(null, 0, 10)); // NOI18N
        aceNoteLine2.setText("lighter, and positive values will effectively increase contrast by making dark regions darker.");

        ssoNote.setFont(new java.awt.Font(null, 0, 10)); // NOI18N
        ssoNote.setText("NOTE: Higher values increase linearity");

        GroupLayout enhancePanelLayout = new GroupLayout(this);
        this.setLayout(enhancePanelLayout);
        enhancePanelLayout.setHorizontalGroup(
            enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(enhancePanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(enhanceLabel)
                .addGap(393, 393, 393))
            .addGroup(enhancePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(enhancePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ddeLabel)
                        .addGap(231, 231, 231))
                    .addGroup(enhancePanelLayout.createSequentialGroup()
                        .addComponent(ddeNoteLine1)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(enhancePanelLayout.createSequentialGroup()
                        .addComponent(ddeMinLabel)
                        .addGap(187, 187, 187)
                        .addComponent(ddeTextField, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ddeMaxLabel)
                        .addGap(12, 12, 12))
                    .addGroup(enhancePanelLayout.createSequentialGroup()
                        .addGroup(enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(ddeNoteLine3)
                            .addComponent(ddeNoteLine2))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(enhancePanelLayout.createSequentialGroup()
                .addGroup(enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(enhancePanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(ddeSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(enhancePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(aceSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(enhancePanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(enhancePanelLayout.createSequentialGroup()
                                        .addComponent(aceMinLabel)
                                        .addGap(181, 181, 181)
                                        .addComponent(aceTextField, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(aceMaxLabel))
                                    .addGroup(enhancePanelLayout.createSequentialGroup()
                                        .addGroup(enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(enhancePanelLayout.createSequentialGroup()
                                                .addGap(123, 123, 123)
                                                .addComponent(aceLabel))
                                            .addComponent(aceNoteLine1)
                                            .addComponent(aceNoteLine2))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(GroupLayout.Alignment.TRAILING, enhancePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(ssoSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(enhancePanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(enhancePanelLayout.createSequentialGroup()
                                        .addComponent(ssoNote)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(enhancePanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(ssoLabel)
                                        .addGap(125, 125, 125))
                                    .addGroup(enhancePanelLayout.createSequentialGroup()
                                        .addComponent(ssoMinLabel)
                                        .addGap(187, 187, 187)
                                        .addComponent(ssoTextField, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ssoMaxLabel)))))))
                .addContainerGap())
        );

        enhancePanelLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {aceTextField, ddeTextField, ssoTextField});

        enhancePanelLayout.setVerticalGroup(
            enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(enhancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enhanceLabel)
                .addGap(18, 18, 18)
                .addComponent(ddeLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ddeSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ddeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ddeMinLabel)
                    .addComponent(ddeMaxLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ddeNoteLine1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ddeNoteLine2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ddeNoteLine3)
                .addGap(18, 18, 18)
                .addComponent(aceLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aceSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(aceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceMinLabel)
                    .addComponent(aceMaxLabel))
                .addGap(18, 18, 18)
                .addComponent(aceNoteLine1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aceNoteLine2)
                .addGap(39, 39, 39)
                .addComponent(ssoLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ssoSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(enhancePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ssoMinLabel)
                    .addComponent(ssoMaxLabel)
                    .addComponent(ssoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ssoNote)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    
    protected void getEnhanceSettings(){
        ThermalCamControl aceMsg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.ACE_CORRECT_GET);
        gui.sendCommand(aceMsg);
        ThermalCamControl ddeMsg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DDE_GAIN_GET);
        gui.sendCommand(ddeMsg);
        ThermalCamControl ssoMsg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.AGC_SUB_GET);
        ssoMsg.setArgs(gui.longtoTwoBytes(ThermalCamArguments.AGC_SSO_PERCENT.getArg()));
        gui.sendCommand(ssoMsg);        
    }
    
    private void setAceMessage(int value){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.ACE_CORRECT_SET);
        msg.setArgs(gui.longtoTwoBytes(value));
        gui.sendCommand(msg);
    }

    private void setDdeMessage(int value){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DDE_GAIN_SET);
        msg.setArgs(gui.longtoTwoBytes(value));
        gui.sendCommand(msg);
    }
    
    private void setSsoMessage(int value){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.AGC_SUB_SET);
        byte[] ssoPercentArg = gui.longtoTwoBytes(ThermalCamArguments.AGC_SSO_PERCENT.getArg());
        byte[] setting = gui.longtoTwoBytes(value);
        msg.setArgs(gui.concatenate(ssoPercentArg, setting));
        gui.sendCommand(msg);
    }

    protected void setAce(int value){
        this.ace = value;
        aceSlider.setValue((int)value);
        aceTextField.setText(String.valueOf(value));
    }
    
    protected int getAce(){
        return this.ace;
    }
    
    protected void setSso(int value){
        this.sso = value;
        ssoSlider.setValue((int)value);
        ssoTextField.setText(String.valueOf(value));
    }
    
    protected int getSso(){
        return this.sso;
    }
    
    protected void setDde(int value){
        this.dde = value;
        ddeSlider.setValue((int)value);
        ddeTextField.setText(String.valueOf(value));
    }
    
    protected int getDde(){
        return this.dde;
    }
    
    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.ACE_CORRECT_GET.getFunctionCode()){
            setAce((int)gui.twoBytesToLong(rec.getArgs()));
        } else if (rec.getFunction() == ThermalCamFunctionCodes.DDE_GAIN_GET.getFunctionCode()){
            setDde((int)gui.twoBytesToLong(rec.getArgs()));
        } else if ((rec.getFunction() == ThermalCamFunctionCodes.AGC_SUB_GET.getFunctionCode()) 
                && (gui.twoBytesToLong(sent.getArgs()) == ThermalCamArguments.AGC_SSO_PERCENT.getArg())){
            if(rec.getByteCount() > 0){
                setSso((int)gui.twoBytesToLong(rec.getArgs()));       
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
