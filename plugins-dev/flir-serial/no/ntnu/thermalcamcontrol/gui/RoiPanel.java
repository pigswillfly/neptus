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
 * Oct 26, 2015
 */
package no.ntnu.thermalcamcontrol.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

/**
 * @author liz
 *
 */
class RoiPanel extends JPanel implements ReplyAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static final long TOP_MAX = 256;
    private static final long BOTTOM_MIN = -256;
    private static final long RIGHT_MAX = 320;
    private static final long LEFT_MIN = -320;
    private static final long[] RIGHT_BOTTOM_DEFAULT = {288, -230};
    private static final long[] LEFT_TOP_DEFAULT = {-288, 230};
    
    private ThermalCamControlGui gui;
    
    // Coordinates known by camera
    private long[] rightBottomCoord = RIGHT_BOTTOM_DEFAULT;
    private long[] leftTopCoord = LEFT_TOP_DEFAULT;
    
    // Variables where text field values are stored before transmission
    private long currentTop = leftTopCoord[1];
    private long currentLeft = leftTopCoord[0];
    private long currentBottom = rightBottomCoord[1];
    private long currentRight = rightBottomCoord[0];
    
    private JTextField bottomTextField;
    private JTextField topTextField;
    private JTextField leftTextField;
    private JTextField rightTextField;
    private JLabel cartesianLabel;
    private JLabel coordinateLabel;
    private JLabel coordinateLeftTopLabel;
    private JPanel coordinatePanel;
    private JLabel coordinateRightBottomLabel;
    private JButton coordinateSetButton;
    
    private JPanel gridPanel;
    
    private JPanel snapshotPanel;
    private JButton restoreDefaultImageButton;
    private JButton takeASnapshotButton;
    private JButton viewLastSnapshotButton;
    
    protected RoiPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){

        initCoordPanel();
        initGridPanel();
        initSnapshotPanel();
        
        setPreferredSize(new java.awt.Dimension(868, 700));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(coordinatePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(snapshotPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gridPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(gridPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(snapshotPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(coordinatePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }                                          
    
    private void initCoordPanel(){
        coordinatePanel = new JPanel();
        coordinateLabel = new JLabel();
        leftTextField = new JTextField();
        topTextField = new JTextField();
        rightTextField = new JTextField();
        bottomTextField = new JTextField();
        coordinateLeftTopLabel = new JLabel();
        coordinateRightBottomLabel = new JLabel();
        cartesianLabel = new JLabel();
        coordinateSetButton = new JButton();
        
        coordinatePanel.setBorder(BorderFactory.createEtchedBorder());
        
        coordinateLabel.setText("AGC ROI Coordinate Values");    
        coordinateLeftTopLabel.setText("(left, top)");
        coordinateRightBottomLabel.setText("(right, bottom)");
        cartesianLabel.setText("Cartesian Coordinates");
    
        leftTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                long value = LEFT_MIN - 1;
                try {
                    value = Long.parseLong(leftTextField.getText());
                } catch(NumberFormatException error){
                    leftTextField.setText(String.valueOf(currentLeft));
                }
                if(gui.isWithinRange(LEFT_MIN, 0, value)){
                    currentLeft = value;
                    imagePanelResize();
                } else {
                    leftTextField.setText(String.valueOf(currentLeft));
                }
            }
        });
        
        topTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                long value = TOP_MAX + 1;
                try {
                    value = Long.parseLong(topTextField.getText());
                } catch(NumberFormatException error){
                    topTextField.setText(String.valueOf(currentTop));
                }
                if(gui.isWithinRange(0, TOP_MAX, value)){
                    currentTop = value;
                    imagePanelResize();
                } else {
                    topTextField.setText(String.valueOf(currentTop));
                }
            }
        });
        
        rightTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                long value = RIGHT_MAX + 1;
                try {
                    value = Long.parseLong(rightTextField.getText());
                } catch(NumberFormatException error){
                    rightTextField.setText(String.valueOf(currentRight));
                }
                if(gui.isWithinRange(0, RIGHT_MAX, value)){
                    currentRight = value;
                    imagePanelResize();
                } else {
                    rightTextField.setText(String.valueOf(currentRight));
                }
            }
        });
        
        bottomTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                long value = BOTTOM_MIN - 1;
                try {
                    value = Long.parseLong(bottomTextField.getText());
                } catch(NumberFormatException error){
                    bottomTextField.setText(String.valueOf(currentBottom));
                }
                if(gui.isWithinRange(BOTTOM_MIN, 0, value)){
                    currentBottom = value;
                    imagePanelResize();
                } else {
                    bottomTextField.setText(String.valueOf(currentBottom));
                }
            }
        });



        
        coordinateSetButton.setText("Set");
        coordinateSetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setRoiCoordinatesMessage();
            }
        });
    
        GroupLayout coordinatePanelLayout = new GroupLayout(coordinatePanel);
        coordinatePanel.setLayout(coordinatePanelLayout);
        coordinatePanelLayout.setHorizontalGroup(
            coordinatePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, coordinatePanelLayout.createSequentialGroup()
                .addGroup(coordinatePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(coordinatePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(coordinateLeftTopLabel))
                    .addGroup(coordinatePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(coordinatePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(coordinateLabel)
                            .addComponent(coordinateSetButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(coordinateRightBottomLabel)))
                .addGap(18, 18, 18)
                .addGroup(coordinatePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(cartesianLabel)
                    .addGroup(coordinatePanelLayout.createSequentialGroup()
                        .addComponent(rightTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bottomTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(coordinatePanelLayout.createSequentialGroup()
                        .addComponent(leftTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(topTextField, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
                .addGap(132, 132, 132))
        );
    
        coordinatePanelLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {bottomTextField, leftTextField, rightTextField, topTextField});
    
        coordinatePanelLayout.setVerticalGroup(
            coordinatePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(coordinatePanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(coordinateLabel)
                .addGap(9, 9, 9)
                .addGroup(coordinatePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(leftTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(topTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordinateLeftTopLabel))
                .addGap(9, 9, 9)
                .addGroup(coordinatePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rightTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottomTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordinateRightBottomLabel)
                    .addComponent(coordinateSetButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartesianLabel)
                .addContainerGap())
        );
    }
        
    private void initGridPanel(){
        gridPanel = new JPanel();
        gridPanel.setBorder(BorderFactory.createEtchedBorder());
        gridPanel.setSize(640,512);

    }
    
    private void initSnapshotPanel(){
        snapshotPanel = new JPanel();
        viewLastSnapshotButton = new JButton();
        takeASnapshotButton = new JButton();
        restoreDefaultImageButton = new JButton();
        
        snapshotPanel.setBorder(null);
        
        viewLastSnapshotButton.setText("View last snapshot");
        // Action listener
        
        takeASnapshotButton.setText("Take a snapshot");
        takeASnapshotButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                takeASnapShotMessage();
            }
        });
        
        restoreDefaultImageButton.setText("Restore default image");
        restoreDefaultImageButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                restoreDefaultImage();
            }
        });
        
        GroupLayout snapshotPanelLayout = new GroupLayout(snapshotPanel);
        snapshotPanel.setLayout(snapshotPanelLayout);
        snapshotPanelLayout.setHorizontalGroup(
            snapshotPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(snapshotPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(snapshotPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(restoreDefaultImageButton)
                    .addComponent(takeASnapshotButton)
                    .addComponent(viewLastSnapshotButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    
        snapshotPanelLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {restoreDefaultImageButton, takeASnapshotButton, viewLastSnapshotButton});
    
        snapshotPanelLayout.setVerticalGroup(
            snapshotPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(snapshotPanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(viewLastSnapshotButton)
                .addGap(18, 18, 18)
                .addComponent(takeASnapshotButton)
                .addGap(18, 18, 18)
                .addComponent(restoreDefaultImageButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void takeASnapShotMessage(){
        //ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.TRANSFER_FRAME);
        //
    }
    
    protected void getRoiCoordinatesMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.AGC_ROI_GET);
        gui.sendCommand(msg);
    }
    
    private void setRoiCoordinatesMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.AGC_ROI_SET);
        byte[] leftTop = gui.concatenate(gui.longtoTwoBytes(currentLeft), gui.longtoTwoBytes(currentTop));
        byte[] rightBottom = gui.concatenate(gui.longtoTwoBytes(currentRight), gui.longtoTwoBytes(currentBottom));
        msg.setArgs(gui.concatenate(leftTop, rightBottom));
        gui.sendCommand(msg);
    }
    
    private void restoreDefaultImage(){
        setCoordinates(true, 0, 0, 0, 0);
    }
    
    private void imagePanelResize(){
        // Need a panel to resize first
    }
    
    protected void setCoordinates(boolean defaults, long left, long top, long right, long bottom){
        if(defaults){
            leftTopCoord = LEFT_TOP_DEFAULT;
            rightBottomCoord = RIGHT_BOTTOM_DEFAULT;
        } else {        
            leftTopCoord[0] = left;
            leftTopCoord[1] = top;
            rightBottomCoord[0] = right;
            rightBottomCoord[1] = bottom;
        }
        currentLeft = leftTopCoord[0];
        currentTop = leftTopCoord[1];
        currentRight = rightBottomCoord[0];
        currentBottom = rightBottomCoord[1];
        leftTextField.setText(String.valueOf(currentLeft));
        topTextField.setText(String.valueOf(currentTop));
        rightTextField.setText(String.valueOf(currentRight));
        bottomTextField.setText(String.valueOf(currentBottom));
        imagePanelResize();
    }
    
    // returns array in the format {left, top, right, bottom}
    protected long[] getCoordinates(){
        long[] coordArray = {0,0,0,0};
        System.arraycopy(leftTopCoord, 0, coordArray, 0, 2);
        System.arraycopy(rightBottomCoord, 0, coordArray, 2, 2);
        return coordArray;
    }
    
    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(rec.getFunction() == ThermalCamFunctionCodes.AGC_ROI_GET.getFunctionCode()){
            byte[] args = new byte[8];
            if(sent.getByteCount() > 0){
                // for set
                args = sent.getArgs();
            } else {
                // for get
                args = rec.getArgs();
            }
            setCoordinates(false, 
                    gui.twoBytesToLong(Arrays.copyOfRange(args, 0, 2)),
                    gui.twoBytesToLong(Arrays.copyOfRange(args, 2, 4)),
                    gui.twoBytesToLong(Arrays.copyOfRange(args, 4, 6)),
                    gui.twoBytesToLong(Arrays.copyOfRange(args, 6, 8)));
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
