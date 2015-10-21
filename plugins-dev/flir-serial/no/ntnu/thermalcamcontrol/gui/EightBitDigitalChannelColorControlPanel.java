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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;

/**
 * @author liz
 *
 */
class EightBitDigitalChannelColorControlPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private JLabel eightBitDigitalChannelColorControlLabel = null;
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
    
    protected EightBitDigitalChannelColorControlPanel(){
        super();
        initialize();
    }
    
    private void initialize(){
        eightBitDigitalChannelColorControlLabel = new JLabel();
        colorizationEnableCheckBox = new JCheckBox();
        
        this.setBorder(BorderFactory.createEtchedBorder());

        eightBitDigitalChannelColorControlLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        eightBitDigitalChannelColorControlLabel.setText("8-bit Digital Channel Colorization Controls");
        colorizationEnableCheckBox.setText("Colorization Enable");

        GroupLayout eightBitDigitalChannelColorControlPanelLayout = new GroupLayout(this);
        this.setLayout(eightBitDigitalChannelColorControlPanelLayout);
        eightBitDigitalChannelColorControlPanelLayout.setHorizontalGroup(
            eightBitDigitalChannelColorControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitDigitalChannelColorControlPanelLayout.createSequentialGroup()
                .addGroup(eightBitDigitalChannelColorControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(eightBitDigitalChannelColorControlPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(eightBitDigitalChannelColorControlLabel))
                    .addGroup(eightBitDigitalChannelColorControlPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(eightBitDigitalChannelColorControlPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(getYSubSamplingPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getYOrderPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getBayerOrderPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(GroupLayout.Alignment.LEADING, eightBitDigitalChannelColorControlPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(colorizationEnableCheckBox)))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        eightBitDigitalChannelColorControlPanelLayout.setVerticalGroup(
            eightBitDigitalChannelColorControlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(eightBitDigitalChannelColorControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eightBitDigitalChannelColorControlLabel)
                .addGap(18, 18, 18)
                .addComponent(getBayerOrderPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(getYSubSamplingPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(getYOrderPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(colorizationEnableCheckBox)
                .addGap(21, 21, 21))
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
    
            bayerOrderGBFilterRadioButton.setText("GB Filter");
    
            bayerOrderGRFilterRadioButton.setText("GR Filter");
    
            bayerOrderRGFilterRadioButton.setText("RG Filter");
    
            bayerOrderLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
            bayerOrderLabel.setText("Bayer Order");
    
            bayerOrderBGFilterRadioButton.setText("BG Filter");
    
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
                            .addGap(32, 32, 32)
                            .addGroup(bayerOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(bayerOrderBGFilterRadioButton)
                                .addComponent(bayerOrderRGFilterRadioButton))))
                    .addContainerGap())
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
                    .addContainerGap())
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
    
            ySubSamplingPositedRadioButton.setText("422 Posited");
    
            GroupLayout ySubSamplingPanelLayout = new GroupLayout(ySubSamplingPanel);
            ySubSamplingPanel.setLayout(ySubSamplingPanelLayout);
            ySubSamplingPanelLayout.setHorizontalGroup(
                ySubSamplingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(ySubSamplingPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(ySubSamplingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(ySubSamplingLabel)
                        .addGroup(ySubSamplingPanelLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(ySubSamplingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(ySubSamplingPositedRadioButton)
                                .addComponent(ySubSamplingCenterRadioButton))))
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
                    .addContainerGap(18, Short.MAX_VALUE))
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
            yFirstRadioButton.setText("YCbYCr");
    
            GroupLayout yOrderPanelLayout = new GroupLayout(yOrderPanel);
            yOrderPanel.setLayout(yOrderPanelLayout);
            yOrderPanelLayout.setHorizontalGroup(
                yOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(yOrderPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(yOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(yOrderLabel)
                        .addGroup(yOrderPanelLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(yOrderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(yFirstRadioButton)
                                .addComponent(cFirstRadioButton))))
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
                    .addContainerGap(26, Short.MAX_VALUE))
            );

        }
        
        return yOrderPanel;
    }
     
}
