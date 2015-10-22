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
 * Oct 22, 2015
 */
package no.ntnu.thermalcamcontrol.gui;

/**
 * @author liz
 *
 */
enum ThermalCamFunctionCodes {
    NO_OP(0x00, 0, 0, "No operation"),
    SET_DEFAULTS(0x01, 0, 0, "Set defaults non-blocking"),
    CAMERA_RESET(0x02, 0, 0, "Reset / reboot"),
    RESTORE_FACTORY_DEFAULTS(0x03, 0, 0, "Revert to factory defaults"),
    SERIAL_NUMBER(0x04, 0, 8, "Serial number request. "
            + "Reply bytes 0-3 camera, 4-7 sensor serial#"),
    GET_REVISION(0x05, 0, 8, "Get software / firmware revision. "
            + "Reply 2 bytes ea: sw maj/min, fw maj/min"),
    BAUD_RATE_GET(0x07, 0, 2, "Get current baud rate"),
    BAUD_RATE_SET(0x07, 2, 2, "Set baud rate"),
    GAIN_MODE_GET(0x0A, 0, 2, "Get gain mode"),
    FFC_MODE_SELECT_GET(0x0B, 0, 2, "Get FFC Mode"),
    FFC_MODE_SELECT_SET(0x0B, 2, 2, "Set FFC Mode"),
    FFC_INTEG_FRAMES_GET(0x0B, 4, 2, "Get number of integrated frames during FFC"),
    FFC_INTEG_FRAMES_SET(0x0B, 4, 0, "Set number of integrated frames during FFC"),
    DO_FFC_AUTO(0x0C, 0, 0, "Auto FFC"),
    DO_FFC_SPECIFIED(0x0C, 2, 2, "FFC Long or short"),
    FFC_PERIOD_GET(0x0D, 0, 4, "Get interval between FFC frames for both gain states"),
    FFC_PERIOD_SET(0x0D, 2, 2, "Set interval between FFC frames for current gain state"),
    FFC_PERIOD_SPECIFY(0x0D, 4, 4, "Set interval between FFC frames for speific gain states. "
            + "Bytes 0-1 for high gain, 2-3 for low gain"),
    FFC_TEMP_DELTA_GET(0x0E, 0, 4, "Get temp diff used to trigger auto FFC. Reply bytes "
            + "0-1 for high gain, 2-3 for low gain"),
    FFC_TEMP_DELTA_SET(0x0E, 2, 2, "Set temp delta value for current gain state"),
    FFC_TEMP_DELTA_SPECIFY(0x0E, 4, 4, "Set temp delta value for specific gain states. "
            + "Bytes 0-1 for high gain, 2-3 for low gain"),
    VIDEO_MODE_GET(0x0F, 0, 2, "Get current video signal mode"),
    VIDEO_MODE_SET(0x0F, 2, 2, "Set analog video mode"),
    VIDEO_SYMBOLOGY_OVERLAY_GET(0x0F, 4, 2, "Get symbology overlay state, different "
            + "arguments for analog/digital"),
    VIDEO_SYMBOLOGY_OVERLAY_SET(0x0F, 4, 4, "Set symbology overlay state, different "
            + "arguments for analog/digital"),
    VIDEO_PALETTE_GET(0x10, 0, 2, "Get video palette"),
    VIDEO_PALETTE_SET(0x10, 2, 2, "Set video palette"),
    VIDEO_ORIENTATION_GET(0x11, 0, 2, "Get video orientation"),
    VIDEO_ORIENTATION_SET(0x11, 2, 2, "Set video orientation"),
    DIGITAL_OUTPUT_MODE_GET(0x12, 0, 2, "Get digital output mode"),
    DIGITAL_OUTPUT_MODE_GET_SUB(0x12, 2, 2, "Get digital output mode (various sub functions)"),
    DIGITAL_OUTPUT_MODE_SET(0x12, 2, 2, "Enable/disable digital output (both LVDS and XP channels)"),
    AGC_TYPE_GET(0x13, 0, 2, "Get AGC algorithm"),
    AGC_TYPE_SET(0x13, 2, 2, "Set AGC algorithm"),
    AGC_SUB_GET(0x13, 2, 2, "AGC sub functions"),
    AGC_SUB_SET(0x13, 4, 0, "AGC sub functions"),
    CONTRAST_GET(0x14, 0, 2, "Get contrast value used by once-bright, auto-bright and manual"
            + "AGC algorithms"),
    CONTRAST_SET(0x14, 2, 2, "Set contrast value used by once-bright, auto-bright and manual"
            + "AGC algorithms"),
    BRIGHTNESS_GET(0x15, 0, 2, "Get brightness value used by manual and auto-bright AGC"),
    BRIGHTNESS_SET(0x15, 2, 2, "Set brightness value used by manual and auto-bright AGC"),
    BRIGHTNESS_BIAS_GET(0x18, 0, 2, "Get brightness bias value used by once-bright AGC"),
    BRIGHTNESS_BIAS_SET(0x18, 2, 2, "Set brightness bias value used by once-bright AGC"),
    TAIL_SIZE_GET(0x1B, 0, 2, "Get the tail rejection percentage for AGC"),
    TAIL_SIZE_SET(0x1B, 2, 2, "Set the tail rejection percentage for AGC"),
    ACE_CORRECT_GET(0x1C, 0, 2, "Get the Active Contrast Enhancement Correction for AGC"),
    ACE_CORRECT_SET(0x1C, 2, 2, "Set the Active Contrast Enhancement Correction for AGC"),
    LENS_NUMBER(0x1E, 0, 0, ""),
    SPOT_METER_MODE_GET(0x1F, 0, 2, "Get the spot-meter mode"),
    SPOT_METER_MODE_SET(0x1F, 2, 2, "Set the spot-meter mode"),
    READ_SENSOR(0x20, 0, 0, "Get various data from the core, depending on "
            + "argument of incoming message"),
    EXTERNAL_SYNC_GET(0x21, 0, 2, "Get external sync mode"),
    EXTERNAL_SYNC_SET(0x21, 2, 2, "Set external sync mode"),
    ISOTHERM_GET(0x22, 0, 2, "Get isotherm mode on/off"),
    ISOTHERM_SET(0x22, 2, 2, "Set isotherm mode on/off"),
    ISOTHERM_THRESHOLD_GET(0x23, 0, 6, "Get isotherm thresholds in percent. Bit 15 units"),
    ISOTHERM_THRESHOLD_SET(0x23, 6, 6, "Set isotherm thresholds in percent. Bit 15 units"),
    TEST_PATTERN_GET(0x25, 0, 2, "Get the current test pattern"),
    TEST_PATTERN_SET(0x25, 2, 2, "Set the test pattern"),
    VIDEO_COLOR_MODE_GET(0x26, 0, 2, "Get the color mode (color enabled or monochrome)"),
    VIDEO_COLOR_MODE_SET(0x26, 2, 2, "Set the color mode (color enabled or monochrome)"),
    SPOT_METER_GET(0x2A, 0, 2, "Get the value of the spot meter in deg C"),
    SPOT_DISPLAY_GET(0x2B, 0, 2, "Get the spot meter display mode"),
    SPOT_DISPLAY_SET(0x2B, 2, 2, "Set the spot meter display mode"),
    DDE_GAIN_GET(0x2C, 0, 2, "Get gain value for DDE in manual mode"),
    DDE_GAIN_SET(0x2C, 2, 2, "Set gain value for DDE in manual mode"),
    SYMBOL_CONTROL(0x2F, 2, 2, "Sets symbol command (set cmd 14-46 arg bytes)"),
    SPLASH_CONTROL_GET(0x31, 0, 4, "Get the splash screen delay parameters"),
    SPLASH_CONTROL_SET(0x31, 4, 4, "Set the splash screen delay parameters"),
    EZOOM_CONTROL_GET_CURRENT(0x32, 0, 2, "Get current zoom width"),
    EZOOM_CONTROL_GET_SPECIFIC(0x32, 4, 2, "Get specific zoom width"),
    EZOOM_CONTROL_SET(0x32, 4, 0, "Set zoom width"),
    FFC_WARN_TIME_GET(0x3C, 0, 2, "Get FFC warn time"),
    FFC_WARN_TIME_SET(0x3C, 2, 2, "Set FFC warn time in frames"),
    AGC_FILTER_GET(0x3E, 0, 2, "Get the AGC Filter value"),
    AGC_FILTER_SET(0x3E, 2, 2, "Set the AGC Filter value"),
    PLATEAU_LEVEL_GET(0x3F, 0, 2, "Get the plateau level for the plateau AGC algorithm"),
    PLATEAU_LEVEL_SET(0x3F, 2, 2, "Set the plateau level for the plateau AGC algorithm"),
    SPOT_METER_DATA_GET(0x43, 0, 2, "Get value of the spot meter in deg C. If not enabled, "
            + "returns average value of center four pixels"),
    SPOT_METER_DATA_GET_DETAIL(0x43, 2, 20, "Gets the average, min and max pixel values"
            + "for the spot meter"),
    SPOT_METER_COORDINATES_GET(0x43, 2, 12, "Get spot meter coordinates"),
    SPOT_METER_COORDINATES_SET(0x43, 8, 4, "Set spot-meter coordinates"),
    AGC_ROI_GET(0x4C, 0, 8, "Gets the region of interest"),
    SHUTTER_TEMP_GET(0x4D, 0, 2, "Get the temperature of the shutter. reply degC x 100"),
    SHUTTER_TEMP_SET(0x4D, 2, 0, "Set the temperature of the shutter in degC x 100"),
    SHUTTER_TEMP_RADIOMETRY_CALC_GET(0x4D, 4, 2, "Get the shutter temp calculation mode "
            + "for radiometry"),
    SHUTTER_TEMP_RADIOMETRY_CALC_SET(0x4D, 4, 0, "Set the shutter temp calculation mode "
            + "for radiometry"),   
    AGC_MIDPOINT_GET(0x55, 0, 2, "Get the AGC midpoint offset for plateau-equalization "
            + "and linear AGC algs"),
    AGC_MIDPOINT_SET(0x55, 2, 2, "Set the AGC midpoint offset for plateau-equalization "
            + "and linear AGC algs"),
    SERIAL_NUMBER_GET_REDUNDANT(0x65, 0, 8, "Get serial number of cam and sensor"),
    CAMERA_PART_GET(0x66, 0, 32, "Get camera part. Reply in ASCII"),
    READ_ARRAY_AVERAGE(0x68, 0, 4, "Read the mean of the current frame. Not ROI dependent"),
    MAX_AGC_GAIN_GET(0x6A, 0, 2, "Get the max-gain parameter for plateau AGC"),
    MAX_AGC_GAIN_SET(0x6A, 2, 2, "Set the max-gain patameter for plataeu AGC"),
    ;
    
    
    
    
    private int hexCode;
    private int cmdByteCount;
    private int replyByteCount;
    private String description;
    
    
    ThermalCamFunctionCodes(int code, int cSize, int rSize, String desc){
        this.hexCode = code;
        this.cmdByteCount = cSize;
        this.replyByteCount = rSize;
        this.description = desc;
    }
    
    public int getNumVal(){
        return hexCode;
    }
    
    public int getCmdByteCount(){
        return cmdByteCount;
    }
    
    public int getReplyByteCount(){
        return replyByteCount;
    }
    
    public String getDescription(){
        return description;
    }
}
