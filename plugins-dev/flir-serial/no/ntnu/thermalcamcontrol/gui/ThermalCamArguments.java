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
public enum ThermalCamArguments {
    BAUD_AUTO(0x0000),
    BAUD_9600(0x0001),
    BAUD_19200(0x0002),
    BAUD_57600(0x0004),
    BAUD_115200(0x0005),
    BAUD_460800(0x0006),
    BAUD_921600(0x0007),
    
    GAIN_MODE_AUTO(0x0000),
    GAIN_MODE_LOW(0x0001),
    GAIN_MODE_HIGH(0x0002),
    GAIN_MODE_MANUAL(0x0003),
    
    FFC_MODE_MANUAL(0x0000),
    FFC_MODE_AUTO(0x0001),
    FFC_MODE_EXTERNAL(0x0002),
    
    FFC_INTEG_FRAMES_GET(0x00030000),
    FFC_INTEG_FRAMES_SET(0x0002),
    FFC_INTEG_FRAMES_4(0x0000),
    FFC_INTEG_FRAMES_8(0x0001),
    FFC_INTEG_FRAMES_16(0x0002),
    
    DO_FFC_SHORT(0x0000),
    DO_FFC_LONG(0x0001),
    DO_FFC_REPLY(0xFFFF),
    
    VIDEO_MODE_MASK(0x0001),
    VIDEO_MODE_REAL_TIME(0x0000),
    VIDEO_MODE_FREEZE(0x0001),
    ANALOG_VIDEO_ON_OFF_MASK(0x0002),
    ANALOG_VIDEO_ON(0x0000),
    ANALOG_VIDEO_OFF(0x0002),
    
    ZOOM_2X_MASK(0x0003),
    ZOOM_4X_MASK(0x0004),
    ZOOM_8X_MASK(0x0010),
    ZOOM_IGNORE_MASK(0x0100), 
    
    SYMBOLOGY_OVERLAY_GET(0x00000000),
    SYMBOLOGY_OVERLAY_SET_ANALOG(0x0001),
    SYMBOLOGY_OVERLAY_SET_DIGITAL(0x0002),
    SYMBOLOGY_OVERLAY_ENABLE(0x0001),
    SYMBOLOGY_OVERLAY_DISABLE(0x0000),
    
    VIDEO_ORIENTATION_NORMAL(0x0000),
    VIDEO_ORIENTATION_INVERT(0x0001),
    VIDEO_ORIENTATION_REVERT(0x0002),
    VIDEO_ORIENTATION_BOTH(0x0003),
    
    VIDEO_COLOR_MODE_DISABLED(0x0000),
    VIDEO_COLOR_MODE_ENABLED(0x0001),
    
    VIDEO_PALETTE_WHITE_HOT(0x0000),

    
    /* For DIGITAL_OUTPUT_MODE function code */
    DIGITAL_OUTPUT_ENABLED(0x0000),
    DIGITAL_OUTPUT_DISABLED(0x0002),
    
    XP_MODE_SET(0x03),
    XP_MODE_DISABLED(0x00),
    XP_MODE_BT656(0x01),
    XP_MODE_CMOS_14bit(0x02),
    XP_MODE_CMOS_8bit(0x03),
    XP_MODE_CMOS_16bit(0x04),
    
    LVDS_MODE_GET(0x04),
    LVDS_MODE_SET(0x05),
    LVDS_MODE_DISABLED(0x00),
    LVDS_MODE_ENABLED(0x01),
    
    CMOS_MODE_BIT_DEPTH_SET(0x06),
    CMOS_MODE_BIT_DEPTH_GET(0x0800),
    CMOS_MODE_14_PRE_AGC(0x00),
    CMOS_MODE_8_POST_AGC(0x01),
    CMOS_MODE_8_BAYER(0x02),
    CMOS_MODE_16_YCbCr(0x03),
    CMOS_MODE_8_2x_clk_YCbCr(0x04),
    
    LVDS_MODE_BIT_DEPTH_GET(0x09),
    LVDS_MODE_BIT_DEPTH_SET(0x07),
    LVDS_MODE_14(0x00),
    LVDS_MODE_8_POST_AGC(0x01),
    LVDS_MODE_8_BAYER(0x02),
    
