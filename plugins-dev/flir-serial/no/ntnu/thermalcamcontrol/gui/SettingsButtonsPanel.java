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

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;
import pt.lsts.imc.ThermalCamControl;

/**
 * @author liz
 *
 */
class SettingsButtonsPanel extends JPanel implements ReplyAction{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ThermalCamControlGui gui = null;

    private JButton factoryDefaultsButton = null;
    private JButton resetCameraButton = null;
    private JButton saveSettingsButton = null;
    
    protected SettingsButtonsPanel(ThermalCamControlGui gui){
        super();
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        factoryDefaultsButton = new JButton();
        resetCameraButton = new JButton();
        saveSettingsButton = new JButton();

        factoryDefaultsButton.setText("Factory Defaults");
        factoryDefaultsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                sendFactoryDefaultsMessage();
            }
        });
        
        resetCameraButton.setText("Reset Camera");
        factoryDefaultsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                sendResetMessage();
            }
        });
        
        saveSettingsButton.setText("Save Settings");
        factoryDefaultsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                sendSaveSettingsMessage();
            }
        });

        GroupLayout settingsButtonsPanelLayout = new GroupLayout(this);
        this.setLayout(settingsButtonsPanelLayout);
        settingsButtonsPanelLayout.setHorizontalGroup(
            settingsButtonsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, settingsButtonsPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveSettingsButton)
                .addGap(84, 84, 84)
                .addComponent(factoryDefaultsButton)
                .addGap(80, 80, 80)
                .addComponent(resetCameraButton)
                .addGap(71, 71, 71))
        );
        settingsButtonsPanelLayout.setVerticalGroup(
            settingsButtonsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(settingsButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingsButtonsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(saveSettingsButton)
                    .addGroup(settingsButtonsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(factoryDefaultsButton)
                        .addComponent(resetCameraButton)))
                .addContainerGap())
        );
    }
    
    protected void sendFactoryDefaultsMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.RESTORE_FACTORY_DEFAULTS);
        gui.sendCommand(msg);
    }
    
    protected void sendResetMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.CAMERA_RESET);
        gui.sendCommand(msg);
    }
    
    protected void sendSaveSettingsMessage(){
        ThermalCamControl msg = ThermalCamFunctionCodes.encode(ThermalCamFunctionCodes.SET_DEFAULTS);
        gui.sendCommand(msg);
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeOnReply(pt.lsts.imc.ThermalCamControl, pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeOnReply(ThermalCamControl sent, ThermalCamControl rec) {
        if(sent.getFunction() == ThermalCamFunctionCodes.RESTORE_FACTORY_DEFAULTS.getFunctionCode()){
            gui.getFactorySettings().reflectSettings();
        } else if (sent.getFunction() == ThermalCamFunctionCodes.CAMERA_RESET.getFunctionCode()){
            gui.getSavedSettings().reflectSettings();
        } else if (sent.getFunction() == ThermalCamFunctionCodes.SET_DEFAULTS.getFunctionCode()){
            gui.getSavedSettings().saveSettings();            
        }
    }

    /* (non-Javadoc)
     * @see no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction#executeIfNoReply(pt.lsts.imc.ThermalCamControl)
     */
    @Override
    public void executeIfNoReply(ThermalCamControl sent) {
        if(sent.getFunction() == ThermalCamFunctionCodes.RESTORE_FACTORY_DEFAULTS.getFunctionCode()){
            sendFactoryDefaultsMessage();
        } else if (sent.getFunction() == ThermalCamFunctionCodes.CAMERA_RESET.getFunctionCode()){
            sendResetMessage();
        } else if (sent.getFunction() == ThermalCamFunctionCodes.SET_DEFAULTS.getFunctionCode()){
            sendSaveSettingsMessage();
        }
    }
}
