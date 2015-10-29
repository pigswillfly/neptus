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
 * Oct 27, 2015
 */
package no.ntnu.thermalcamcontrol.gui;

/**
 * @author liz
 *
 */
class ThermalCamSettings {
    
    private ThermalCamControlGui gui;
    
    private int baudRate;
    private int gainMode;
    private int ffcMode;
    private int ffcIntervalHighGain;
    private int ffcIntervalLowGain;
    private int ffcTempIntervalHighGain;
    private int ffcTempIntervalLowGain;
    private int videoPalette;
    private int videoMode;
    private int videoOrientation;
    private int digitalOutputMode;
    private int agcAlgorithm;
    private int ssoPercent;
    private int contrast;
    private int brightness;
    private int brightnessBias;
    private int tailSize;
    private int aceCorrection;
    private int lensNumber;
    private int spotMeterMode;
    private int externalSyncMode;
    private int isothermMode;
    private int lowerIsothermThreshold;
    private int middleIsothermThreshold;
    private int upperIsothermThreshold;
    private int saturationIsothermThreshold;
    private int videoColorMode;
    private int spotDisplayMode;
    private int ddeGain;
    private int ezoomWidth;
    private int ffcWarnTime;
    private int agcFilter;
    private int plateauLevel;
    private int spotMeterCoordinates;
    private int roiTopCoordinate;
    private int roiLeftCoordinate;
    private int roiBottomCoordinate;
    private int roiRightCoordinate;
    private int agcMidpoint;
    private int maxAgcGain;
    private int pan;
    private int tilt;
    private int videoStandard;
    private int tLinearResolution;
    private int shutterProfile;
    private int correctionMask;
    private int tempThresholdHighToLowGain;
    private int tempThresholdLowToHighGain;
    private int populationThresholdHighToLowGain;
    private int populationThresholdLowToHighGain;
    private int ddeMode;
    private int ddeBlendMode;
    private int lensResponseParameters;    
    

    protected ThermalCamSettings(ThermalCamControlGui gui){
        this.gui = gui;
        initialize();
    }
    
    private void initialize(){
        setBaudRate((int)ThermalCamArguments.BAUD_AUTO.getArg());
        setGainMode((int)ThermalCamArguments.GAIN_MODE_HIGH.getArg());
        setFfcMode((int)ThermalCamArguments.FFC_MODE_AUTO.getArg());
        setFfcIntervalHighGain(0x01C2);
        setFfcIntervalLowGain(0x0708);
        setFfcTempIntervalHighGain(0x0005);
        setFfcTempIntervalLowGain(0x0005);
        setVideoPalette(0);
        setVideoMode(0x0000);
        setVideoOrientation(0x0000);
        setDigitalOutputMode((int)ThermalCamArguments.DIGITAL_OUTPUT_DISABLED.getArg());
        setAgcAlgorithm((int)ThermalCamArguments.AGC_MODE_PLATEAU.getArg());
        setSsoPercent(0x000F);
        setContrast(0x0020);
        setBrightness(0x2000);
        setBrightnessBias(0x0000);
        setTailSize(0x000A);
        setAceCorrection(0x0003);
        setLensNumber(0);
        setExternalSyncMode((int)ThermalCamArguments.EXTERNAL_SYNC_DISABLED.getArg());
        setLowerIsothermThreshold(0x005A);
        setMiddleIsothermThreshold(0x005C);
        setUpperIsothermThreshold(0x005F);
        setSaturationIsothermThreshold(0x0064);
        setVideoColorMode((int)ThermalCamArguments.VIDEO_COLOR_MODE_ENABLED.getArg());
        setEzoomWidth(0x0000);
        setFfcWarnTime(0x003C);
        setAgcFilter(0x0010);
        setRoiTopCoordinate(-50);
        setRoiLeftCoordinate(-50);
        setRoiBottomCoordinate(50);
        setRoiRightCoordinate(50);
        setAgcMidpoint(0x007F);
        setMaxAgcGain(0x0008);
        setPan(0);
        setTilt(0);
        setVideoStandard((int)ThermalCamArguments.VIDEO_STANDARD_NTSC_60HZ.getArg());
        setCorrectionMask(0x083F);
        setTempThresholdHighToLowGain(0x008C);
        setTempThresholdLowToHighGain(0x0064);
        setPopulationThresholdHighToLowGain(0x005F);
        setPopulationThresholdLowToHighGain(0x0014);
        setDdeMode(0x010A);
        setDdeBlendMode(0x0001);
                
    }
    