    DIGITAL_EZOOM_MODE_SET(0x0E),
    DIGITAL_EZOOM_MODE_GET(0x0F),
    DIGITAL_EZOOM_ENABLE(0x01),
    DIGITAL_EZOOM_DISABLE(0x00),

    DIGITAL_BAYER_ENCODE_SET(0x14),
    DIGITAL_BAYER_ENCODE_GET(0x15),
    BAYER_ENCODE_GR(0x00),
    BAYER_ENCODE_GB(0x01),
    BAYER_ENCODE_BG(0x02),
    BAYER_ENCODE_RG(0x03),
    
    CMOS_OUTPUT_CLOCK_MODE_GET(0x1C),
    CMOS_OUTPUT_CLOCK_MODE_SET(0x1D),
    CMOS_OUTPUT_CLOCK_MODE_NORMAL(0x00),
    CMOS_OUTPUT_CLOCK_MODE_INVERT(0x01),
    
    LVDS_OUTPUT_CLOCK_MODE_GET(0x20),
    LVDS_OUTPUT_CLOCK_MODE_SET(0x21),
    LVDS_OUTPUT_CLOCK_MODE_NORMAL(0x00),
    LVDS_OUTPUT_CLOCK_MODE_INVERT(0x01),
    /****/
    
    /* AGC_TYPE function code */
    AGC_MODE_PLATEAU(0x0000),
    AGC_MODE_ONCE_BRIGHT(0x0001),
    AGC_MODE_AUTO_BRIGHT(0x0002),
    AGC_MODE_MANUAL(0x0003),
    AGC_MODE_NOT_DEFINED(0x0004),
    AGC_MODE_LINEAR(0x0005),
    AGC_MODE_INFO_BASED(0x0009),
    AGC_MODE_INFO_BASED_EQUALIZATION(0x000A),
    
    AGC_INFO_THRESHOLD(0x03),
    AGC_SSO_PERCENT(0x03),
    /***/
    
    READ_SENSOR_FPA_TEMP_DEGCx10(0x0000),
    READ_SENSOR_FPA_TEMP_RAW_COUNT(0x0001),
    READ_SENSOR_HOUSING_TEMP(0x0009),
    READ_SENSOR_STATUS(0x0011),
    READ_SENSOR_ACCELEROMETER(0x000B),
    
    SENSOR_REPLY_STATUS_OVERTEMP_AND(0x01),
    SENSOR_REPLY_STATUS_FFC_DESIRED_AND(0x08),
    SENSOR_REPLY_STATUS_GAIN_SWITCH_DESIRED_AND(0x10),
    SENSOR_REPLY_STATUS_NUC_SWITCH_DESIRED_AND(0x20),
    SENSOR_REPLY_STATUS_FFC_IN_PROGRESS(0x40),
    
    SENSOR_REPLY_ACC_X_MASK(0x02),
    SENSOR_REPLY_ACC_Y_MASK(0x0B),
    SENSOR_REPLY_ACC_Z_MASK(0x20),
    
    EXTERNAL_SYNC_DISABLED(0x0000),
    EXTERNAL_SYNC_SLAVE(0x0001),
    EXTERNAL_SYNC_MASTER(0x0002),
    
    ISOTHERM_DISABLED(0x0000),
    ISOTHERM_ENABLED(0x0001),
    
    ISOTHERM_THRESHOLDS_UNIT_DEG(0x1),
    ISOTHERM_THRESHOLDS_UNIT_PERCENT(0x0),
    ISOTHERM_THRESHOLDS_UNIT_MASK(0x000000000001),
    ISOTHERM_THRESHOLDS_LOWER_MASK(0x000000001110),
    ISOTHERM_THRESHOLDS_MIDDLE_SHIFT(8),
    ISOTHERM_THRESHOLDS_UPPER_SHIFT(8),
    
    ISOTHERM_T4MODE_GET(0x0002),
    ISOTHERM_T4MODE_SET(0x0003),
    ISOTHERM_T4MODE_DISABLED(0x0000),
    ISOTHERM_T4MODE_ENABLED(0x0001),
    
