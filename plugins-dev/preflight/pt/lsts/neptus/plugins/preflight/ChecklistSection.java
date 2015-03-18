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
 * Author: tsmarques
 * 17 Mar 2015
 */
package pt.lsts.neptus.plugins.preflight;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pt.lsts.neptus.console.plugins.MainVehicleChangeListener;

/**
 * @author tsmarques
 *
 */
@SuppressWarnings("serial")
public abstract class ChecklistSection extends JPanel implements MainVehicleChangeListener {
    protected String mainVehicle;
    
    private JPanel sectionNamePanel;
    private JLabel sectionNameLabel;    
    protected JPanel checksPanel; /* Panel that contains the "values" and checks */
    protected final GridBagConstraints c = new GridBagConstraints();
    
    private boolean sectionIsMinimized;
    
    public ChecklistSection(String sectionName) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        
        sectionNamePanel = new JPanel();
        sectionNameLabel = new JLabel(sectionName);
        sectionNameLabel.setForeground(Color.WHITE);
        
        checksPanel = new JPanel();
        checksPanel.setLayout(new GridBagLayout());
        checksPanel.setBackground(Color.WHITE);
        sectionIsMinimized = false;
        
        buildNamePanel();
        
        /* TEST */
//        checksPanel.setBackground(Color.CYAN);
        
        add(Box.createVerticalStrut(2));
        add(sectionNamePanel);
        add(Box.createVerticalStrut(1));
        add(checksPanel);
    }
    
    /* Build the panel that will contain the actual checks for this section */
    protected abstract void buildChecksPanel();
    
    private void buildNamePanel() {
        Dimension d = new Dimension(430, 20);
        sectionNamePanel.setBackground(Color.DARK_GRAY);
        sectionNamePanel.setMaximumSize(d);
        sectionNamePanel.setMinimumSize(d);
        sectionNamePanel.setLayout(new GridBagLayout());
        
        sectionNamePanel.add(sectionNameLabel, new GridBagConstraints());
        sectionNamePanel.addMouseListener(new MouseListener() {        
            @Override
            public void mouseReleased(MouseEvent e) {
                if(sectionIsMinimized)
                    add(checksPanel);
                else
                    remove(checksPanel);
                
                sectionIsMinimized = !sectionIsMinimized;
                revalidate();
            }
            
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseClicked(MouseEvent e) {}
        });
    }
    /* Add elements to checksPanel */
    protected void addElementWithConstraints(Component comp, int gridx, int gridy, double weightx) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = weightx;
        c.gridx = gridx;
        c.gridy = gridy;
        
        checksPanel.add(comp, c);
    }
    
    protected boolean msgFromMainVehicle(String msgSrc) {
        return(msgSrc.equals(mainVehicle));
    }
    
    @Override
    public void mainVehicleChange(String id) {
        System.out.println("# MAIN VEHICLE CHANGE");
        mainVehicle = id;  
    }
}
