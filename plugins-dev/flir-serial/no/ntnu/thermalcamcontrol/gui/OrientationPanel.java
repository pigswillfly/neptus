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
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

/**
 * @author liz
 *
 */
class OrientationPanel extends JPanel implements ReplyAction {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ThermalCamControlGui gui;
    
    private boolean invert;
    private boolean revert;
    
    private JCheckBox orientationInvertCheckBox = null;
    private JCheckBox orientationRevertCheckBox = null;
    private JLabel orientationLabel = null;

    protected OrientationPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        orientationInvertCheckBox = new JCheckBox();
        orientationRevertCheckBox = new JCheckBox();
        orientationLabel = new JLabel();

        this.setBorder(BorderFactory.createEtchedBorder());

        orientationLabel.setText("Orientation");
        
        orientationInvertCheckBox.setText("Invert (Flip the image vertically)");
        orientationInvertCheckBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setInvertRevertMessage(orientationInvertCheckBox.isSelected(), getRevert());
            }
        });
        orientationRevertCheckBox.setText("Revert (Flip the image horizontally)");
        orientationRevertCheckBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setInvertRevertMessage(getInvert(), orientationRevertCheckBox.isSelected());
            }
        });

        GroupLayout orientationPanelLayout = new GroupLayout(this);
        this.setLayout(orientationPanelLayout);
        orientationPanelLayout.setHorizontalGroup(
            orientationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(orientationPanelLayout.createSequentialGroup()
                .addGroup(orientationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(orientationPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(orientationLabel))
                    .addGroup(orientationPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(orientationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(orientationInvertCheckBox)
                            .addComponent(orientationRevertCheckBox))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        orientationPanelLayout.setVerticalGroup(
            orientationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(orientationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orientationLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orientationInvertCheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(orientationRevertCheckBox)
                .addContainerGap())
        );
    }
    
    protected void getInvertRevertMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.VIDEO_ORIENTATION_GET);
        gui.sendCommand(msg);
    }

    private void setInvertRevertMessage(boolean invert, boolean revert){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.VIDEO_ORIENTATION_SET);
        long arg = ThermalCamArguments.VIDEO_ORIENTATION_NORMAL.getArg();
        if(invert)
            arg |= ThermalCamArguments.VIDEO_ORIENTATION_INVERT.getArg();
        if(revert)
            arg |= ThermalCamArguments.VIDEO_ORIENTATION_REVERT.getArg();
        msg.setArgs(gui.longtoTwoBytes(arg));
        gui.sendCommand(msg);
    }
    
    protected boolean getInvert(){
        return this.invert;
    }
    
    protected void setInvert(boolean invert){
        this.invert = invert;
    }
    
    protected boolean getRevert(){
        return this.revert;
    }
    
    protected void setRevert(boolean revert){
        this.revert = revert;
    }
    
    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.VIDEO_ORIENTATION_GET.getFunctionCode()){
            long arg = gui.twoBytesToLong(rec.getArgs());
            setInvert((arg & ThermalCamArguments.VIDEO_ORIENTATION_INVERT.getArg()) == ThermalCamArguments.VIDEO_ORIENTATION_INVERT.getArg());
            setRevert((arg & ThermalCamArguments.VIDEO_ORIENTATION_REVERT.getArg()) == ThermalCamArguments.VIDEO_ORIENTATION_REVERT.getArg());
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
