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
 * Version 1.1 only (the "Licence" , (ReplyAction)getGui()), appearing in the file LICENSE.md
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


import no.ntnu.thermalcamcontrol.gui.UseThermalCamMsgUpdater.ReplyAction;

/**
 * @author liz
 *
 */
public enum ThermalCamFunctionCodes {
    
    NO_OP(0x00, 0, 0, "No operation", (ReplyAction)getGui()),
    SET_DEFAULTS(0x01, 0, 0, "Set defaults non-blocking", (ReplyAction)getGui()),
    CAMERA_RESET(0x02, 0, 0, "Reset / reboot", (ReplyAction)getGui()),
    RESTORE_FACTORY_DEFAULTS(0x03, 0, 0, "Revert to factory defaults", (ReplyAction)getGui()),
    SERIAL_NUMBER(0x04, 0, 8, "Serial number request. "
            + "Reply bytes 0-3 camera, 4-7 sensor serial#", (ReplyAction)getGui()),
    GET_REVISION(0x05, 0, 8, "Get software / firmware revision. "
            + "Reply 2 bytes ea: sw maj/min, fw maj/min", (ReplyAction)getGui()),
    BAUD_RATE_GET(0x07, 0, 2, "Get current baud rate" , (ReplyAction)getGui()),
    BAUD_RATE_SET(0x07, 2, 2, "Set baud rate", (ReplyAction)getGui()),
    GAIN_MODE_GET(0x0A, 0, 2, "Get gain mode", (ReplyAction)getGui()),
    FFC_MODE_SELECT_GET(0x0B, 0, 2, "Get FFC Mode", (ReplyAction)getGui()),
    FFC_MODE_SELECT_SET(0x0B, 2, 2, "Set FFC Mode", (ReplyAction)getGui()),
    FFC_INTEG_FRAMES_GET(0x0B, 4, 2, "Get number of integrated frames during FFC" , (ReplyAction)getGui()),
    FFC_INTEG_FRAMES_SET(0x0B, 4, 0, "Set number of integrated frames during FFC" , (ReplyAction)getGui()),
    DO_FFC_AUTO(0x0C, 0, 0, "Auto FFC" , (ReplyAction)getGui()),
    DO_FFC_SPECIFIED(0x0C, 2, 2, "FFC Long or short" , (ReplyAction)getGui()),
    FFC_PERIOD_GET(0x0D, 0, 4, "Get interval between FFC frames for both gain states" , (ReplyAction)getGui()),
    FFC_PERIOD_SET(0x0D, 2, 2, "Set interval between FFC frames for current gain state" , (ReplyAction)getGui()),
    FFC_PERIOD_SPECIFY(0x0D, 4, 4, "Set interval between FFC frames for speific gain states. "
            + "Bytes 0-1 for high gain, 2-3 for low gain" , (ReplyAction)getGui()),
    FFC_TEMP_DELTA_GET(0x0E, 0, 4, "Get temp diff used to trigger auto FFC. Reply bytes "
            + "0-1 for high gain, 2-3 for low gain" , (ReplyAction)getGui()),
    FFC_TEMP_DELTA_SET(0x0E, 2, 2, "Set temp delta value for current gain state" , (ReplyAction)getGui()),
    FFC_TEMP_DELTA_SPECIFY(0x0E, 4, 4, "Set temp delta value for specific gain states. "
            + "Bytes 0-1 for high gain, 2-3 for low gain" , (ReplyAction)getGui()),
    VIDEO_MODE_GET(0x0F, 0, 2, "Get current video signal mode" , (ReplyAction)getGui()),
    VIDEO_MODE_SET(0x0F, 2, 2, "Set analog video mode" , (ReplyAction)getGui()),
    VIDEO_SYMBOLOGY_OVERLAY_GET(0x0F, 4, 2, "Get symbology overlay state, different "
            + "arguments for analog/digital" , (ReplyAction)getGui()),
    VIDEO_SYMBOLOGY_OVERLAY_SET(0x0F, 4, 4, "Set symbology overlay state, different "
            + "arguments for analog/digital" , (ReplyAction)getGui()),
    VIDEO_PALETTE_GET(0x10, 0, 2, "Get video palette" , (ReplyAction)getGui()),
    VIDEO_PALETTE_SET(0x10, 2, 2, "Set video palette" , (ReplyAction)getGui()),
    VIDEO_ORIENTATION_GET(0x11, 0, 2, "Get video orientation" , (ReplyAction)getGui()),
    VIDEO_ORIENTATION_SET(0x11, 2, 2, "Set video orientation" , (ReplyAction)getGui()),
    DIGITAL_OUTPUT_MODE_GET(0x12, 0, 2, "Get digital output mode" , (ReplyAction)getGui()),
    DIGITAL_OUTPUT_MODE_GET_SUB(0x12, 2, 2, "Get digital output mode (various sub functions)" , (ReplyAction)getGui()),
    DIGITAL_OUTPUT_MODE_SET(0x12, 2, 2, "Enable/disable digital output (both LVDS and XP channels)" , (ReplyAction)getGui()),
    AGC_TYPE_GET(0x13, 0, 2, "Get AGC algorithm" , (ReplyAction)getGui()),
    AGC_TYPE_SET(0x13, 2, 2, "Set AGC algorithm" , (ReplyAction)getGui()),
    AGC_SUB_GET(0x13, 2, 2, "AGC sub functions" , (ReplyAction)getGui()),
    AGC_SUB_SET(0x13, 4, 0, "AGC sub functions" , (ReplyAction)getGui()),
    CONTRAST_GET(0x14, 0, 2, "Get contrast value used by once-bright, auto-bright and manual"
            + "AGC algorithms" , (ReplyAction)getGui()),
    CONTRAST_SET(0x14, 2, 2, "Set contrast value used by once-bright, auto-bright and manual"
            + "AGC algorithms" , (ReplyAction)getGui()),
    BRIGHTNESS_GET(0x15, 0, 2, "Get brightness value used by manual and auto-bright AGC" , (ReplyAction)getGui()),
    BRIGHTNESS_SET(0x15, 2, 2, "Set brightness value used by manual and auto-bright AGC" , (ReplyAction)getGui()),
    BRIGHTNESS_BIAS_GET(0x18, 0, 2, "Get brightness bias value used by once-bright AGC" , (ReplyAction)getGui()),
    BRIGHTNESS_BIAS_SET(0x18, 2, 2, "Set brightness bias value used by once-bright AGC" , (ReplyAction)getGui()),
    TAIL_SIZE_GET(0x1B, 0, 2, "Get the tail rejection percentage for AGC" , (ReplyAction)getGui()),
    TAIL_SIZE_SET(0x1B, 2, 2, "Set the tail rejection percentage for AGC" , (ReplyAction)getGui()),
    ACE_CORRECT_GET(0x1C, 0, 2, "Get the Active Contrast Enhancement Correction for AGC" , (ReplyAction)getGui()),
    ACE_CORRECT_SET(0x1C, 2, 2, "Set the Active Contrast Enhancement Correction for AGC" , (ReplyAction)getGui()),
    LENS_NUMBER(0x1E, 0, 0, "" , (ReplyAction)getGui()),
    SPOT_METER_MODE_GET(0x1F, 0, 2, "Get the spot-meter mode" , (ReplyAction)getGui()),
    SPOT_METER_MODE_SET(0x1F, 2, 2, "Set the spot-meter mode" , (ReplyAction)getGui()),
    READ_SENSOR(0x20, 0, 0, "Get various data from the core, depending on "
            + "argument of incoming message" , (ReplyAction)getGui()),
    EXTERNAL_SYNC_GET(0x21, 0, 2, "Get external sync mode" , (ReplyAction)getGui()),
    EXTERNAL_SYNC_SET(0x21, 2, 2, "Set external sync mode" , (ReplyAction)getGui()),
    ISOTHERM_GET(0x22, 0, 2, "Get isotherm mode on/off" , (ReplyAction)getGui()),
    ISOTHERM_SET(0x22, 2, 2, "Set isotherm mode on/off" , (ReplyAction)getGui()),
    ISOTHERM_THRESHOLD_GET(0x23, 0, 6, "Get isotherm thresholds in percent. Bit 15 units" , (ReplyAction)getGui()),
    ISOTHERM_THRESHOLD_SET(0x23, 6, 6, "Set isotherm thresholds in percent. Bit 15 units" , (ReplyAction)getGui()),
    TEST_PATTERN_GET(0x25, 0, 2, "Get the current test pattern" , (ReplyAction)getGui()),
    TEST_PATTERN_SET(0x25, 2, 2, "Set the test pattern" , (ReplyAction)getGui()),
    VIDEO_COLOR_MODE_GET(0x26, 0, 2, "Get the color mode (color enabled or monochrome)" , (ReplyAction)getGui()),
    VIDEO_COLOR_MODE_SET(0x26, 2, 2, "Set the color mode (color enabled or monochrome)" , (ReplyAction)getGui()),
    SPOT_METER_GET(0x2A, 0, 2, "Get the value of the spot meter in deg C" , (ReplyAction)getGui()),
    SPOT_DISPLAY_GET(0x2B, 0, 2, "Get the spot meter display mode" , (ReplyAction)getGui()),
    SPOT_DISPLAY_SET(0x2B, 2, 2, "Set the spot meter display mode" , (ReplyAction)getGui()),
    DDE_GAIN_GET(0x2C, 0, 2, "Get gain value for DDE in manual mode" , (ReplyAction)getGui()),
    DDE_GAIN_SET(0x2C, 2, 2, "Set gain value for DDE in manual mode" , (ReplyAction)getGui()),
    SYMBOL_CONTROL(0x2F, 2, 2, "Sets symbol command (set cmd 14-46 arg bytes)" , (ReplyAction)getGui()),
    SPLASH_CONTROL_GET(0x31, 0, 4, "Get the splash screen delay parameters" , (ReplyAction)getGui()),
    SPLASH_CONTROL_SET(0x31, 4, 4, "Set the splash screen delay parameters" , (ReplyAction)getGui()),
    EZOOM_CONTROL_GET_CURRENT(0x32, 0, 2, "Get current zoom width" , (ReplyAction)getGui()),
    EZOOM_CONTROL_GET_SPECIFIC(0x32, 4, 2, "Get specific zoom width" , (ReplyAction)getGui()),
    EZOOM_CONTROL_SET(0x32, 4, 0, "Set zoom width" , (ReplyAction)getGui()),
    FFC_WARN_TIME_GET(0x3C, 0, 2, "Get FFC warn time" , (ReplyAction)getGui()),
    FFC_WARN_TIME_SET(0x3C, 2, 2, "Set FFC warn time in frames" , (ReplyAction)getGui()),
    AGC_FILTER_GET(0x3E, 0, 2, "Get the AGC Filter value" , (ReplyAction)getGui()),
    AGC_FILTER_SET(0x3E, 2, 2, "Set the AGC Filter value" , (ReplyAction)getGui()),
    PLATEAU_LEVEL_GET(0x3F, 0, 2, "Get the plateau level for the plateau AGC algorithm" , (ReplyAction)getGui()),
    PLATEAU_LEVEL_SET(0x3F, 2, 2, "Set the plateau level for the plateau AGC algorithm" , (ReplyAction)getGui()),
    SPOT_METER_DATA_GET(0x43, 0, 2, "Get value of the spot meter in deg C. If not enabled, "
            + "returns average value of center four pixels" , (ReplyAction)getGui()),
    SPOT_METER_DATA_GET_DETAIL(0x43, 2, 20, "Gets the average, min and max pixel values"
            + "for the spot meter" , (ReplyAction)getGui()),
    SPOT_METER_COORDINATES_GET(0x43, 2, 12, "Get spot meter coordinates" , (ReplyAction)getGui()),
    SPOT_METER_COORDINATES_SET(0x43, 8, 4, "Set spot-meter coordinates" , (ReplyAction)getGui()),
    AGC_ROI_GET(0x4C, 0, 8, "Gets the region of interest" , (ReplyAction)getGui()),
    SHUTTER_TEMP_GET(0x4D, 0, 2, "Get the temperature of the shutter. reply degC x 100" , (ReplyAction)getGui()),
    SHUTTER_TEMP_SET(0x4D, 2, 0, "Set the temperature of the shutter in degC x 100" , (ReplyAction)getGui()),
    SHUTTER_TEMP_RADIOMETRY_CALC_GET(0x4D, 4, 2, "Get the shutter temp calculation mode "
            + "for radiometry" , (ReplyAction)getGui()),
    SHUTTER_TEMP_RADIOMETRY_CALC_SET(0x4D, 4, 0, "Set the shutter temp calculation mode "
            + "for radiometry" , (ReplyAction)getGui()),   
    AGC_MIDPOINT_GET(0x55, 0, 2, "Get the AGC midpoint offset for plateau-equalization "
            + "and linear AGC algs" , (ReplyAction)getGui()),
    AGC_MIDPOINT_SET(0x55, 2, 2, "Set the AGC midpoint offset for plateau-equalization "
            + "and linear AGC algs" , (ReplyAction)getGui()),
    SERIAL_NUMBER_GET_REDUNDANT(0x65, 0, 8, "Get serial number of cam and sensor" , (ReplyAction)getGui()),
    CAMERA_PART_GET(0x66, 0, 32, "Get camera part. Reply in ASCII" , (ReplyAction)getGui()),
    READ_ARRAY_AVERAGE(0x68, 0, 4, "Read the mean of the current frame. Not ROI dependent" , (ReplyAction)getGui()),
    MAX_AGC_GAIN_GET(0x6A, 0, 2, "Get the max-gain parameter for plateau AGC" , (ReplyAction)getGui()),
    MAX_AGC_GAIN_SET(0x6A, 2, 2, "Set the max-gain patameter for plataeu AGC" , (ReplyAction)getGui()),
    PAN_AND_TILT_GET(0x70, 0, 4, "Get the pan (x axis) and tilt (y axis) for the zoom window "
            + "relative to the center of the unzoomed window. Bytes 0-1: Tilt pos, 2-3: Pan pos in rows" , (ReplyAction)getGui()),
    PAN_AND_TILT_SET(0x70, 4, 4, "Set the pan (x axis) and tilt (y axis) for the zoom window "
            + "relative to the center of the unzoomed window. Bytes 0-1: Tilt pos, 2-3: Pan pos in rows" , (ReplyAction)getGui()),
    VIDEO_STANDARD_GET(0x72, 0, 2, "Get the video standard" , (ReplyAction)getGui()),
    VIDOE_STANDARD_SET(0x72, 2, 2, "Set the video standard" , (ReplyAction)getGui()),
    SHUTTER_POSITION_GET(0x79, 0, 2, "Get the shutter position. Non-blocking" , (ReplyAction)getGui()),
    SHUTTER_POSITION_SET(0x79, 2, 2, "Set the shutter position. Non-blocking" , (ReplyAction)getGui()),
    SHUTTER_PROFILE_GET(0x80, 0, 34, "Get the shutter profile (safety timeout + close/open table" , (ReplyAction)getGui()),
    SHUTTER_PROFILE_SET(0x80, 34, 34, "Set the shutter profile (safety timeout + close/open table" , (ReplyAction)getGui()),
    TRANSFER_FRAME(0x82, 4, 4, "Capture a snapshot to a specified buffer location. Non-blocking" , (ReplyAction)getGui()),
    TLIN_COMMANDS_RESOLUTION_GET(0x8E, 2, 2, "Get the resolution of the TLinear digital video" , (ReplyAction)getGui()),
    TLIN_COMMANDS_RESOLUTION_SET(0x8E, 4, 0, "Set the resoluation of the TLinear digital video" , (ReplyAction)getGui()),
    TLIN_COMMANDS_OUTPUT_GET(0x8E, 2, 2, "Get TLinear output enabled status" , (ReplyAction)getGui()),
    TLIN_COMMANDS_OUTPUT_SET(0x8E, 4, 0, "Enable/disable TLinear output" , (ReplyAction)getGui()),
    CORRECTION_MASK_GET(0xB1, 0, 2, "Get the corrections applied" , (ReplyAction)getGui()),
    CORRECTION_MASK_SET(0xB1, 2, 2, "Set the corrections applied" , (ReplyAction)getGui()),
    MEMORY_STATUS(0xC4, 0, 2, "Get the status for several non-blocking write/erase commands" , (ReplyAction)getGui()),
    WRITE_NVFFC_TABLE(0xC6, 0, 0, "Write the FFC map to nonvolatile memory" , (ReplyAction)getGui()),
    READ_MEMORY(0xD2, 6, 256, "Reads specified number of bytes beginning at specified address. "
            + "Bytes 0-3: address, 4-6: number of bytes to read" , (ReplyAction)getGui()),
    ERASE_MEMORY_BLOCK(0xD4, 2, 2, "Erases a block or a range of non-volatile memory" , (ReplyAction)getGui()),
    GET_NV_MEMORY_SIZE(0xD5, 2, 8, "Get the base address and block size of the non-volatile memory device. "
            + "Reply bytes 0-3: base address, 4-7: block size in bytes" , (ReplyAction)getGui()),
    GET_MEMORY_ADDRESS(0xD6, 4, 8, "Get the memory address and size of the specified buffer" , (ReplyAction)getGui()),
    GAIN_SWITCH_PARAMS_GET(0xDB, 0, 8, "Get the population (%) and temp (degC) thresholds for automatic high/low gain-state switching" , (ReplyAction)getGui()),
    GAIN_SWITCH_PARAMS_SET(0xDB, 8, 8, "Set the population (%) and temp (degC) thresholds for automatic high/low gain-state switching" , (ReplyAction)getGui()),
    DDE_THRESHOLD_GET(0xE2, 0, 2, "Get the threshold of the DDE filter" , (ReplyAction)getGui()),
    DDE_THRESHOLD_SET(0xE2, 2, 2, "Set the threshold of the DDE filter" , (ReplyAction)getGui()),
    SPATIAL_THRESHOLD_GET(0xE3, 0, 2, "Get the spatial threshold of the DDE filter and the DDE mode" , (ReplyAction)getGui()),
    SPATIAL_THRESHOLD_SET(0xE3, 2, 2, "Set the spatial threshold of the DDE filter and the DDE mode" , (ReplyAction)getGui()),
    LENS_RESPONSE_PARAMS_GET(0xE5, 2, 4, "Get the lens parameters for the calculated responsitivity" , (ReplyAction)getGui()),
    LENS_RESPONSE_PARAMS_SET(0xE5, 6, 0, "Get the lens parameters for the calculated responsitivity" , (ReplyAction)getGui()),
    LENS_RESPONSE_PARAMS_RADIOMETRY_GET(0xE5, 2, 2, "Get the scene parameters for radiometric calculations" , (ReplyAction)getGui()),
    LENS_RESPONSE_PARAMS_RADIOMETRY_SET(0xE5, 4, 0, "Set the scene parameters for radiometric calculations" , (ReplyAction)getGui()), 
    ;
    
    private int functionCode;
    private int cmdByteCount;
    private int replyByteCount;
    private String description;
    private ReplyAction messageUpdater;
    
    private static ThermalCamControlGui gui;
    
    ThermalCamFunctionCodes(int code, int cSize, int rSize, String desc, ReplyAction mUp){
        this.functionCode = code;
        this.cmdByteCount = cSize;
        this.replyByteCount = rSize;
        this.description = desc;
        this.messageUpdater = mUp;
    }
    
    private static ThermalCamControlGui getGui(){
        return gui;
    }
    
    public static void setThermalCamControlGui(ThermalCamControlGui tccgui){
        gui = tccgui;
    }
    
    public ReplyAction getMessageUpdaterClass(){
        return messageUpdater;
    }
    
    public short getFunctionCode(){
        return (short)functionCode;
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
