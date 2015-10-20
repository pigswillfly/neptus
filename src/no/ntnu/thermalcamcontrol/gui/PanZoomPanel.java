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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 * @author liz
 *
 */
class PanZoomPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private JPanel eZoomSliderPanel = null;
    private JPanel panSliderPanel = null;
    private JPanel panPanel = null;

    /**
     * 
     */
    protected PanZoomPanel() {
        super();
        initialize();
    }
    
    private void initialize(){
        JLabel panZoomLabel = new JLabel();
        JRadioButton unzoomRadioButton = new JRadioButton();
        JRadioButton zoom2xRadioButton = new JRadioButton();
        JRadioButton zoom4xRadioButton = new JRadioButton();
        JRadioButton zoom8xRadioButton = new JRadioButton();
        ButtonGroup zoomButtonGroup = new ButtonGroup();
        JTextField eZoomText = new JTextField();
        JLabel eZoomValueLabel = new JLabel();
        zoomButtonGroup.add(unzoomRadioButton);
        zoomButtonGroup.add(zoom2xRadioButton);
        zoomButtonGroup.add(zoom4xRadioButton);
        zoomButtonGroup.add(zoom8xRadioButton);

        this.setBorder(BorderFactory.createEtchedBorder());
        
        unzoomRadioButton.setText("Unzoom");      
        zoom2xRadioButton.setText("Zoom 2x");
        zoom4xRadioButton.setText("Zoom 4x");
        zoom8xRadioButton.setText("Zoom 8x");

        panZoomLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        panZoomLabel.setText("Pan & Zoom");
        
        GroupLayout panZoomPanelLayout = new GroupLayout(this);
        this.setLayout(panZoomPanelLayout);
        panZoomPanelLayout.setHorizontalGroup(
            panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panZoomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panZoomLabel)
                    .addComponent(getPanSliderPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panZoomPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panZoomPanelLayout.createSequentialGroup()
                                .addComponent(unzoomRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(zoom4xRadioButton))
                            .addGroup(panZoomPanelLayout.createSequentialGroup()
                                .addComponent(zoom2xRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(zoom8xRadioButton))
                            .addComponent(getEZoomSliderPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panZoomPanelLayout.createSequentialGroup()
                                .addComponent(eZoomValueLabel)
                                .addGap(18, 18, 18)
                                .addComponent(eZoomText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panZoomPanelLayout.setVerticalGroup(
            panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panZoomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panZoomLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(unzoomRadioButton)
                    .addComponent(zoom4xRadioButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(zoom2xRadioButton)
                    .addComponent(zoom8xRadioButton))
                .addGap(12, 12, 12)
                .addComponent(getEZoomSliderPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(eZoomText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(eZoomValueLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(getPanSliderPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        unzoomRadioButton.setSelected(true);

    }

    private JPanel getPanSliderPanel(){
        
        if(panSliderPanel == null){
            
            panSliderPanel = new JPanel();
            JSlider horizontalPanSlider = new JSlider();
            JSlider verticalPanSlider = new JSlider();        

            horizontalPanSlider.setMajorTickSpacing(5);
            horizontalPanSlider.setMaximum(40);
            horizontalPanSlider.setMinimum(-40);
            horizontalPanSlider.setMinorTickSpacing(1);
            horizontalPanSlider.setValue(0);
            
            verticalPanSlider.setMajorTickSpacing(5);
            verticalPanSlider.setMaximum(40);
            verticalPanSlider.setMinimum(-40);
            verticalPanSlider.setMinorTickSpacing(1);
            verticalPanSlider.setOrientation(JSlider.VERTICAL);
            verticalPanSlider.setValue(0);
    
            GroupLayout panSliderPanelLayout = new GroupLayout(panSliderPanel);
            panSliderPanel.setLayout(panSliderPanelLayout);
            panSliderPanelLayout.setHorizontalGroup(
                panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panSliderPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panSliderPanelLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(getPanPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(horizontalPanSlider, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(verticalPanSlider, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            panSliderPanelLayout.setVerticalGroup(
                panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panSliderPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(verticalPanSlider, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                        .addGroup(panSliderPanelLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(getPanPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(horizontalPanSlider, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
        }
        return panSliderPanel;
    }
    
    private JPanel getEZoomSliderPanel(){
        
        if(eZoomSliderPanel == null){
            
            eZoomSliderPanel = new JPanel();
            JLabel eightXLabel = new JLabel();
            JLabel eZoomLabel = new JLabel();
            JLabel oneXLabel = new JLabel();
            JSlider eZoomSlider = new JSlider();

            eightXLabel.setText("8x");
            eZoomLabel.setText("EZoom");
            oneXLabel.setText("1x");
    
            eZoomSlider.setMajorTickSpacing(1);
            eZoomSlider.setMaximum(8);
            eZoomSlider.setMinimum(1);
            eZoomSlider.setPaintLabels(true);
            eZoomSlider.setSnapToTicks(true);
            eZoomSlider.setValue(1);
    
            GroupLayout eZoomPanelLayout = new GroupLayout(eZoomSliderPanel);
            eZoomSliderPanel.setLayout(eZoomPanelLayout);
            eZoomPanelLayout.setHorizontalGroup(
                eZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(eZoomPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(eZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(eZoomPanelLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(oneXLabel)
                            .addGap(41, 41, 41)
                            .addComponent(eZoomLabel)
                            .addGap(45, 45, 45)
                            .addComponent(eightXLabel))
                        .addComponent(eZoomSlider, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );
            eZoomPanelLayout.setVerticalGroup(
                eZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(eZoomPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(eZoomSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(eZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(eZoomLabel)
                        .addComponent(eightXLabel)
                        .addComponent(oneXLabel))
                    .addContainerGap())
            );          
       
        }
        return eZoomSliderPanel;
    }
    
    private JPanel getPanPanel(){
        
        if(panPanel == null){
            
            panPanel = new JPanel();
            JLabel panLabel = new JLabel();
            JButton panCenterButton = new JButton();
            JCheckBox panFineCheckBox = new JCheckBox();
            JTextField panText = new JTextField();

            panLabel.setText("Pan:");
    
            panCenterButton.setText("Center");
    
            panFineCheckBox.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
            panFineCheckBox.setText("Fine");
    
            panText.setText("(0,0)");
    
            GroupLayout panPanelLayout = new GroupLayout(panPanel);
            panPanel.setLayout(panPanelLayout);
            panPanelLayout.setHorizontalGroup(
                panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panFineCheckBox, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                        .addGroup(GroupLayout.Alignment.TRAILING, panPanelLayout.createSequentialGroup()
                            .addComponent(panLabel)
                            .addGap(18, 18, 18)))
                    .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panCenterButton)
                        .addComponent(panText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );
            panPanelLayout.setVerticalGroup(
                panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(panLabel)
                        .addComponent(panText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32)
                    .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(panCenterButton)
                        .addComponent(panFineCheckBox))
                    .addContainerGap())
            );
        }
        return panPanel;
    }
}