    ISOTHERM_SATURATION_THRESHOLD_GET(0x0000),
    ISOTHERM_SATURATION_THRESHOLD_SET(0x0001),
    
    ISOTHERM_ALL_FOUR_THRESHOLDS_GET(0x0004),
    ISOTHERM_ALL_FOUR_THRESHOLDS_SET(0x0000),
    ISOTHERM_ALL_FOUR_MASK(0x1111),
    ISOTHERM_ALL_FOUR_LOWER_SHIFT(4),
    ISOTHERM_ALL_FOUR_MIDDLE_SHIFT(8),
    ISOTHERM_ALL_FOUR_UPPER_SHIFT(12),
    ISOTHERM_ALL_FOUR_SATURATION_SHIFT(16),
    
    TEST_PATTERN_OFF(0x0000),
    TEST_PATTERN_14BIT_ASCENDING_RAMP(0x0001),
    TEST_PATTERN_BIG_VERTICAL(0x0003),
    TEST_PATTERN_HORIZONTAL_SHADE(0x0004),
    TEST_PATTERN_FACTORY_USE(0x0005),
    TEST_PATTERN_COLOR_BARS(0x0006),
    TEST_PATTERN_RAMP_WITH_STEPS(0x0008),
    
    COLOR_MODE_COLOR_ENABLED(0x0001),
    COLOR_MODE_MONOCHROME(0x0000),
    
    SPOT_METER_DISPLAY_OFF(0x0000),
    SPOT_METER_DISPLAY_NUMERIC_ONLY(0x0001),
    SPOT_METER_DISPLAY_THERMOMETER_ONLY(0x0002),
    SPOT_METER_DISPLAY_BOTH(0x0003),
    
    SYMBOL_UNFREEZE(0x0000),
    SYMBOL_FREEZE(0x0001),
    SYMBOL_PAINT(0x0002),
    SYMBOL_WRITE(0x0003),
    
    SYMBOL_TYPE_NONE(0x0000),
    SYMBOL_TYPE_RECTANGLE(0x0001),
    SYMBOL_TYPE_TEXT(0x0002),
    SYMBOL_TYPE_BITMAP(0x0003),
    SYMBOL_TYPE_OUTLINE_RECTANGLE(0x0004),
    
    EZOOM_CONTROL_SET_SPECIFIED_VAL(0x0001),
    EZOOM_CONTROL_INCREMENT_BY_VAL(0x0002),
    EZOOM_CONTROL_DECREMENT_BY_VAL(0x0003),
    
    AGC_FILTER_VALUE_IMMEDIATE_PREV(0),
    AGC_FILTER_VALUE_MOST_PREV(1),
    AGC_FILTER_VALUE_LEAST_PREV(255),
    AGC_FILTER_VALUE_NO_UPDATES_27(0),
    AGC_FILTER_VALUE_MOST_27(1),
    AGC_FILTER_VALUE_IMMEDIATE_27(255),
    
    SPOT_METER_DATA_REPLY_IN_COUNTS(0x0000),
    SPOT_METER_DATA_REPLY_IN_Cx10(0x0001),
    SPOT_METER_DATA_REPLY_IN_Kx100(0x0002),

    SHUTTER_TEMP_RADIOMETRY_GET(0x0001),
    SHUTTER_TEMP_RADIOMETRY_SET(0x0000),
    SHUTTER_TEMP_RADIOMETRY_MODE_USER(0X0000),
    SHUTTER_TEMP_RADIOMETRY_MODE_AUTO(0X0001),
    SHUTTER_TEMP_RADIOMETRY_MODE_STATIC(0X0002),
    
    VIDEO_STANDARD_NTSC_30HZ(0x0000),
    VIDEO_STANDARD_PAL_25HZ(0x0001),
    VIDEO_STANDARD_NTSC_60HZ(0x0004),
    VIDEO_STANDARD_PAL_50HZ(0x0005),
    
    SHUTTER_POSITION_OPEN(0x0000),
    SHUTTER_POSITION_CLOSE(0x0001),
    SHUTTER_POSITION_UNKNOWN(0xFFFF),
    
