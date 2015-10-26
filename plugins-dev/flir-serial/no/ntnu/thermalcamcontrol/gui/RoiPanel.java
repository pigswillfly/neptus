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

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
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
    
    private JTextField bottomText;
    private JLabel cartesianLabel;
    private JLabel coordinateLabel;
    private JLabel coordinateLeftTopLabel;
    private JPanel coordinatePanel;
    private JLabel coordinateRightBottomLabel;
    private JButton coordinateSetButton;
    private JPanel gridPanel;
    private JPanel horizontalResizeFillerPanel;
    private JSplitPane horizontalResizeSplitPane;
    private JLabel imageSizeLabel;
    private JPanel imageSizePanel;
    private JTextField leftText;
    private JButton restoreDefaultImageButton;
    private JTextField rightText;
    private JPanel snapshotPanel;
    private JButton takeASnapshotButton;
    private JTextField topText;
    private JPanel verticalResizeFillerPanel;
    private JSplitPane verticalResizeSplitPane;
    private JButton viewLastSnapshotButton;
    
    protected RoiPanel(){
        super();
        initialize();
    }
    

    private void initialize(){
        
        coordinatePanel = new JPanel();
        coordinateLabel = new JLabel();
        leftText = new JTextField();
        topText = new JTextField();
        rightText = new JTextField();
        bottomText = new JTextField();
        coordinateLeftTopLabel = new JLabel();
        coordinateRightBottomLabel = new JLabel();
        cartesianLabel = new JLabel();
        coordinateSetButton = new JButton();
        gridPanel = new JPanel();
        horizontalResizeSplitPane = new JSplitPane();
        horizontalResizeFillerPanel = new JPanel();
        verticalResizeSplitPane = new JSplitPane();
        verticalResizeFillerPanel = new JPanel();
        imageSizePanel = new JPanel();
        imageSizeLabel = new JLabel();
        snapshotPanel = new JPanel();
        viewLastSnapshotButton = new JButton();
        takeASnapshotButton = new JButton();
        restoreDefaultImageButton = new JButton();
    
        setPreferredSize(new java.awt.Dimension(868, 700));
    
        coordinatePanel.setBorder(BorderFactory.createEtchedBorder());
    
        coordinateLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        coordinateLabel.setText("AGC ROI Coordinate Values");
    
        coordinateLeftTopLabel.setText("(left, top)");
    
        coordinateRightBottomLabel.setText("(right, bottom)");
    
        cartesianLabel.setText("Cartesian Coordinates");
    
        coordinateSetButton.setText("Set");
    
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
                        .addComponent(rightText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bottomText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(coordinatePanelLayout.createSequentialGroup()
                        .addComponent(leftText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(topText, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
                .addGap(132, 132, 132))
        );
    
        coordinatePanelLayout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {bottomText, leftText, rightText, topText});
    
        coordinatePanelLayout.setVerticalGroup(
            coordinatePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(coordinatePanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(coordinateLabel)
                .addGap(9, 9, 9)
                .addGroup(coordinatePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(leftText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(topText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordinateLeftTopLabel))
                .addGap(16, 16, 16)
                .addGroup(coordinatePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rightText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottomText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordinateRightBottomLabel)
                    .addComponent(coordinateSetButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartesianLabel)
                .addContainerGap())
        );
    
        gridPanel.setBorder(BorderFactory.createEtchedBorder());
    
        horizontalResizeFillerPanel.setPreferredSize(new java.awt.Dimension(0, 469));
    
        GroupLayout horizontalResizeFillerPanelLayout = new GroupLayout(horizontalResizeFillerPanel);
        horizontalResizeFillerPanel.setLayout(horizontalResizeFillerPanelLayout);
        horizontalResizeFillerPanelLayout.setHorizontalGroup(
            horizontalResizeFillerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        horizontalResizeFillerPanelLayout.setVerticalGroup(
            horizontalResizeFillerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );
    
        horizontalResizeSplitPane.setLeftComponent(horizontalResizeFillerPanel);
    
        verticalResizeSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        verticalResizeSplitPane.setToolTipText("");
    
        GroupLayout verticalResizeFillerPanelLayout = new GroupLayout(verticalResizeFillerPanel);
        verticalResizeFillerPanel.setLayout(verticalResizeFillerPanelLayout);
        verticalResizeFillerPanelLayout.setHorizontalGroup(
            verticalResizeFillerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        verticalResizeFillerPanelLayout.setVerticalGroup(
            verticalResizeFillerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    
        verticalResizeSplitPane.setLeftComponent(verticalResizeFillerPanel);
    
        imageSizePanel.setBackground(new java.awt.Color(122, 239, 119));
        imageSizePanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imageSizePanel.setPreferredSize(new java.awt.Dimension(576, 460));
        imageSizePanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                imageSizePanelComponentResized(evt);
            }
        });
        imageSizePanel.setLayout(new java.awt.BorderLayout());
    
        imageSizeLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        imageSizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageSizeLabel.setText(imageSizePanel.getHeight() + "x" + imageSizePanel.getWidth());
        imageSizePanel.add(imageSizeLabel, java.awt.BorderLayout.CENTER);
    
        verticalResizeSplitPane.setRightComponent(imageSizePanel);
    
        horizontalResizeSplitPane.setRightComponent(verticalResizeSplitPane);
        
        gridPanel.setSize(gridPanel.getPreferredSize());
    
        GroupLayout gridPanelLayout = new GroupLayout(gridPanel);
        gridPanel.setLayout(gridPanelLayout);
        gridPanelLayout.setHorizontalGroup(
            gridPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(gridPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(horizontalResizeSplitPane)
                .addContainerGap())
        );
        gridPanelLayout.setVerticalGroup(
            gridPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(gridPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(horizontalResizeSplitPane)
                .addContainerGap())
        );
    
        snapshotPanel.setBorder(null);
    
        viewLastSnapshotButton.setText("View last snapshot");
    
        takeASnapshotButton.setText("Take a snapshot");
    
        restoreDefaultImageButton.setText("Restore default image");
    
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
    
    private void imageSizePanelComponentResized(java.awt.event.ComponentEvent evt) {                                                
        imageSizeLabel.setText(String.valueOf(imageSizePanel.getWidth()) + "x" + String.valueOf(imageSizePanel.getHeight())); 
    }                                               

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeIfNoReply(pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeIfNoReply(ThermalCamControl sent) {
        // TODO Auto-generated method stub
        
    }

}
