/*
 * @(#)ImageAdjustmentModel.java  1.0  2012-01-18
 * 
 * Copyright (c) 2012 Werner Randelshofer, Goldau, Switzerland.
 * All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with Werner Randelshofer.
 * For details see accompanying license terms.
 */
package org.monte.media.converter;

import java.beans.PropertyChangeListener;

/**
 * {@code ImageAdjustmentModel}.
 *
 * @author Werner Randelshofer
 * @version 1.0 2012-01-18 Created.
 */
public interface ColorAdjustModel {
    /** Level adjustment: white point in the range [0,1]. 
     */
    String WHITE_POINT_PROPERTY = "whitePoint";
    /** Level adjustment: black point in the range [0,1]. 
     */
    String BLACK_POINT_PROPERTY = "blackPoint";
    /** Level adjustment: mid point in the range [0,1]. 
     */
    String MID_POINT_PROPERTY = "midPoint";
    
    /** Exposure adjustment in the range [-1,1].
     */
    String EXPOSURE_PROPERTY = "exposure";
    /** Brightness adjustment in the range [-1,1].
     */
    String BRIGHTNESS_PROPERTY = "brightness";
    /** Contrast adjustment in the range [-1,1].
     */
    String CONTRAST_PROPERTY = "contrast";
    /** Saturation adjustment in the range [0,1].
     */
    String SATURATION_PROPERTY = "saturation";
    
    /** Definition adjustment in the range [0,1].
     */
    String DEFINITION_PROPERTY = "definition";
    /** Higlights adjustment in the range [0,1].
     */
    String HIGHLIGHTS_PROPERTY = "highlights";
    /** Shadows adjustment in the range [0,1].
     */
    String SHADOWS_PROPERTY = "shadows";
    
    /** Sharpness adjustment in the range [0,1].
     */
    String SHARPNESS_PROPERTY = "sharpness";
    /** De-noise adjustment in the range [0,1].
     */
    String DENOISE_PROPERTY = "denoise";
    
    /** Temperature adjustment in the range [-1,1].
     */
    String TEMPERATURE_PROPERTY = "temperature";
    /** Tint adjustment in the range [-1,1].
     */
    String TINT_PROPERTY = "tint";
    
    /** A 4-vector with the parameters for quadratic white balance adjustment.
     * The vector contains the values {Rmu, Rnu, Bmu, Bnu}.
     * 
     * <pre>
     *                                     [ R
     *                                       G
     *                                       B
     * [R'    [ Rnu  0   0  Rmu  0   0       R^2
     *  G'  =    0   1   0   0   0   0    *  G^2
     *  B']      0   0  Bnu  0   0  Bmu ]    B^2 ]
     * </pre>
     * 
     * <p>
     * Reference:<br>
     * Edmund Lam, Combining gray world and retinex theory for automatic 
     * white balance in	digital photography, Consumer Electronics, 2005. 
     * (ISCE 2005). Proceedings of the Ninth International Symposium on (2005), 
     * pp.134–139.
     * 
     */
    String WHITE_BALANCE_QM_PROPERTY = "whiteBalanceQM";
    String WHITE_BALANCE_QM_ENABLED_PROPERTY = "whiteBalanceQMEnabled";
    String WHITE_BALANCE_TT_ENABLED_PROPERTY = "whiteBalanceTTEnabled";

    float getWhitePoint();

    void setWhitePoint(float newValue);

    float getBlackPoint();

    void setBlackPoint(float newValue);

    float getMidPoint();

    void setMidPoint(float newValue);

    float getContrast();

    void setContrast(float newValue);

    float getDefinition();

    void setDefinition(float newValue);

    float getDenoise();

    void setDenoise(float newValue);

    float getBrightness();

    void setBrightness(float newValue);
    
    float getExposure();

    void setExposure(float newValue);

    float getHighlights();

    void setHighlights(float newValue);

    float getSaturation();

    void setSaturation(float newValue);

    float getShadows();

    void setShadows(float newValue);

    float getSharpness();

    void setSharpness(float newValue);

    float getTemperature();

    void setTemperature(float newValue);

    float getTint();

    void setTint(float newValue);
    
    void setWhiteBalanceTTEnabled(boolean newValue);
    boolean isWhiteBalanceTTEnabled();
    void setWhiteBalanceQMEnabled(boolean newValue);
    boolean isWhiteBalanceQMEnabled();
    void setWhiteBalanceQM(float[] newValue);
    float[] getWhiteBalanceQM();
    
    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);

    /** Resets all values. */
    void reset();
    
    void setTo(ColorAdjustModel that);
    
    /** Returns true, if the model does not perform any changes to the image. */
    boolean isIdentity();
}
