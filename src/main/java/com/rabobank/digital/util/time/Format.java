package com.rabobank.digital.util.time;

/**
 * Enumeration representing different time formats.
 */
public enum Format {
    /**
     * Format in seconds.
     */
    seconds,
    /**
     * Format in minutes and seconds.
     */
    minutes_seconds,
    /**
     * Format in hours, minutes, and seconds.
     */
    hours_minutes_seconds,
    /**
     * Short form for hours, minutes, and seconds (e.g., 1h 30m 15s).
     */
    h_m_s,
    /**
     * Short form for minutes and seconds (e.g., 3m 45s).
     */
    m_s,
    /**
     * Short form for seconds (e.g., 2s).
     */
    s
}
