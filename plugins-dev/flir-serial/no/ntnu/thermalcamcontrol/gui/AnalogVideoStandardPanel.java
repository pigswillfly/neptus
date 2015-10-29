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
class AnalogVideoStandardPanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ThermalCamControlGui gui;
    
    private long videoStandard;
    
    private JLabel videoStandardLabel = null;
    private JLabel videoStandardNote1Label = null;
    private JLabel videoStandardNote2Label = null;
    private JRadioButton ntsc30RadioButton = null;
    private JRadioButton ntsc60RadioButton = null;
    private JRadioButton pal25RadioButton = null;
    private JRadioButton pal50RadioButton = null;
    private ButtonGroup videoStandardButtonGroup = null;

    protected AnalogVideoStandardPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        
        videoStandardLabel = new JLabel();
        videoStandardNote1Label = new JLabel();
        videoStandardNote2Label = new JLabel();
        ntsc30RadioButton = new JRadioButton();
        ntsc60RadioButton = new JRadioButton();
        pal25RadioButton = new JRadioButton();
        pal50RadioButton = new JRadioButton();
        videoStandardButtonGroup = new ButtonGroup();
        
        videoStandardButtonGroup.add(ntsc30RadioButton);
        videoStandardButtonGroup.add(ntsc60RadioButton);
        videoStandardButtonGroup.add(pal25RadioButton);
        videoStandardButtonGroup.add(pal50RadioButton);
        
        this.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        videoStandardLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        videoStandardLabel.setText("Video Standard");
        videoStandardNote1Label.setText("Note: Perform FFC ");
        videoStandardNote2Label.setText("after switching");

        ntsc30RadioButton.setText("NTSC 30Hz");
        ntsc30RadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVideoStandardMessage(ThermalCamArguments.VIDEO_STANDARD_NTSC_30HZ.getArg());
            }
        });

        pal25RadioButton.setText("PAL 25Hz");
        pal25RadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVideoStandardMessage(ThermalCamArguments.VIDEO_STANDARD_PAL_25HZ.getArg());
            }
        });

        ntsc60RadioButton.setText("NTSC 60Hz");
        ntsc60RadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVideoStandardMessage(ThermalCamArguments.VIDEO_STANDARD_NTSC_60HZ.getArg());
            }
        });

        pal50RadioButton.setText("PAL 50Hz");
        pal50RadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVideoStandardMessage(ThermalCamArguments.VIDEO_STANDARD_PAL_50HZ.getArg());
            }
        });

        javax.swing.GroupLayout videoStandardPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(videoStandardPanelLayout);
        videoStandardPanelLayout.setHorizontalGroup(
            videoStandardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(videoStandardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(videoStandardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(videoStandardPanelLayout.createSequentialGroup()
                        .addComponent(pal25RadioButton)
                        .addGap(12, 12, 12))
                    .addComponent(videoStandardLabel)
                    .addComponent(ntsc30RadioButton))
                .addGap(27, 27, 27)
                .addGroup(videoStandardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ntsc60RadioButton)
                    .addComponent(pal50RadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(videoStandardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(videoStandardNote1Label)
                    .addComponent(videoStandardNote2Label))
                .addGap(25, 25, 25))
        );
        videoStandardPanelLayout.setVerticalGroup(
            videoStandardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(videoStandardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(videoStandardLabel)
                .addGroup(videoStandardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(videoStandardPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(videoStandardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ntsc30RadioButton)
                            .addComponent(ntsc60RadioButton))
                        .addGap(16, 16, 16)
                        .addGroup(videoStandardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pal25RadioButton)
                            .addComponent(pal50RadioButton))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, videoStandardPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(videoStandardNote1Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(videoStandardNote2Label)
                        .addGap(36, 36, 36))))
        );

    }
    
    private void setVideoStandardMessage(long arg){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.VIDEO_STANDARD_SET);
        msg.setArgs(gui.longtoTwoBytes(arg));
        gui.sendCommand(msg);
    }

    protected void getVideoStandardMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.VIDEO_STANDARD_GET);
        gui.sendCommand(msg);
    }
    
    protected void setVideoStandard(long standard){
        if(standard == ThermalCamArguments.VIDEO_STANDARD_NTSC_30HZ.getArg()){
            this.videoStandard = standard;
            ntsc30RadioButton.setSelected(true);
        } else if (standard == ThermalCamArguments.VIDEO_STANDARD_PAL_25HZ.getArg()){
            this.videoStandard = standard;
            pal25RadioButton.setSelected(true);
        } else if (standard == ThermalCamArguments.VIDEO_STANDARD_NTSC_60HZ.getArg()){
            this.videoStandard = standard;
            ntsc60RadioButton.setSelected(true);
        } else if (standard == ThermalCamArguments.VIDEO_STANDARD_PAL_50HZ.getArg()){
            this.videoStandard = standard;
            pal50RadioButton.setSelected(true);
        } else {
            pal50RadioButton.setSelected(false);
            ntsc60RadioButton.setSelected(false);
            pal25RadioButton.setSelected(false);
            ntsc30RadioButton.setSelected(false);
        }
    }
    
    protected long getVideoStandard(){
        return this.videoStandard;
    }
    
    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.VIDEO_STANDARD_GET.getFunctionCode()){
            setVideoStandard(gui.twoBytesToLong(rec.getArgs()));
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
