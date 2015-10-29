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

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.mozilla.javascript.edu.emory.mathcs.backport.java.util.Arrays;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;
import pt.lsts.neptus.util.ImageUtils;

/**
 * @author liz
 *
 */
class PanZoomPanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static final int PAN_MAX = 40;
    private static final int PAN_MIN = -40;
    private static final int PAN_TICK_SPACING = 5;
    private static final int PAN_FINE_MAX_ADD = 20;
    private static final int PAN_FINE_MIN_ADD = -20;
    private static final int PAN_FINE_TICK_SPACING = 1;
    private static final int ZOOM_MAX = 8;
    private static final int ZOOM_MIN = 1;
    
    private static ImageIcon LEFT_ARROW = new ImageIcon(ImageUtils.getImage(
            "images/buttons/move_west.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    private static ImageIcon RIGHT_ARROW = new ImageIcon(ImageUtils.getImage(
            "images/buttons/move_east.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    
    private ThermalCamControlGui gui;
    private int zoom = 0;
    private int maxZoom = 0;
    private int pan = 0;
    private int tilt = 0;

    private JLabel panZoomLabel = null;
    private JRadioButton unzoomRadioButton = null;
    private JRadioButton zoom2xRadioButton = null;
    private JRadioButton zoom4xRadioButton = null;
    private JRadioButton zoom8xRadioButton = null;
    private ButtonGroup zoomButtonGroup = null;
    private JTextField eZoomText = null;
    private JLabel eZoomValueLabel = null;
    private JButton incZoomButton = null;
    private JButton decZoomButton = null;
    
    private JPanel eZoomSliderPanel = null;
    private JLabel eightXLabel = null;
    private JLabel eZoomLabel = null;
    private JLabel oneXLabel = null;
    private JSlider eZoomSlider = null;
    
    private JPanel panSliderPanel = null;    
    private JSlider panSlider = null;
    private JSlider tiltSlider = null;    

    private JPanel panPanel = null;
    private JLabel panLabel = null;
    private JButton panCenterButton = null;
    private JCheckBox panFineCheckBox = null;
    private JTextField panText = null;
    private JTextField tiltText = null;
    private JLabel tiltLabel = null;
    private JLabel panMaxLabel = null;
    private JLabel panMinLabel = null;
    private JLabel tiltMaxLabel = null;
    private JLabel tiltMinLabel = null;
    
    /**
     * 
     */
    protected PanZoomPanel(ThermalCamControlGui gui) {
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        panZoomLabel = new JLabel();
        unzoomRadioButton = new JRadioButton();
        zoom2xRadioButton = new JRadioButton();
        zoom4xRadioButton = new JRadioButton();
        zoom8xRadioButton = new JRadioButton();
        zoomButtonGroup = new ButtonGroup();
        eZoomText = new JTextField();
        eZoomValueLabel = new JLabel();
        
        zoomButtonGroup.add(unzoomRadioButton);
        zoomButtonGroup.add(zoom2xRadioButton);
        zoomButtonGroup.add(zoom4xRadioButton);
        zoomButtonGroup.add(zoom8xRadioButton);

        this.setBorder(BorderFactory.createEtchedBorder());
        
        panZoomLabel.setText("Pan & Zoom");        
        
        unzoomRadioButton.setText("Unzoom"); 
        unzoomRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setZoomMessage(0);
                eZoomText.setText("0");
                eZoomSlider.setValue(0);
            }
        });
        zoom2xRadioButton.setText("Zoom 2x");
        zoom2xRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setZoomMessage(2);
                eZoomText.setText("2");
                eZoomSlider.setValue(2);
            }
        });
        zoom4xRadioButton.setText("Zoom 4x");
        zoom4xRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setZoomMessage(4);
                eZoomText.setText("4");
                eZoomSlider.setValue(4);
            }
        });
        zoom8xRadioButton.setText("Zoom 8x");
        zoom8xRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setZoomMessage(8);
                eZoomText.setText("8");
                eZoomSlider.setValue(8);
            }
        });
        
        eZoomValueLabel.setText("EZoom Value (1x - 8x)");
        eZoomText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                int value = ZOOM_MAX + 1;
                try {
                    value = Integer.parseInt(eZoomText.getText());
                } catch(NumberFormatException error){
                    eZoomText.setText(String.valueOf(eZoomSlider.getValue()));
                }
                if(gui.isWithinRange(ZOOM_MIN, ZOOM_MAX, value)){
                    setZoomMessage(value);
                    eZoomSlider.setValue(value);
                    setZoomRadioButtons(value);
                } else {
                    eZoomText.setText(String.valueOf(eZoomSlider.getValue()));
                }
            }
        });

        GroupLayout panZoomPanelLayout = new GroupLayout(this);
        this.setLayout(panZoomPanelLayout);
        panZoomPanelLayout.setHorizontalGroup(
            panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panZoomPanelLayout.createSequentialGroup()
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.LEADING, panZoomPanelLayout.createSequentialGroup()
                        .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panZoomPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panZoomLabel))
                            .addGroup(panZoomPanelLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(panZoomPanelLayout.createSequentialGroup()
                                        .addComponent(unzoomRadioButton)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(zoom4xRadioButton))
                                    .addGroup(panZoomPanelLayout.createSequentialGroup()
                                        .addComponent(zoom2xRadioButton)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(zoom8xRadioButton)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panZoomPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(getEZoomSliderPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.LEADING, panZoomPanelLayout.createSequentialGroup()
                                .addComponent(eZoomValueLabel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eZoomText))
                            .addComponent(getPanSliderPanel(), GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panZoomPanelLayout.setVerticalGroup(
            panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panZoomPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(panZoomLabel)
                .addGap(12, 12, 12)
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(unzoomRadioButton)
                    .addComponent(zoom4xRadioButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(zoom2xRadioButton)
                    .addComponent(zoom8xRadioButton))
                .addGap(18, 18, 18)
                .addComponent(getEZoomSliderPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panZoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(eZoomText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(eZoomValueLabel))
                .addGap(18, 18, 18)
                .addComponent(getPanSliderPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
    
    private JPanel getPanSliderPanel(){
        
        if(panSliderPanel == null){
            
            panSliderPanel = new JPanel();
            panSlider = new JSlider();
            tiltSlider = new JSlider(); 
            panMaxLabel = new JLabel();
            panMinLabel = new JLabel();
            tiltMaxLabel = new JLabel();
            tiltMinLabel = new JLabel();

            panSlider.setMajorTickSpacing(PAN_TICK_SPACING);
            panSlider.setMaximum(PAN_MAX);
            panSlider.setMinimum(PAN_MIN);
            panSlider.setValue(0);
            panSlider.addChangeListener(new ChangeListener(){
                public void stateChanged(ChangeEvent e) {
                    panText.setText(String.valueOf(panSlider.getValue()));
                    setPanTiltMessage(tiltSlider.getValue(), panSlider.getValue());
                }
            });
            
            tiltSlider.setMajorTickSpacing(PAN_TICK_SPACING);
            tiltSlider.setMaximum(PAN_MAX);
            tiltSlider.setMinimum(PAN_MIN);
            tiltSlider.setValue(0);
            tiltSlider.setOrientation(JSlider.VERTICAL);
            tiltSlider.addChangeListener(new ChangeListener(){
                public void stateChanged(ChangeEvent e) {
                    tiltText.setText(String.valueOf(tiltSlider.getValue()));
                    setPanTiltMessage(tiltSlider.getValue(), panSlider.getValue());
                }
            });
    
            GroupLayout panSliderPanelLayout = new GroupLayout(panSliderPanel);
            panSliderPanel.setLayout(panSliderPanelLayout);
            panSliderPanelLayout.setHorizontalGroup(
                panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panSliderPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panSliderPanelLayout.createSequentialGroup()
                            .addComponent(getPanPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(panSliderPanelLayout.createSequentialGroup()
                            .addComponent(panMinLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panMaxLabel)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tiltSlider, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(tiltMaxLabel)
                        .addComponent(tiltMinLabel))
                    .addGap(18, 18, 18))
            );
            panSliderPanelLayout.setVerticalGroup(
                panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panSliderPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(panSliderPanelLayout.createSequentialGroup()
                            .addComponent(getPanPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panSlider, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addComponent(tiltSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(panMinLabel)
                        .addComponent(panMaxLabel))
                    .addContainerGap(28, Short.MAX_VALUE))
                .addGroup(panSliderPanelLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(tiltMaxLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tiltMinLabel)
                    .addGap(60, 60, 60))
            );
        }
        return panSliderPanel;
    }
    
    private JPanel getEZoomSliderPanel(){
        
        if(eZoomSliderPanel == null){
            
            eZoomSliderPanel = new JPanel();
            eightXLabel = new JLabel();
            eZoomLabel = new JLabel();
            oneXLabel = new JLabel();
            eZoomSlider = new JSlider();
            incZoomButton = new JButton();
            decZoomButton = new JButton();

            eightXLabel.setText(String.valueOf(ZOOM_MAX) + "x");
            eZoomLabel.setText("EZoom");
            oneXLabel.setText(String.valueOf(ZOOM_MIN) + "x");
    
            eZoomSlider.setMajorTickSpacing(1);
            eZoomSlider.setMaximum(ZOOM_MAX);
            eZoomSlider.setMinimum(ZOOM_MIN);
            eZoomSlider.setSnapToTicks(true);
            eZoomSlider.setValue(1);
            eZoomSlider.addChangeListener(new ChangeListener(){
                public void stateChanged(ChangeEvent e) {
                    int newVal = eZoomSlider.getValue();
                    eZoomText.setText(String.valueOf(newVal));
                    setZoomMessage(newVal);
                    setZoomRadioButtons(newVal);
                }
            });
    
            decZoomButton.setIcon(LEFT_ARROW);
            decZoomButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    if(eZoomSlider.getValue() > ZOOM_MIN){
                        eZoomSlider.setValue(eZoomSlider.getValue() - 1);  
                    }
                }
            });
            incZoomButton.setIcon(RIGHT_ARROW);
            incZoomButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    if(eZoomSlider.getValue() < ZOOM_MAX){
                        int nextSliderVal = eZoomSlider.getValue() + 1;
                        eZoomSlider.setValue(nextSliderVal);
                        eZoomText.setText(String.valueOf(nextSliderVal));
                        setZoomRadioButtons(nextSliderVal);  
                    }
                }
            });
            
            GroupLayout eZoomSliderPanelLayout = new GroupLayout(eZoomSliderPanel);
            eZoomSliderPanel.setLayout(eZoomSliderPanelLayout);
            eZoomSliderPanelLayout.setHorizontalGroup(
                eZoomSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(eZoomSliderPanelLayout.createSequentialGroup()
                    .addComponent(decZoomButton)
                    .addGroup(eZoomSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(eZoomSliderPanelLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(oneXLabel)
                            .addGap(41, 41, 41)
                            .addComponent(eZoomLabel)
                            .addGap(45, 45, 45)
                            .addComponent(eightXLabel)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(eZoomSliderPanelLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(eZoomSlider, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(incZoomButton)))
                    .addContainerGap())
            );
            eZoomSliderPanelLayout.setVerticalGroup(
                eZoomSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(eZoomSliderPanelLayout.createSequentialGroup()
                    .addGroup(eZoomSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(eZoomSliderPanelLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(eZoomSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(decZoomButton)
                                .addComponent(incZoomButton))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, eZoomSliderPanelLayout.createSequentialGroup()
                            .addContainerGap(23, Short.MAX_VALUE)
                            .addComponent(eZoomSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addGroup(eZoomSliderPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(eZoomLabel)
                        .addComponent(eightXLabel)
                        .addComponent(oneXLabel)))
            );        
       
        }
        return eZoomSliderPanel;
    }
    
    private JPanel getPanPanel(){
        
        if(panPanel == null){
            
            panPanel = new JPanel();
            panLabel = new JLabel();
            panCenterButton = new JButton();
            panFineCheckBox = new JCheckBox();
            panText = new JTextField();
            tiltLabel = new JLabel();
            tiltText = new JTextField();

            panLabel.setText("Pan:");
            tiltLabel.setText("Tilt:");
    
            panCenterButton.setText("Center");
            panCenterButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    panSlider.setValue(0);
                    tiltSlider.setValue(0);
                    panText.setText(String.valueOf(0));
                    tiltText.setText(String.valueOf(0));
                    setPanTiltMessage(0,0);
                }
            });
            
            panText.setText("0");
            panText.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    int value = PAN_MAX + 1;
                    try {
                        value = Integer.parseInt(panText.getText());
                    } catch(NumberFormatException error){
                        panText.setText(String.valueOf(getPan()));
                    }
                    if(gui.isWithinRange(ZOOM_MIN, ZOOM_MAX, value)){
                        setPanTiltMessage(value, tiltSlider.getValue());
                        panSlider.setValue(value);
                    } else {
                        panText.setText(String.valueOf(getPan()));
                    }
                }
            });
            tiltText.setText("0");
            tiltText.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    int value = PAN_MAX + 1;
                    try {
                        value = Integer.parseInt(panText.getText());
                    } catch(NumberFormatException error){
                        panText.setText(String.valueOf(getPan()));
                    }
                    if(gui.isWithinRange(ZOOM_MIN, ZOOM_MAX, value)){
                        setPanTiltMessage(value, tiltSlider.getValue());
                        panSlider.setValue(value);
                    } else {
                        panText.setText(String.valueOf(getPan()));
                    }
                }
            });
    
            panFineCheckBox.setFont(new java.awt.Font(null, 0, 12)); // NOI18N
            panFineCheckBox.setText("Fine");
            panFineCheckBox.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    if(panFineCheckBox.isSelected()){
                        int pan = panSlider.getValue();
                        int tilt = tiltSlider.getValue();
                        panSlider.setMaximum(pan + PAN_FINE_MAX_ADD);
                        panSlider.setMinimum(pan + PAN_FINE_MIN_ADD);
                        panSlider.setMajorTickSpacing(PAN_FINE_TICK_SPACING);
                        tiltSlider.setMaximum(tilt + PAN_FINE_MAX_ADD);
                        tiltSlider.setMinimum(tilt + PAN_FINE_MIN_ADD);
                        tiltSlider.setMajorTickSpacing(PAN_FINE_TICK_SPACING);                        
                    } else {
                        panSlider.setMaximum(PAN_MAX);
                        panSlider.setMinimum(PAN_MIN);
                        panSlider.setMajorTickSpacing(PAN_TICK_SPACING);
                        tiltSlider.setMaximum(PAN_MAX);
                        tiltSlider.setMinimum(PAN_MIN);
                        tiltSlider.setMajorTickSpacing(PAN_TICK_SPACING);
                    }
                }
            });
        
            GroupLayout panPanelLayout = new GroupLayout(panPanel);
            panPanel.setLayout(panPanelLayout);
            panPanelLayout.setHorizontalGroup(
                panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panFineCheckBox, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panLabel, GroupLayout.Alignment.TRAILING)
                        .addComponent(tiltLabel, GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(panCenterButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panText, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, panPanelLayout.createSequentialGroup()
                            .addComponent(tiltText, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panPanelLayout.setVerticalGroup(
                panPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, panPanelLayout.createSequentialGroup()
                    .addContainerGap(24, Short.MAX_VALUE)
                    .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tiltLabel)
                        .addComponent(tiltText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(panLabel)
                        .addComponent(panText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(panPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(panCenterButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panFineCheckBox))
                    .addContainerGap())
            );
        }
        return panPanel;
    }
    
    protected int getPan(){
        return this.pan;
    }

    protected void setPan(int pan){
        if(gui.isWithinRange(PAN_MIN, PAN_MAX, pan)){
            this.pan = pan;
            panSlider.setValue(pan);
            panText.setText(String.valueOf(pan));
        }
    }
    
    protected int getTilt(){
        return this.tilt;
    }
    
    protected void setTilt(int tilt){
        if(gui.isWithinRange(PAN_MIN, PAN_MAX, tilt)){
            this.tilt = tilt;
            tiltSlider.setValue(tilt);
            tiltText.setText(String.valueOf(pan));
        }
    }
    
    protected int getZoom(){
        return this.zoom;
    }
    
    protected void setZoom(int zoom){
        if(gui.isWithinRange(ZOOM_MIN, ZOOM_MAX, zoom)){
            this.zoom = zoom;
            eZoomSlider.setValue(zoom);
            eZoomText.setText(String.valueOf(zoom));
            setZoomRadioButtons(zoom);
        }
    }
    
    protected int getMaxZoom(){
        return this.maxZoom;
    }
    
    protected void setMaxZoom(int zoom){
        this.maxZoom = zoom;
    }
    
    private void setZoomRadioButtons(int value){
        if(value == 0){
            unzoomRadioButton.setSelected(true);
        } else if (value == 2){
            zoom2xRadioButton.setSelected(true);
        } else if (value == 4){
            zoom4xRadioButton.setSelected(true);
        } else if (value == 8){
            zoom8xRadioButton.setSelected(true);
        } else {
            unzoomRadioButton.setSelected(false);
            zoom2xRadioButton.setSelected(false);
            zoom4xRadioButton.setSelected(false);
            zoom8xRadioButton.setSelected(false);
        }
    }
   
    private void getZoomMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.PAN_AND_TILT_GET);
        gui.sendCommand(msg);
    }
    
    private void setZoomMessage(int zoom){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.EZOOM_CONTROL_SET);
        msg.setArgs(gui.concatenate(
                gui.longtoTwoBytes(ThermalCamArguments.EZOOM_CONTROL_SET_SPECIFIED.getArg()), 
                gui.longtoTwoBytes(zoom)));
        gui.sendCommand(msg);
    }
    
    protected void getZoomMaxMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.EZOOM_CONTROL_GET_SPECIFIC);
        msg.setArgs(gui.concatenate(
                gui.longtoTwoBytes(ThermalCamArguments.EZOOM_CONTROL_GET_MAX.getArg()), 
                gui.longtoTwoBytes(0)));
        gui.sendCommand(msg);
    }
    
    protected void getPanZoomMessages(){
        getPanTiltMessage();
        getZoomMessage();
    }
    
    private void getPanTiltMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.PAN_AND_TILT_GET);
        gui.sendCommand(msg);
    }
    
    private void setPanTiltMessage(int pan, int tilt){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.PAN_AND_TILT_SET);
        msg.setArgs(gui.concatenate(gui.longtoTwoBytes((long)tilt), gui.longtoTwoBytes((long)pan)));
        gui.sendCommand(msg);
    }
    
    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.PAN_AND_TILT_GET.getFunctionCode()){
            setTilt((int)gui.twoBytesToLong(Arrays.copyOfRange(rec.getArgs(), 0, 2)));
            setPan((int)gui.twoBytesToLong(Arrays.copyOfRange(rec.getArgs(), 2, 4)));
        } else if (rec.getFunction() == ThermalCamFunctionCodes.EZOOM_CONTROL_SET.getFunctionCode()){
            if(sent.getByteCount() > 0){
                setMaxZoom((int)(ThermalCamArguments.FPA_WIDTH.getArg()/gui.twoBytesToLong(rec.getArgs())));
            } else {
                setZoom((int)(ThermalCamArguments.FPA_WIDTH.getArg()/gui.twoBytesToLong(rec.getArgs())));
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