    public void reflectSettings(){
        gui.getSetupPanel().getGainModePanel().setGainMode(getGainMode());
        gui.getSetupPanel().getFFCPanel().setFFCMode(getFfcMode());
        gui.getSetupPanel().getFFCPanel().setFFCPeriod(getFfcIntervalLowGain(), true);
        gui.getSetupPanel().getFFCPanel().setFFCPeriod(getFfcIntervalHighGain(), false);
        gui.getSetupPanel().getFFCPanel().setFFCTempDelta(getFfcTempIntervalLowGain(), true);
        gui.getSetupPanel().getFFCPanel().setFFCTempDelta(getFfcTempIntervalHighGain(), false);
        gui.getSetupPanel().getExternalSyncPanel().setExternalSync(getExternalSyncMode());
        //etc
    }
    
    public void saveSettings(){
        setGainMode((int)gui.getSetupPanel().getGainModePanel().getGainMode());
        setFfcMode((int)gui.getSetupPanel().getFFCPanel().getFFCMode());
        setFfcIntervalLowGain((int)gui.getSetupPanel().getFFCPanel().getFFCPeriod(true));
        setFfcIntervalHighGain((int)gui.getSetupPanel().getFFCPanel().getFFCPeriod(false));
        setFfcTempIntervalLowGain((int)gui.getSetupPanel().getFFCPanel().getFFCTempDelta(true));
        setFfcTempIntervalHighGain((int)gui.getSetupPanel().getFFCPanel().getFFCTempDelta(false));
        setExternalSyncMode((int)gui.getSetupPanel().getExternalSyncPanel().getExternalSyncSetting());
        
        // operating mode = lsb of video mode gui.getSetupPanel().getOperatingModePanel().getOperatingMode()
        //etc
    }
    
    public int getBaudRate(){
        return baudRate;
    }
    
    public void setBaudRate(int baudRate){
        this.baudRate = baudRate;
    }
    
    public int getGainMode(){
        return gainMode;
    }
    
    public void setGainMode(int gainMode){
        this.gainMode = gainMode;
    }

    public int getFfcMode() {
        return ffcMode;
    }

    public void setFfcMode(int mode) {
        ffcMode = mode;
    }

    public int getFfcIntervalHighGain() {
        return ffcIntervalHighGain;
    }

    public void setFfcIntervalHighGain(int ffcIntervalHighGain) {
        this.ffcIntervalHighGain = ffcIntervalHighGain;
    }

    public int getFfcIntervalLowGain() {
        return ffcIntervalLowGain;
    }

    public void setFfcIntervalLowGain(int ffcIntervalLowGain) {
        this.ffcIntervalLowGain = ffcIntervalLowGain;
    }

    public int getFfcTempIntervalHighGain() {
        return ffcTempIntervalHighGain;
    }

    public void setFfcTempIntervalHighGain(int ffcTempIntervalHighGain) {
        this.ffcTempIntervalHighGain = ffcTempIntervalHighGain;
    }

    public int getFfcTempIntervalLowGain() {
        return ffcTempIntervalLowGain;
    }

    public void setFfcTempIntervalLowGain(int ffcTempIntervalLowGain) {
        this.ffcTempIntervalLowGain = ffcTempIntervalLowGain;
    }

    public int getVideoPalette() {
        return videoPalette;
    }

    public void setVideoPalette(int videoPalette) {
        this.videoPalette = videoPalette;
    }

    public int getVideoMode() {
        return videoMode;
    }

    public void setVideoMode(int videoMode) {
        this.videoMode = videoMode;
    }

    public int getVideoOrientation() {
        return videoOrientation;
    }

    public void setVideoOrientation(int videoOrientation) {
        this.videoOrientation = videoOrientation;
    }

