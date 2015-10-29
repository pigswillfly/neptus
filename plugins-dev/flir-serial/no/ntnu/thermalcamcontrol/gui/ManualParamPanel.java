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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

/**
 * @author liz
 *
 */
class ManualParamPanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static final int BRIGHTNESS_MIN = 0;
    private static final int BRIGHTNESS_MAX = 16383;
    private static final int CONTRAST_MIN = 0;
    private static final int CONTRAST_MAX = 255;
    
    private ThermalCamControlGui gui;
    
    private long contrast;
    private long brightness;
    
    private JLabel brightnessLabel = null;
    private JLabel brightnessMaxLabel = null;
    private JLabel brightnessMinLabel = null;
    private JSlider brightnessSlider = null;
    private JTextField brightnessTextField = null;
    private JLabel contrastLabel = null;
    private JLabel contrastMaxLabel = null;
    private JLabel contrastMinLabel = null;
    private JSlider contrastSlider = null;
    private JTextField contrastTextField = null;
    private JCheckBox fineCheckBox = null;
    private JLabel manualParamLabel = null;
    private JButton oneShotButton = null;

    protected ManualParamPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){

        manualParamLabel = new JLabel();
        contrastSlider = new JSlider();
        contrastLabel = new JLabel();
        contrastMinLabel = new JLabel();
        contrastMaxLabel = new JLabel();
        contrastTextField = new JTextField();
        brightnessLabel = new JLabel();
        brightnessSlider = new JSlider();
        brightnessMinLabel = new JLabel();
        brightnessTextField = new JTextField();
        brightnessMaxLabel = new JLabel();
        fineCheckBox = new JCheckBox();
        oneShotButton = new JButton();
        
        this.setBorder(BorderFactory.createEtchedBorder());

        manualParamLabel.setFont(new java.awt.Font(null, 1, 15)); // NOI18N
        manualParamLabel.setText("Manual Parameters");

        contrastLabel.setText("Contrast");
        contrastSlider.setMinimum((int)CONTRAST_MIN);
        contrastSlider.setMaximum((int)CONTRAST_MAX);
        contrastSlider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                contrastTextField.setText(String.valueOf(contrastSlider.getValue()));
                setContrastMessage(contrastSlider.getValue());
            }
        });
        contrastMinLabel.setText(String.valueOf(CONTRAST_MIN));
        contrastMaxLabel.setText(String.valueOf(CONTRAST_MAX));
        contrastTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                int value = CONTRAST_MAX + 1;
                try {
                    value = Integer.parseInt(contrastTextField.getText());
                } catch(NumberFormatException error){
                    contrastTextField.setText(String.valueOf(getContrast()));
                }
                if(gui.isWithinRange(CONTRAST_MIN, CONTRAST_MAX, value)){
                    contrastSlider.setValue(value);
                } else {
                    contrastTextField.setText(String.valueOf(getContrast()));
                }
            }
        });

        brightnessLabel.setText("Brightness");
        brightnessSlider.setMinimum((int)BRIGHTNESS_MIN);
        brightnessSlider.setMaximum((int)BRIGHTNESS_MAX);
        brightnessSlider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                brightnessTextField.setText(String.valueOf(brightnessSlider.getValue()));
                setBrightnessMessage(brightnessSlider.getValue());
            }
        });
        brightnessMinLabel.setText(String.valueOf(BRIGHTNESS_MIN));
        brightnessMaxLabel.setText(String.valueOf(BRIGHTNESS_MAX));
        brightnessTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                int value = BRIGHTNESS_MAX + 1;
                try {
                    value = Integer.parseInt(brightnessTextField.getText());
                } catch(NumberFormatException error){
                    brightnessTextField.setText(String.valueOf(getBrightness()));
                }
                if(gui.isWithinRange(BRIGHTNESS_MIN, BRIGHTNESS_MAX, value)){
                    brightnessSlider.setValue(value);
                } else {
                    brightnessTextField.setText(String.valueOf(getBrightness()));
                }
            }
        });

        fineCheckBox.setFont(new java.awt.Font(null, 0, 12)); // NOI18N
        fineCheckBox.setText("Fine");

        oneShotButton.setText("<html><p>One-shot</p><p>Brightness</p><p>Adjustment</p>");
        oneShotButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                performOneShotMessage();
            }
        });

        GroupLayout manualParamPanelLayout = new GroupLayout(this);
        this.setLayout(manualParamPanelLayout);
        manualParamPanelLayout.setHorizontalGroup(
            manualParamPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(manualParamPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(fineCheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(oneShotButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(manualParamPanelLayout.createSequentialGroup()
                .addGroup(manualParamPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(manualParamPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(manualParamLabel))
                    .addGroup(manualParamPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(manualParamPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, manualParamPanelLayout.createSequentialGroup()
                                .addComponent(brightnessMinLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(brightnessTextField, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(brightnessMaxLabel))
                            .addGroup(GroupLayout.Alignment.LEADING, manualParamPanelLayout.createSequentialGroup()
                                .addComponent(contrastMinLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(manualParamPanelLayout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addGroup(manualParamPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(manualParamPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(brightnessSlider, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                        .addComponent(contrastSlider, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(manualParamPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(brightnessLabel)
                                        .addGroup(manualParamPanelLayout.createSequentialGroup()
                                            .addComponent(contrastTextField, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                            .addGap(68, 68, 68)
                                            .addComponent(contrastMaxLabel))))))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(manualParamPanelLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(contrastLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manualParamPanelLayout.setVerticalGroup(
            manualParamPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(manualParamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manualParamLabel)
                .addGap(18, 18, 18)
                .addComponent(contrastLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contrastSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manualParamPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(manualParamPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(contrastMinLabel)
                        .addComponent(contrastTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(contrastMaxLabel))
                .addGap(23, 23, 23)
                .addComponent(brightnessLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brightnessSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(manualParamPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(brightnessMinLabel)
                    .addComponent(brightnessMaxLabel)
                    .addComponent(brightnessTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(manualParamPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fineCheckBox)
                    .addComponent(oneShotButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );        
    }
    
    protected void getManualParams(){
        ThermalCamControl brightMsg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.BRIGHTNESS_BIAS_GET);
        gui.sendCommand(brightMsg);
        ThermalCamControl contrastMsg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.CONTRAST_GET);
        gui.sendCommand(contrastMsg);
    }
    
    protected void setBrightnessMessage(long value){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.BRIGHTNESS_SET);
        msg.setArgs(gui.longtoTwoBytes(value));
        gui.sendCommand(msg);
    }
    
    protected void setContrastMessage(long value){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.CONTRAST_SET);
        msg.setArgs(gui.longtoTwoBytes(value));
        gui.sendCommand(msg);
    }
    
    private void performOneShotMessage(){
        // finds mean of 14-bit histogram & set as brightness
    }
    
    protected void setBrightness(long value){
        this.brightness = value;
        brightnessSlider.setValue((int) value);
        brightnessTextField.setText(String.valueOf(value));
    }
    
    protected long getBrightness(){
        return this.brightness;
    }
    
    protected void setContrast(long value){
        this.contrast = value;
        contrastSlider.setValue((int)value);
        contrastTextField.setText(String.valueOf(value));
    }
    
    protected long getContrast(){
        return this.contrast;
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.BRIGHTNESS_GET.getFunctionCode()){
            setBrightness(gui.twoBytesToLong(rec.getArgs()));
        } else if (rec.getFunction() == ThermalCamFunctionCodes.CONTRAST_GET.getFunctionCode()){
            setContrast(gui.twoBytesToLong(rec.getArgs()));
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
