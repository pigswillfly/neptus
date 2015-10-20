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

//import java.awt.Image;

//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import pt.lsts.neptus.util.GuiUtils;
//import pt.lsts.neptus.util.ImageUtils;

/**
 * @author Elizabeth Roy
 *
 */
public class ThermalCamControlGui extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /*
    private static ImageIcon ICON = new ImageIcon(ImageUtils.getImage(
            "images/thermal_cam.ico").getScaledInstance(16, 16, Image.SCALE_SMOOTH));
    private static ImageIcon ICON_BIG = new ImageIcon(ImageUtils.getImage(
            "images/thermal_cam.ico").getScaledInstance(48, 48, Image.SCALE_SMOOTH));
    */
    /**
     * 
     */
    public static JFrame getFrame() {
        JFrame frame = GuiUtils.testFrame(getTabPanel());
        frame.setSize(835, 675);
        frame.setTitle("FLIR Tau 2 Camera Control GUI");
        GuiUtils.setLookAndFeel();

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        return frame;
    }

    private static JTabbedPane getTabPanel() {
        JTabbedPane tabPane = new JTabbedPane();
        tabPane.setVerifyInputWhenFocusTarget(false);
       // tabPane.add("Status", new StatusPanel());
        tabPane.addTab("Setup", new SetupPanel());
        JTabbedPane videoTab = new JTabbedPane();
        videoTab.addTab("Analog", new AnalogPanel());
        videoTab.addTab("Digital", new DigitalPanel());
        tabPane.addTab("Video", videoTab);
       // tabPane.addTab("AGC", new agcPanel());
       // tabPane.addTab("Thermal", new ThermalPanel());
        
        return tabPane;
    }

}