    public int getDigitalOutputMode() {
        return digitalOutputMode;
    }

    public void setDigitalOutputMode(int digitalOutputMode) {
        this.digitalOutputMode = digitalOutputMode;
    }

    public int getAgcAlgorithm() {
        return agcAlgorithm;
    }

    public void setAgcAlgorithm(int agcAlgorithm) {
        this.agcAlgorithm = agcAlgorithm;
    }

    public int getSsoPercent() {
        return ssoPercent;
    }

    public void setSsoPercent(int ssoPercent) {
        this.ssoPercent = ssoPercent;
    }

    public int getContrast() {
        return contrast;
    }

    public void setContrast(int contrast) {
        this.contrast = contrast;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getBrightnessBias() {
        return brightnessBias;
    }

    public void setBrightnessBias(int brightnessBias) {
        this.brightnessBias = brightnessBias;
    }

    public int getTailSize() {
        return tailSize;
    }

    public void setTailSize(int tailSize) {
        this.tailSize = tailSize;
    }

    public int getAceCorrection() {
        return aceCorrection;
    }

    public void setAceCorrection(int aceCorrection) {
        this.aceCorrection = aceCorrection;
    }

    public int getLensNumber() {
        return lensNumber;
    }

    public void setLensNumber(int lensNumber) {
        this.lensNumber = lensNumber;
    }

    public int getSpotMeterMode() {
        return spotMeterMode;
    }

    public void setSpotMeterMode(int spotMeterMode) {
        this.spotMeterMode = spotMeterMode;
    }

    public int getExternalSyncMode() {
        return externalSyncMode;
    }

    public void setExternalSyncMode(int externalSyncMode) {
        this.externalSyncMode = externalSyncMode;
    }

    public int getIsothermMode() {
        return isothermMode;
    }

    public void setIsothermMode(int isothermMode) {
        this.isothermMode = isothermMode;
    }

    public int getLowerIsothermThreshold() {
        return lowerIsothermThreshold;
    }

    public void setLowerIsothermThreshold(int lowerIsothermThreshold) {
        this.lowerIsothermThreshold = lowerIsothermThreshold;
    }

    public int getMiddleIsothermThreshold() {
        return middleIsothermThreshold;
    }

    public void setMiddleIsothermThreshold(int middleIsothermThreshold) {
        this.middleIsothermThreshold = middleIsothermThreshold;
    }

    public int getUpperIsothermThreshold() {
        return upperIsothermThreshold;
    }

    public void setUpperIsothermThreshold(int upperIsothermThreshold) {
        this.upperIsothermThreshold = upperIsothermThreshold;
    }

    public int getSaturationIsothermThreshold() {
        return saturationIsothermThreshold;
    }

    public void setSaturationIsothermThreshold(int saturationIsothermThreshold) {
        this.saturationIsothermThreshold = saturationIsothermThreshold;
    }

    public int getVideoColorMode() {
        return videoColorMode;
    }

    public void setVideoColorMode(int videoColorMode) {
        this.videoColorMode = videoColorMode;
    }

    public int getSpotDisplayMode() {
        return spotDisplayMode;
    }

    public void setSpotDisplayMode(int spotDisplayMode) {
        this.spotDisplayMode = spotDisplayMode;
    }

    public int getDdeGain() {
        return ddeGain;
    }

    public void setDdeGain(int ddeGain) {
        this.ddeGain = ddeGain;
    }

    public int getEzoomWidth() {
        return ezoomWidth;
    }

    public void setEzoomWidth(int ezoomWidth) {
        this.ezoomWidth = ezoomWidth;
    }

    public int getFfcWarnTime() {
        return ffcWarnTime;
    }

    public void setFfcWarnTime(int ffcWarnTime) {
        this.ffcWarnTime = ffcWarnTime;
    }

    public int getAgcFilter() {
        return agcFilter;
    }

    public void setAgcFilter(int agcFilter) {
        this.agcFilter = agcFilter;
    }

    public int getPlateauLevel() {
        return plateauLevel;
    }

    public void setPlateauLevel(int plateauLevel) {
        this.plateauLevel = plateauLevel;
    }

    public int getSpotMeterCoordinates() {
        return spotMeterCoordinates;
    }

    public void setSpotMeterCoordinates(int spotMeterCoordinates) {
        this.spotMeterCoordinates = spotMeterCoordinates;
    }

    public int getRoiTopCoordinate() {
        return roiTopCoordinate;
    }

    public void setRoiTopCoordinate(int roiTopCoordinate) {
        this.roiTopCoordinate = roiTopCoordinate;
    }

    public int getRoiLeftCoordinate() {
        return roiLeftCoordinate;
    }

    public void setRoiLeftCoordinate(int roiLeftCoordinate) {
        this.roiLeftCoordinate = roiLeftCoordinate;
    }

    public int getRoiBottomCoordinate() {
        return roiBottomCoordinate;
    }

    public void setRoiBottomCoordinate(int roiBottomCoordinate) {
        this.roiBottomCoordinate = roiBottomCoordinate;
    }

    public int getRoiRightCoordinate() {
        return roiRightCoordinate;
    }

    public void setRoiRightCoordinate(int roiRightCoordinate) {
        this.roiRightCoordinate = roiRightCoordinate;
    }

    public int getAgcMidpoint() {
        return agcMidpoint;
    }

    public void setAgcMidpoint(int agcMidpoint) {
        this.agcMidpoint = agcMidpoint;
    }

    public int getMaxAgcGain() {
        return maxAgcGain;
    }

    public void setMaxAgcGain(int maxAgcGain) {
        this.maxAgcGain = maxAgcGain;
    }

    public int getPan() {
        return pan;
    }

    public void setPan(int pan) {
        this.pan = pan;
    }

    public int getTilt() {
        return tilt;
    }

    public void setTilt(int tilt) {
        this.tilt = tilt;
    }

    public int getVideoStandard() {
        return videoStandard;
    }

    public void setVideoStandard(int videoStandard) {
        this.videoStandard = videoStandard;
    }

    public int gettLinearResolution() {
        return tLinearResolution;
    }

    public void settLinearResolution(int tLinearResolution) {
        this.tLinearResolution = tLinearResolution;
    }

    public int getShutterProfile() {
        return shutterProfile;
    }

    public void setShutterProfile(int shutterProfile) {
        this.shutterProfile = shutterProfile;
    }

    public int getCorrectionMask() {
        return correctionMask;
    }

    public void setCorrectionMask(int correctionMask) {
        this.correctionMask = correctionMask;
    }

    public int getTempThresholdHighToLowGain() {
        return tempThresholdHighToLowGain;
    }

    public void setTempThresholdHighToLowGain(int tempThresholdHighToLowGain) {
        this.tempThresholdHighToLowGain = tempThresholdHighToLowGain;
    }

    public int getTempThresholdLowToHighGain() {
        return tempThresholdLowToHighGain;
    }

    public void setTempThresholdLowToHighGain(int tempThresholdLowToHighGain) {
        this.tempThresholdLowToHighGain = tempThresholdLowToHighGain;
    }

    public int getPopulationThresholdHighToLowGain() {
        return populationThresholdHighToLowGain;
    }

    public void setPopulationThresholdHighToLowGain(int populationThresholdHighToLowGain) {
        this.populationThresholdHighToLowGain = populationThresholdHighToLowGain;
    }

    public int getPopulationThresholdLowToHighGain() {
        return populationThresholdLowToHighGain;
    }

    public void setPopulationThresholdLowToHighGain(int populationThresholdLowToHighGain) {
        this.populationThresholdLowToHighGain = populationThresholdLowToHighGain;
    }

    public int getDdeMode() {
        return ddeMode;
    }

    public void setDdeMode(int ddeMode) {
        this.ddeMode = ddeMode;
    }

    public int getDdeBlendMode() {
        return ddeBlendMode;
    }

    public void setDdeBlendMode(int ddeBlendMode) {
        this.ddeBlendMode = ddeBlendMode;
    }

    public int getLensResponseParameters() {
        return lensResponseParameters;
    }

    public void setLensResponseParameters(int lensResponseParameters) {
        this.lensResponseParameters = lensResponseParameters;
    }


}
