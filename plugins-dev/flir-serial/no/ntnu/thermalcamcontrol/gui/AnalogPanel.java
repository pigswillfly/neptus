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
 * Oct 16, 2015
 */
package no.ntnu.thermalcamcontrol.gui;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

/**
 * @author liz
 *
 */
class AnalogPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private ThermalCamControlGui gui;
    
    private OrientationPanel orientationPanel = null;
    private AnalogVideoStandardPanel videoStandardPanel = null;
    private PolarityPanel polarityPanel = null;
    private AnalogFFCPanel analogFFCPanel = null;
    private AnalogVideoColorPanel analogVideoColorPanel = null;
    private AnalogVideoOnOffPanel analogVideoOnOffPanel = null;
    private PanZoomPanel panZoomPanel = null;

    protected AnalogPanel(ThermalCamControlGui gui) {
        super();
        this.gui = gui;
        initialize();
    }
                        
    private void initialize() {
    
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(getPanZoomPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(getAnalogVideoStandardPanel(), GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(getPolarityPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(getAnalogVideoOnOffPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(getAnalogVideoColorPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(getAnalogFFCPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(getOrientationPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(getOrientationPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(getPolarityPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getAnalogFFCPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(getAnalogVideoColorPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getAnalogVideoOnOffPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(getAnalogVideoStandardPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(getPanZoomPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }      

    protected OrientationPanel getOrientationPanel(){

        if(orientationPanel == null)
            orientationPanel = new OrientationPanel(this.gui);
        return orientationPanel;
    }
    
    protected PanZoomPanel getPanZoomPanel(){
        
        if(panZoomPanel == null)
            panZoomPanel = new PanZoomPanel(this.gui);
        return panZoomPanel;
    }
    
    protected PolarityPanel getPolarityPanel(){
        
        if(polarityPanel == null)         
            polarityPanel = new PolarityPanel(this.gui);
        return polarityPanel;
    }
    
    protected AnalogVideoOnOffPanel getAnalogVideoOnOffPanel(){

        if(analogVideoOnOffPanel == null)       
            analogVideoOnOffPanel = new AnalogVideoOnOffPanel(this.gui);
        return analogVideoOnOffPanel;
    }
    
    protected AnalogVideoStandardPanel getAnalogVideoStandardPanel(){
        
        if(videoStandardPanel == null)
            videoStandardPanel = new AnalogVideoStandardPanel(this.gui);
        return videoStandardPanel;
    }
    
    protected AnalogFFCPanel getAnalogFFCPanel(){

        if(analogFFCPanel == null)
            analogFFCPanel = new AnalogFFCPanel(this.gui);
        return analogFFCPanel;
    }
    
    protected AnalogVideoColorPanel getAnalogVideoColorPanel(){

        if(analogVideoColorPanel == null)
            analogVideoColorPanel = new AnalogVideoColorPanel(this.gui);
        return analogVideoColorPanel;
    }
       
}
