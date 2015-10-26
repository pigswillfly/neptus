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

/**
 * @author liz
 *
 */
enum ThermalCamStatus {
    
    CAM_OK(0x00, "Cam OK"),
    CAM_NOT_READY(0x02, "NOT READY"),
    CAM_RANGE_ERROR(0x03, "RANGE ERROR"),
    CAM_CHECKSUM_ERROR(0x04, "CHECKSUM ERROR"),
    CAM_UNDEFINED_PROCESS_ERROR(0x05, "UNDEFINED PROCESS ERROR"),
    CAM_UNDEFINED_FUNCTION_ERROR(0x06, "UNDEFINED FUNCTION ERROR"),
    CAM_TIMEOUT_ERROR(0x07, "TIMEOUT ERROR"),
    CAM_BYTE_COUNT_ERROR(0x09, "BYTE COUNT ERROR"),
    CAM_FEATURE_NOT_ENABLED(0x0A, "FEATURE NOT ENABLED");
    
    private int statusCode;
    private String description;
    
    ThermalCamStatus(int code, String desc){
        this.statusCode = code;
        this.description = desc;
    }
    
    public int getStatusCode(){
        return this.statusCode;
    }
    
    public String getStatusDescription(){
        return this.description;
    }

}
