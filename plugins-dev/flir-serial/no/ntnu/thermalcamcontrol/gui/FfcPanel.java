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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

/**
 * @author liz
 *
 */
class FfcPanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static final long TEMP_DELTA_MIN = 0;
    private static final long TEMP_DELTA_MAX = 1000;
    private static final long FFC_PERIOD_MIN = 0;
    private static final long FFC_PERIOD_MAX = 30000;
    
    private ThermalCamControlGui gui = null;
    
    private int ffcMode;
    private long ffcTempDelta;
    private long lowGainFfcTempDelta;
    private long ffcPeriod;
    private long lowGainFfcPeriod;
    
    private JLabel ffcLabel = null;
    private JRadioButton ffcAutoRadioButton = null;
    private JRadioButton ffcManualRadioButton = null;
    private JRadioButton ffcExternalRadioButton = null;
    private ButtonGroup ffcButtonGroup = null;
    private JLabel ffcIntervalLabel = null;
    private JTextField ffcIntervalText = null;
    private JLabel ffcIntervalUnitLabel = null;
    private JLabel lowGainFFCIntervalLabel = null;
    private JTextField lowGainFFCIntervalText = null;
    private JLabel lowGainFFCIntervalUnitLabel = null;
    private JLabel tempChangeLabel = null;
    private JTextField tempChangeText = null;
    private JLabel tempChangeUnitLabel = null;
    private JLabel lowGainTempChangeLabel = null;
    private JTextField lowGainTempChangeText = null;
    private JLabel lowGainTempChangeUnitLabel = null;
    private JButton doFFCButton = null;
    private JPanel ssnPanel = null;
    
    protected FfcPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        ffcLabel = new JLabel();
        ffcAutoRadioButton = new JRadioButton();
        ffcManualRadioButton = new JRadioButton();
        ffcExternalRadioButton = new JRadioButton();
        ffcButtonGroup = new ButtonGroup();
        ffcIntervalLabel = new JLabel();
        ffcIntervalText = new JTextField();
        ffcIntervalUnitLabel = new JLabel();
        lowGainFFCIntervalLabel = new JLabel();
        lowGainFFCIntervalText = new JTextField();
        lowGainFFCIntervalUnitLabel = new JLabel();
        tempChangeLabel = new JLabel();
        tempChangeText = new JTextField();
        tempChangeUnitLabel = new JLabel();
        lowGainTempChangeLabel = new JLabel();
        lowGainTempChangeText = new JTextField();
        lowGainTempChangeUnitLabel = new JLabel();
        doFFCButton = new JButton();
        ssnPanel = new SsnPanel();
        
        ffcButtonGroup.add(ffcManualRadioButton);
        ffcButtonGroup.add(ffcAutoRadioButton);
        ffcButtonGroup.add(ffcExternalRadioButton);
        
        this.setBorder(BorderFactory.createEtchedBorder());
        ffcLabel.setText("Flat Field Correction");

        ffcAutoRadioButton.setText("Auto");
        ffcAutoRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                if(ffcMode != ThermalCamArguments.FFC_MODE_AUTO.getArg()){
                    setFFCModeMessage(ThermalCamArguments.FFC_MODE_AUTO.getArg());
                }                
            }
        });
        ffcManualRadioButton.setText("Manual");
        ffcManualRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                if(ffcMode != ThermalCamArguments.FFC_MODE_MANUAL.getArg()){
                    setFFCModeMessage(ThermalCamArguments.FFC_MODE_MANUAL.getArg());
                }
            }
        });
        ffcExternalRadioButton.setText("External");
        ffcExternalRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                if(ffcMode != ThermalCamArguments.FFC_MODE_EXTERNAL.getArg()){
                    setFFCModeMessage(ThermalCamArguments.FFC_MODE_EXTERNAL.getArg());
                }
            }
        });
        
        tempChangeText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                long value = TEMP_DELTA_MAX + 1;
                try {
                    value = Long.parseLong(tempChangeText.getText());
                } catch(NumberFormatException error){
                    tempChangeText.setText(String.valueOf(ffcTempDelta));
                }
                if((value > TEMP_DELTA_MIN) && (value < TEMP_DELTA_MAX)){
                    setFFCTempDeltaOrPeriodMessage(lowGainFfcTempDelta, value, false, false);
                    ffcTempDelta = value;
                } else {
                    tempChangeText.setText(String.valueOf(ffcTempDelta));
                }
            }
        });
        
        lowGainTempChangeText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                long value = TEMP_DELTA_MAX + 1;
                try {
                    value = Long.parseLong(lowGainTempChangeText.getText());
                } catch(NumberFormatException error){
                    lowGainTempChangeText.setText(String.valueOf(lowGainFfcTempDelta));
                }
                if((value > TEMP_DELTA_MIN) && (value < TEMP_DELTA_MAX)){
                    setFFCTempDeltaOrPeriodMessage(value, ffcTempDelta, false, false);
                    lowGainFfcTempDelta = value;
                } else {
                    lowGainTempChangeText.setText(String.valueOf(lowGainFfcTempDelta));
                }
            }
        });
        
        ffcIntervalText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                long value = FFC_PERIOD_MAX + 1;
                try {
                    value = Long.parseLong(ffcIntervalText.getText());
                } catch(NumberFormatException error){
                    ffcIntervalText.setText(String.valueOf(ffcPeriod));
                }
                if((value > FFC_PERIOD_MIN) && (value < FFC_PERIOD_MAX)){
                    setFFCTempDeltaOrPeriodMessage(lowGainFfcPeriod, value, false, true);
                    ffcPeriod = value;
                } else {
                    ffcIntervalText.setText(String.valueOf(ffcPeriod));
                }
            }
        });
        
        lowGainFFCIntervalText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                long value = FFC_PERIOD_MAX + 1;
                try {
                    value = Long.parseLong(lowGainFFCIntervalText.getText());
                } catch(NumberFormatException error){
                    lowGainFFCIntervalText.setText(String.valueOf(lowGainFfcPeriod));
                }
                if((value > FFC_PERIOD_MIN) && (value < FFC_PERIOD_MAX)){
                    setFFCTempDeltaOrPeriodMessage(value, ffcPeriod, false, true);
                    lowGainFfcPeriod = value;
                } else {
                    lowGainFFCIntervalText.setText(String.valueOf(lowGainFfcPeriod));
                }
            }
        });

        ffcIntervalLabel.setText("FFC Interval");
        lowGainFFCIntervalLabel.setText("Low Gain FFC Interval");
        lowGainFFCIntervalUnitLabel.setText("frames");
        ffcIntervalUnitLabel.setText("frames");
        
        lowGainTempChangeLabel.setText("Low Gain Temp Change");
        tempChangeLabel.setText("Temp Change");
        tempChangeUnitLabel.setText("0.1 °C");
        lowGainTempChangeUnitLabel.setText("0.1 °C");

        doFFCButton.setText("Do FFC");

        GroupLayout ffcPanelLayout = new GroupLayout(this);
        this.setLayout(ffcPanelLayout);
        ffcPanelLayout.setHorizontalGroup(
            ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ffcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ssnPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ffcLabel, GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.LEADING, ffcPanelLayout.createSequentialGroup()
                        .addComponent(ffcManualRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(ffcAutoRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(ffcExternalRadioButton))
                    .addComponent(doFFCButton)
                    .addGroup(ffcPanelLayout.createSequentialGroup()
                        .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(ffcIntervalLabel)
                            .addComponent(lowGainTempChangeLabel)
                            .addComponent(tempChangeLabel)
                            .addComponent(lowGainFFCIntervalLabel))
                        .addGap(18, 18, 18)
                        .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(ffcPanelLayout.createSequentialGroup()
                                .addComponent(lowGainTempChangeText, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lowGainTempChangeUnitLabel))
                            .addGroup(ffcPanelLayout.createSequentialGroup()
                                .addComponent(tempChangeText)
                                .addGap(18, 18, 18)
                                .addComponent(tempChangeUnitLabel))
                            .addGroup(ffcPanelLayout.createSequentialGroup()
                                .addComponent(lowGainFFCIntervalText)
                                .addGap(18, 18, 18)
                                .addComponent(lowGainFFCIntervalUnitLabel))
                            .addGroup(ffcPanelLayout.createSequentialGroup()
                                .addComponent(ffcIntervalText)
                                .addGap(18, 18, 18)
                                .addComponent(ffcIntervalUnitLabel)))))
                .addContainerGap())
        );

        ffcPanelLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {ffcIntervalText, lowGainFFCIntervalText, lowGainTempChangeText, tempChangeText});

        ffcPanelLayout.setVerticalGroup(
            ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ffcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ffcLabel)
                .addGap(18, 18, 18)
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ffcManualRadioButton)
                    .addComponent(ffcAutoRadioButton)
                    .addComponent(ffcExternalRadioButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ffcIntervalText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ffcIntervalLabel)
                    .addComponent(ffcIntervalUnitLabel))
                .addGap(18, 18, 18)
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lowGainFFCIntervalText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowGainFFCIntervalLabel)
                    .addComponent(lowGainFFCIntervalUnitLabel))
                .addGap(18, 18, 18)
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tempChangeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tempChangeLabel)
                    .addComponent(tempChangeUnitLabel))
                .addGap(18, 18, 18)
                .addGroup(ffcPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lowGainTempChangeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowGainTempChangeLabel)
                    .addComponent(lowGainTempChangeUnitLabel))
                .addGap(18, 18, 18)
                .addComponent(doFFCButton)
                .addGap(18, 18, 18)
                .addComponent(ssnPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }
    
    protected void askForSettings(){
        ThermalCamControl modeMsg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.FFC_MODE_SELECT_GET);
        gui.sendCommand(modeMsg);
        ThermalCamControl tempDeltaMsg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.FFC_TEMP_DELTA_GET);
        gui.sendCommand(tempDeltaMsg);
        ThermalCamControl periodMsg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.FFC_PERIOD_GET);
        gui.sendCommand(periodMsg);
    }
    
    protected void setFFCModeMessage(long arg){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.FFC_MODE_SELECT_SET);
        byte[] args = new byte[msg.getByteCount()];
        args[0] = 0x00;
        args[1] = (byte) arg;
        msg.setArgs(args);
        gui.sendCommand(msg);
    }
    
    protected void setFFCTempDeltaOrPeriodMessage(long lowGain, long highGain, boolean oneOnly, boolean period){
        ThermalCamFunctionCodes code = null;
        if((period) && (oneOnly)){
            code = ThermalCamFunctionCodes.FFC_PERIOD_SET;
        } else if ((period) && (!oneOnly)){
            code = ThermalCamFunctionCodes.FFC_PERIOD_SPECIFY;
        } else if ((!period) && (oneOnly)){
            code = ThermalCamFunctionCodes.FFC_TEMP_DELTA_SET;
        } else if ((!period) && (!oneOnly)){
            code = ThermalCamFunctionCodes.FFC_TEMP_DELTA_SPECIFY;
        }
        
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(code);
        byte[] args = new byte[msg.getByteCount()];
        
        if(oneOnly){
            if(gui.getSetupPanel().getGainModePanel().getGainMode() == ThermalCamArguments.GAIN_MODE_LOW.getArg()){
                args = gui.longtoTwoBytes(lowGain);
                msg.setArgs(args);
            } else if (gui.getSetupPanel().getGainModePanel().getGainMode() == ThermalCamArguments.GAIN_MODE_HIGH.getArg()){
                args = gui.longtoTwoBytes(highGain);
                msg.setArgs(args);
            }
        } else {
            byte[] lowGainArg = gui.longtoTwoBytes(lowGain);
            byte[] highGainArg = gui.longtoTwoBytes(highGain);
            args[0] = lowGainArg[0];
            args[1] = lowGainArg[1];
            args[2] = highGainArg[0];
            args[3] = highGainArg[1];
            msg.setArgs(args);
        }
        
        gui.sendCommand(msg);
        
    }
    
    protected void setFFCMode(int setting){
        if(setting == ThermalCamArguments.FFC_MODE_AUTO.getArg()){
            ffcAutoRadioButton.setSelected(true);
            ffcMode = setting;
        } else if (setting == ThermalCamArguments.FFC_MODE_MANUAL.getArg()){
            ffcManualRadioButton.setSelected(true);
            ffcMode = setting;
        } else if (setting == ThermalCamArguments.FFC_MODE_EXTERNAL.getArg()){
            ffcExternalRadioButton.setSelected(true);
            ffcMode = setting;
        } else {
            //unknown mode
        }
    }
    
    protected int getFFCMode(){
        return ffcMode;
    }
    
    protected void setFFCTempDelta(long tempDelta, boolean lowGain){
        if(lowGain){
            lowGainTempChangeText.setText(String.valueOf(tempDelta));    
            this.lowGainFfcTempDelta = tempDelta;
        } else {
            tempChangeText.setText(String.valueOf(tempDelta));
            this.ffcTempDelta = tempDelta;
        }
    }
    
    protected long getFFCTempDelta(boolean lowGain){
        if(lowGain){
            return this.lowGainFfcTempDelta;
        } else {
            return this.ffcTempDelta;
        }
    }
    
    protected void setFFCPeriod(long period, boolean lowGain){
        if(lowGain){
            lowGainFFCIntervalText.setText(String.valueOf(period));    
            this.lowGainFfcPeriod = period;
        } else {
            ffcIntervalText.setText(String.valueOf(period));
            this.ffcPeriod = period;
        }
    }
    
    protected long getFFCPeriod(boolean lowGain){
        if(lowGain){
            return this.lowGainFfcPeriod;
        } else {
            return this.ffcPeriod;
        }
    }

    private boolean isCurrentGainLow(){
        return (gui.getSetupPanel().getGainModePanel().getGainMode() == ThermalCamArguments.GAIN_MODE_LOW.getArg());
    }
    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        int function = rec.getFunction();
        if(function == ThermalCamFunctionCodes.FFC_MODE_SELECT_GET.getFunctionCode()){
            if(sent.getByteCount() < ThermalCamFunctionCodes.FFC_INTEG_FRAMES_GET.getCmdByteCount()){
                if((sent.equals(rec)) || (sent.getByteCount() == 0)){
                    int setting = rec.getArgs()[1];
                    setFFCMode(setting);
                } else {
                    //reply has different setting to command
                }
            } else if (sent.getByteCount() == ThermalCamFunctionCodes.FFC_INTEG_FRAMES_GET.getCmdByteCount()){
               
                /* 
                int setOrGet = sent.getArgs()[1];
                if(setOrGet == ThermalCamArguments.FFC_INTEG_FRAMES_SET.getArg()){
                    if(rec.getByteCount() == ThermalCamFunctionCodes.FFC_INTEG_FRAMES_SET.getCmdByteCount()){
                        // all is well, setting took
                    }
                } else if (setOrGet == ThermalCamArguments.FFC_INTEG_FRAMES_GET.getArg()){
                    int mode = rec.getArgs()[1];
                    if(mode == ThermalCamArguments.FFC_INTEG_FRAMES_4.getArg()){
                        
                    } else if (mode == ThermalCamArguments.FFC_INTEG_FRAMES_8.getArg()){
                        
                    } else if (mode == ThermalCamArguments.FFC_INTEG_FRAMES_16.getArg()){
                        
                    }
                }
                */
            }
        } else if (function == ThermalCamFunctionCodes.DO_FFC_AUTO.getFunctionCode()){
            // check status
        } else if (function == ThermalCamFunctionCodes.FFC_PERIOD_GET.getFunctionCode()){
            if(rec.getByteCount() == ThermalCamFunctionCodes.FFC_PERIOD_SET.getReplyByteCount()){
                long ffcPeriod = gui.twoBytesToLong(rec.getArgs()[2], rec.getArgs()[3]);
                setFFCPeriod(ffcPeriod, isCurrentGainLow());
            } else if (rec.getByteCount() == ThermalCamFunctionCodes.FFC_PERIOD_GET.getReplyByteCount()){
                long lowGainPeriod = gui.twoBytesToLong(rec.getArgs()[0], rec.getArgs()[1]);
                long highGainPeriod = gui.twoBytesToLong(rec.getArgs()[2], rec.getArgs()[3]);
                setFFCPeriod(lowGainPeriod, true);
                setFFCPeriod(highGainPeriod, false);
            } 
        } else if (function == ThermalCamFunctionCodes.FFC_TEMP_DELTA_GET.getFunctionCode()){
            if(rec.getByteCount() == ThermalCamFunctionCodes.FFC_TEMP_DELTA_SET.getReplyByteCount()){
                long tempDelta = gui.twoBytesToLong(rec.getArgs()[2], rec.getArgs()[3]);
                setFFCTempDelta(tempDelta, isCurrentGainLow());
            } else if (rec.getByteCount() == ThermalCamFunctionCodes.FFC_TEMP_DELTA_GET.getReplyByteCount()){
                long lowGainTempDelta = gui.twoBytesToLong(rec.getArgs()[0], rec.getArgs()[1]);
                long highGainTempDelta = gui.twoBytesToLong(rec.getArgs()[2], rec.getArgs()[3]);
                setFFCTempDelta(lowGainTempDelta, true);
                setFFCTempDelta(highGainTempDelta, false);
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
