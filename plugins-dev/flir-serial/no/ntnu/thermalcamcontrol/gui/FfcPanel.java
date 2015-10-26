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
    
    private ThermalCamControlGui gui = null;
    
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

        ffcAutoRadioButton.setText("Auto");

        tempChangeUnitLabel.setText("0.1 °C");

        ffcLabel.setFont(new java.awt.Font(null, 1, 15)); // NOI18N
        ffcLabel.setText("Flat Field Correction");

        lowGainTempChangeLabel.setFont(new java.awt.Font(null, 0, 12)); // NOI18N
        lowGainTempChangeLabel.setText("Low Gain Temp Change");

        ffcManualRadioButton.setText("Manual");

        doFFCButton.setText("Do FFC");

        tempChangeLabel.setFont(new java.awt.Font(null, 0, 12)); // NOI18N
        tempChangeLabel.setText("Temp Change");

        lowGainFFCIntervalUnitLabel.setText("frames");

        ffcIntervalUnitLabel.setText("frames");

        ffcIntervalLabel.setFont(new java.awt.Font(null, 0, 12)); // NOI18N
        ffcIntervalLabel.setText("FFC Interval");

        lowGainFFCIntervalLabel.setFont(new java.awt.Font(null, 0, 12)); // NOI18N
        lowGainFFCIntervalLabel.setText("Low Gain FFC Interval");

        lowGainTempChangeUnitLabel.setText("0.1 °C");

        ffcExternalRadioButton.setText("External");

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

    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        
        if(rec.getFunction() == ThermalCamFunctionCodes.FFC_MODE_SELECT_GET.getFunctionCode()){
            if(sent.getByteCount() < ThermalCamFunctionCodes.FFC_INTEG_FRAMES_GET.getCmdByteCount()){
                if((sent.equals(rec)) || (sent.getByteCount() == 0)){
                    long setting = rec.getArgs()[1];
                    if(setting == ThermalCamArguments.FFC_MODE_AUTO.getArg()){
                        ffcAutoRadioButton.setSelected(true);
                    } else if (setting == ThermalCamArguments.FFC_MODE_MANUAL.getArg()){
                        ffcManualRadioButton.setSelected(true);
                    } else if (setting == ThermalCamArguments.FFC_MODE_EXTERNAL.getArg()){
                        ffcExternalRadioButton.setSelected(true);
                    } else {
                        //unknown mode
                    }
                } else {
                    //reply has different setting to command
                }
            } else if (sent.getByteCount() == ThermalCamFunctionCodes.FFC_INTEG_FRAMES_GET.getCmdByteCount()){
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
            }
        } else if (rec.getFunction() == ThermalCamFunctionCodes.DO_FFC_AUTO.getFunctionCode()){
            // check status
        } else if (rec.getFunction() == ThermalCamFunctionCodes.FFC_PERIOD_GET.getFunctionCode()){
            if((sent.getByteCount() == ThermalCamFunctionCodes.FFC_PERIOD_SET.getCmdByteCount()) 
            && (rec.getByteCount() == ThermalCamFunctionCodes.FFC_PERIOD_SET.getReplyByteCount())){
                long gainMode = gui.getSetupPanel().getGainModePanel().getGainMode();
                long ffcPeriod = gui.twoBytesToLong(rec.getArgs()[2], rec.getArgs()[3]);
                if(gainMode == ThermalCamArguments.GAIN_MODE_LOW.getArg()){
                    lowGainFFCIntervalText.setText(String.valueOf(ffcPeriod));    
                } else if (gainMode == ThermalCamArguments.GAIN_MODE_HIGH.getArg()){
                    ffcIntervalText.setText(String.valueOf(ffcPeriod));
                } else {
                    // Don't know gain mode
                }
            } else if ((sent.getByteCount() == ThermalCamFunctionCodes.FFC_PERIOD_GET.getCmdByteCount()) 
                    && (rec.getByteCount() == ThermalCamFunctionCodes.FFC_PERIOD_GET.getReplyByteCount())){
                long lowGainPeriod, highGainPeriod;
                lowGainPeriod = gui.twoBytesToLong(rec.getArgs()[0], rec.getArgs()[1]);
                highGainPeriod = gui.twoBytesToLong(rec.getArgs()[2], rec.getArgs()[3]);
                lowGainFFCIntervalText.setText(String.valueOf(lowGainPeriod));
                ffcIntervalText.setText(String.valueOf(highGainPeriod));
            }

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
