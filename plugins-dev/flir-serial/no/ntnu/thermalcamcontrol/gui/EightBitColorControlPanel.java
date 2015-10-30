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
import javax.swing.JCheckBox;
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
class EightBitColorControlPanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ThermalCamControlGui gui;
    
    private long bayerOrder;
    
    private JLabel eightBitColorControlLabel = null;
    private JCheckBox colorizationEnableCheckBox = null;
    
    private JPanel bayerOrderPanel = null;
    private JLabel bayerOrderLabel = null;
    private JRadioButton bayerOrderGBFilterRadioButton = null;
    private JRadioButton bayerOrderGRFilterRadioButton = null;
    private JRadioButton bayerOrderRGFilterRadioButton = null;
    private JRadioButton bayerOrderBGFilterRadioButton = null;
    private ButtonGroup bayerOrderButtonGroup = null;
    
    private JPanel ySubSamplingPanel = null;
    private JLabel ySubSamplingLabel = null;
    private JRadioButton ySubSamplingCenterRadioButton = null;
    private JRadioButton ySubSamplingPositedRadioButton = null;
    private ButtonGroup ySubSamplingButtonGroup = null;
    
    private JPanel yOrderPanel = null;
    private JLabel yOrderLabel = null;
    private JRadioButton cFirstRadioButton = null;
    private JRadioButton yFirstRadioButton = null;
    private ButtonGroup yOrderButtonGroup = null;
    
    protected EightBitColorControlPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        eightBitColorControlLabel = new JLabel();
        colorizationEnableCheckBox = new JCheckBox();
        
        this.setBorder(BorderFactory.createEtchedBorder());

        eightBitColorControlLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        eightBitColorControlLabel.setText("8-bit Digital Channel Colorization Controls");
        colorizationEnableCheckBox.setText("Colorization Enable");

        GroupLayout eightBitColorControlPanelLayout = new GroupLayout(this);
        this.setLayout(eightBitColorControlPanelLayout);
        eightBitColorControlPanelLayout.setHorizontalGroup(
            eightBitColorControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitColorControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eightBitColorControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(eightBitColorControlLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorizationEnableCheckBox)
                    .addComponent(getBayerOrderPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getYSubSamplingPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getYOrderPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        eightBitColorControlPanelLayout.setVerticalGroup(
            eightBitColorControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitColorControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eightBitColorControlLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(getBayerOrderPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(getYSubSamplingPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(getYOrderPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(colorizationEnableCheckBox)
                .addContainerGap())
        );
    }

    private JPanel getBayerOrderPanel(){
        
        if(bayerOrderPanel == null){
            
            bayerOrderPanel = new JPanel();
            bayerOrderLabel = new JLabel();
            bayerOrderGBFilterRadioButton = new JRadioButton();
            bayerOrderGRFilterRadioButton = new JRadioButton();
            bayerOrderRGFilterRadioButton = new JRadioButton();
            bayerOrderBGFilterRadioButton = new JRadioButton();
            bayerOrderButtonGroup = new ButtonGroup();
            
            bayerOrderButtonGroup.add(bayerOrderGBFilterRadioButton);
            bayerOrderButtonGroup.add(bayerOrderGRFilterRadioButton);
            bayerOrderButtonGroup.add(bayerOrderRGFilterRadioButton);
            bayerOrderButtonGroup.add(bayerOrderBGFilterRadioButton);
            
            bayerOrderPanel.setBorder(BorderFactory.createEtchedBorder());
            bayerOrderLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
            bayerOrderLabel.setText("Bayer Order");
            
            bayerOrderGBFilterRadioButton.setText("GB Filter");
            bayerOrderGBFilterRadioButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    setBayerOrderMessage(ThermalCamArguments.BAYER_ENCODE_GB.getArg());
                }
            });
    
            bayerOrderGRFilterRadioButton.setText("GR Filter");
            bayerOrderGRFilterRadioButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    setBayerOrderMessage(ThermalCamArguments.BAYER_ENCODE_GR.getArg());
                }
            });
    
            bayerOrderRGFilterRadioButton.setText("RG Filter");
            bayerOrderRGFilterRadioButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    setBayerOrderMessage(ThermalCamArguments.BAYER_ENCODE_RG.getArg());
                }
            });
    
            bayerOrderBGFilterRadioButton.setText("BG Filter");
            bayerOrderBGFilterRadioButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    setBayerOrderMessage(ThermalCamArguments.BAYER_ENCODE_BG.getArg());
                }
            });
    
            GroupLayout bayerOrderPanelLayout = new GroupLayout(bayerOrderPanel);
            bayerOrderPanel.setLayout(bayerOrderPanelLayout);
            bayerOrderPanelLayout.setHorizontalGroup(
                bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(bayerOrderPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bayerOrderLabel)
                        .addGroup(bayerOrderPanelLayout.createSequentialGroup()
                            .addGroup(bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(bayerOrderGRFilterRadioButton)
                                .addComponent(bayerOrderGBFilterRadioButton))
                            .addGap(18, 18, 18)
                            .addGroup(bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(bayerOrderRGFilterRadioButton)
                                .addComponent(bayerOrderBGFilterRadioButton))))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            bayerOrderPanelLayout.setVerticalGroup(
                bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(bayerOrderPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(bayerOrderLabel)
                    .addGap(18, 18, 18)
                    .addGroup(bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(bayerOrderGRFilterRadioButton)
                        .addComponent(bayerOrderBGFilterRadioButton))
                    .addGap(7, 7, 7)
                    .addGroup(bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(bayerOrderGBFilterRadioButton)
                        .addComponent(bayerOrderRGFilterRadioButton))
                    .addGap(60, 60, 60))
            );
            bayerOrderGRFilterRadioButton.setSelected(true);
            }        
            return bayerOrderPanel;
        }

    private JPanel getYSubSamplingPanel(){

        if(ySubSamplingPanel == null){
        
            ySubSamplingPanel = new JPanel();
            ySubSamplingLabel = new JLabel();
            ySubSamplingCenterRadioButton = new JRadioButton();
            ySubSamplingPositedRadioButton = new JRadioButton();
            ySubSamplingButtonGroup = new ButtonGroup();
            
            ySubSamplingButtonGroup.add(ySubSamplingCenterRadioButton);
            ySubSamplingButtonGroup.add(ySubSamplingPositedRadioButton);
            
            ySubSamplingPanel.setBorder(BorderFactory.createEtchedBorder());

            ySubSamplingLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
            ySubSamplingLabel.setText("YCbCr Sub-Sampling");
    
            ySubSamplingCenterRadioButton.setText("422 Center");
            ySubSamplingCenterRadioButton.setEnabled(false);
    
            ySubSamplingPositedRadioButton.setText("422 Posited");
            ySubSamplingPositedRadioButton.setEnabled(false);

            GroupLayout ySubSamplingPanelLayout = new GroupLayout(ySubSamplingPanel);
            ySubSamplingPanel.setLayout(ySubSamplingPanelLayout);
            ySubSamplingPanelLayout.setHorizontalGroup(
                ySubSamplingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(ySubSamplingPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(ySubSamplingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(ySubSamplingLabel)
                        .addComponent(ySubSamplingPositedRadioButton)
                        .addComponent(ySubSamplingCenterRadioButton))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            ySubSamplingPanelLayout.setVerticalGroup(
                ySubSamplingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(ySubSamplingPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ySubSamplingLabel)
                    .addGap(18, 18, 18)
                    .addComponent(ySubSamplingCenterRadioButton)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(ySubSamplingPositedRadioButton)
                    .addContainerGap(56, Short.MAX_VALUE))
            );
        }
        return ySubSamplingPanel;
        
    }
    
    private JPanel getYOrderPanel(){
            
        if(yOrderPanel == null){
            
            yOrderPanel = new JPanel();
            yOrderLabel = new JLabel();
            cFirstRadioButton = new JRadioButton();
            yFirstRadioButton = new JRadioButton();
            yOrderButtonGroup = new ButtonGroup();
            
            yOrderButtonGroup.add(cFirstRadioButton);
            yOrderButtonGroup.add(yFirstRadioButton);
            
            yOrderPanel.setBorder(BorderFactory.createEtchedBorder());
    
            yOrderLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
            yOrderLabel.setText("YCbCr Order");
    
            cFirstRadioButton.setText("CbYCrY");
            cFirstRadioButton.setEnabled(false);
            yFirstRadioButton.setText("YCbYCr");
            yFirstRadioButton.setEnabled(false);
    
            GroupLayout yOrderPanelLayout = new GroupLayout(yOrderPanel);
            yOrderPanel.setLayout(yOrderPanelLayout);
            yOrderPanelLayout.setHorizontalGroup(
                yOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(yOrderPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(yOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(yOrderLabel)
                        .addComponent(yFirstRadioButton)
                        .addComponent(cFirstRadioButton))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            yOrderPanelLayout.setVerticalGroup(
                yOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(yOrderPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(yOrderLabel)
                    .addGap(18, 18, 18)
                    .addComponent(cFirstRadioButton)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(yFirstRadioButton)
                    .addContainerGap(58, Short.MAX_VALUE))
            );

        }
        
        return yOrderPanel;
    }

    private void setBayerOrderMessage(long setting){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_SET_SUB);
        byte[] args = {(byte)ThermalCamArguments.DIGITAL_BAYER_ENCODE_SET.getArg(), (byte)setting};
        msg.setArgs(args);
        gui.sendCommand(msg);
    }
    
    protected void getBayerOrderMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET_SUB);
        msg.setArgs(gui.longtoTwoBytes(ThermalCamArguments.DIGITAL_BAYER_ENCODE_GET.getArg()));
        gui.sendCommand(msg);
    }
    
    protected void setBayerOrder(long setting){
        if(setting == ThermalCamArguments.BAYER_ENCODE_BG.getArg()){
            bayerOrderBGFilterRadioButton.setSelected(true);
            this.bayerOrder = setting;
        } else if(setting == ThermalCamArguments.BAYER_ENCODE_GB.getArg()){
            bayerOrderGBFilterRadioButton.setSelected(true);
            this.bayerOrder = setting;
        } else if (setting == ThermalCamArguments.BAYER_ENCODE_GR.getArg()){
            bayerOrderGRFilterRadioButton.setSelected(true);
            this.bayerOrder = setting;
        } else if (setting == ThermalCamArguments.BAYER_ENCODE_RG.getArg()){
            bayerOrderRGFilterRadioButton.setSelected(true);
            this.bayerOrder = setting;
        }
    }
    
    protected long getBayerOrder(){
        return this.bayerOrder;
    }
    
    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if((rec.getFunction() == ThermalCamFunctionCodes.DIGITAL_OUTPUT_MODE_GET_SUB.getFunctionCode()) 
                &&(((int)sent.getArgs()[0] == (int)ThermalCamArguments.DIGITAL_BAYER_ENCODE_GET.getArg()))
                || ((int)sent.getArgs()[0] == (int)ThermalCamArguments.DIGITAL_BAYER_ENCODE_SET.getArg())){
                   setBayerOrder((int)gui.twoBytesToLong(rec.getArgs()));
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