    TRANSFER_FRAME_TYPE_14BIT_SNAPSHOT(0x08),
    TRANSFER_FRAME_8BIT_CAPTURE(0x16),
    TRANSFER_FRAME_8BIT_PLAYBACK(0x17),
    TRANSFER_FRAME_CAPTURE(0x00000001),
    TRANSFER_FRAME_PLAYBACK(0x00000000),
    
    TLIN_RESOLUTION(0x0010),
    TLIN_RESOLUTION_MODE_LOW(0x0000),
    TLIN_RESOLUTION_MODE_HIGH(0x0001),
    
    TLIN_OUTPUT(0x0040),
    
    CORRECTION_MASK_TEMPORAL_FILTER(0x10),
    
    MEMORY_STATUS_COMPLETE(0x0000),
    MEMORY_STATUS_ERASE_ERROR(0xFFFF),
    MEMORY_STATUS_WRITE_ERROR(0xFFFE),
    
    GET_NV_MEMORY_SIZE(0xFFFF),
    
    GET_MEMORY_SNAPSHOT_AREA(0xFFFF0013),
    GET_MEMORY_USED_BYTES(0xFFFE0013),
    GET_MEMORY_ADDRESS_OF_SNAPSHOT_ONE(0x00010013),
    GET_FOUR_BYTE_HEADER_WITH_SNAPSHOT_ONE(0x80010013),

    SPATIAL_THRESHOLD_MANUAL(0x00),
    SPATIAL_THRESHOLD_MANUAL_MAX(0x000F),
    SPATIAL_THRESHOLD_AUTO(0x01),
    SPATIAL_THRESHOLD_AUTO_MIN_MINUS20(0x0164),
    SPATIAL_THRESHOLD_AUTO_MAX_100(0x01EC),
    SPATIAL_THRESHOLD_DDE_BLEND_MODE_GET(0x0002),
    SPATIAL_THRESHOLD_DDE_BLEND_MODE_SET(0x0001),
    SPATIAL_THRESHOLD_DDE_BLEND_MODE_DISABLED(0x0000),
    SPATIAL_THRESHOLD_DDE_BLEND_MODE_ENABLED(0x0001),
    
    LENS_RESPONSE_PARAMS_LENS_0(0x0000),
    LENS_RESPONSE_PARAMS_LENS_1(0x0001),
    LENS_RESPONSE_PARAMS_F_HASH_MIN(4096),
    LENS_RESPONSE_PARAMS_F_HASH_MAX(65535),
    LENS_RESPONSE_PARAMS_TRANSMISSION_MIN(4096),
    LENS_RESPONSE_PARAMS_TRANSMISSION_MAX(8192),
    LENS_RESPONSE_PARAMS_RAD_EMISSIVITY(0x0100),
    LENS_RESPONSE_PARAMS_RAD_EMISSIVITY_MIN(4096),
    LENS_RESPONSE_PARAMS_RAD_EMISSIVITY_MAX(8192),
    LENS_RESPONSE_PARAMS_RAD_TBKG_X100(0x0101),
    LENS_RESPONSE_PARAMS_RAD_TRANSMISSION_WIN(0x0102),
    LENS_RESPONSE_PARAMS_RAD_TRANSMISSION_WIN_MIN(4096),
    LENS_RESPONSE_PARAMS_RAD_TRANSMISSION_WIN_MAX(8192),
    LENS_RESPONSE_PARAMS_RAD_TWIN_X100(0x0103),
    LENS_RESPONSE_PARAMS_RAD_TAU_ATM(0x0104),
    LENS_RESPONSE_PARAMS_RAD_TAU_ATM_MIN(4096),
    LENS_RESPONSE_PARAMS_RAD_TAU_ATM_MAX(8192),
    LENS_RESPONSE_PARAMS_RAD_TATM_X100(0x0105),
    LENS_RESPONSE_PARAMS_RAD_REFL_WIN(0x0106),
    LENS_RESPONSE_PARAMS_RAD_TREFL_X100(0x0107)
    ;
    
    
    private long arg;
    
    ThermalCamArguments(long number){
        this.arg = number;
    }
    
    public long getArg(){
        return this.arg;
    }
}
