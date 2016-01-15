/*
 * @(#)Movie.java 
 * 
 * Copyright (c) 2011 Werner Randelshofer, Goldau, Switzerland.
 * All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with Werner Randelshofer.
 * For details see accompanying license terms.
 */
package org.monte.media;

import org.monte.media.math.Rational;
import java.beans.PropertyChangeListener;

/**
 * A {@code movie} provides an editable container for media data in a time and
 * tracks coordinate system.
 *
 * @author Werner Randelshofer
 * @version $Id: Movie.java 299 2013-01-03 07:40:18Z werner $
 */
public interface Movie {

    String PLAYHEAD_PROPERTY = "playhead";
    String IN_PROPERTY = "in";
    String OUT_PROPERTY = "out";

    /** Returns the total duration of the movie in seconds. */
    Rational getDuration();

    /** Sets the position of the insertion point in seconds. */
    void setInsertionPoint(Rational seconds);

    /** Returns the position of the insertion point in seconds.
     * If a movie has a duration of n, then there are n+1 insertion points.
     */
    Rational getInsertionPoint();

    /** Returns the position of the in point in seconds. */
    Rational getSelectionStart();

    /** Sets the position of the in point in seconds. */
    void setSelectionStart(Rational in);

    /** Returns the position of the out point in seconds. */
    Rational getSelectionEnd();

    /** Sets the position of the out point in seconds. */
    void setSelectionEnd(Rational out);

    /** Returns the frame number for the specified time in seconds. */
    long timeToSample(int track, Rational seconds);

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);

    Rational sampleToTime(int track, long sample);

    int getTrackCount();

    Format getFormat(int track);

    Format getFileFormat();

    MovieReader getReader();
}
