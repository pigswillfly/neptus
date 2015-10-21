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
 * Oct 21, 2015
 */
package pt.lsts.neptus.console.actions;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import no.ntnu.thermalcamcontrol.gui.ThermalCamControlGui;
import pt.lsts.neptus.console.ConsoleLayout;
import pt.lsts.neptus.i18n.I18n;
import pt.lsts.neptus.util.GuiUtils;
import pt.lsts.neptus.util.ImageUtils;

/**
 * @author liz
 *
 */
@SuppressWarnings("serial")
public class OpenThermalCamControlGuiAction extends ConsoleAction {

    private ConsoleLayout console = null;
    private JFrame thermalCamControlFrame = null;
    
    public OpenThermalCamControlGuiAction(ConsoleLayout console) {
        super(I18n.text("FLIR Tau 2 Camera Control GUI"), ImageUtils.createScaleImageIcon("images/thermal_cam.png", 16, 16), I18n
                .text("FLIR Tau 2 Camera Control GUI"));
        this.console = console;
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (thermalCamControlFrame == null) {
            final ThermalCamControlGui thermalCamPanel = new ThermalCamControlGui(console);
            
            thermalCamControlFrame = new JFrame(I18n.text("FLIR Tau 2 Camera Control Gui"));
            thermalCamControlFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    thermalCamPanel.clean();
                    console.removeWindowToOppenedList(thermalCamControlFrame);
                    thermalCamControlFrame = null;
                    super.windowClosing(e);
                }
            });
            thermalCamControlFrame.setSize(875,750);
            thermalCamControlFrame.setLocation(500,100);
            thermalCamControlFrame.setResizable(true);
            thermalCamControlFrame.add(thermalCamPanel);
            thermalCamControlFrame.setTitle("FLIR Tau 2 Camera Control GUI");       
            thermalCamControlFrame.setMenuBar(thermalCamControlFrame.getMenuBar());
            GuiUtils.setLookAndFeel();
            thermalCamControlFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            console.addWindowToOppenedList(thermalCamControlFrame);
        }

        thermalCamControlFrame.setVisible(true);
        thermalCamControlFrame.requestFocus();
    }

}
