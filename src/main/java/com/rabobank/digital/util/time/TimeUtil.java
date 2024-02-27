package com.rabobank.digital.util.time;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public enum TimeUtil {

    /**
     * Milliseconds.
     */
    MILLISECONDS;

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


    /**
     * Formats the given duration based on the specified time unit and format.
     *
     * @param duration   The duration to be formatted.
     * @param timeFormat The desired format for the output.
     * @return The formatted time duration.
     * @throws NullPointerException if time format is null.
     * @throws IllegalArgumentException if an unsupported time format is provided.
     */
    public String format(long duration,Format timeFormat) {
        // As a starting point our requirement is only to handle milliseconds as input and do different formatting.
        // But in future this function should be reusable for other units like HOURS, SECONDS etc.
        // So the plan is to convert other units to milliseconds before do any formatting.
        long milliseconds = convertToMilliseconds(duration);
        Objects.requireNonNull(timeFormat,"Time Format can not be null");
        switch (timeFormat){
            case seconds,s -> {
                return formatMillisecondsToSeconds(milliseconds,timeFormat);
            }
            case minutes_seconds,m_s -> {
                return formatMillisecondsToMinutesSeconds(milliseconds,timeFormat);
            }
            case hours_minutes_seconds,h_m_s -> {
                return formatMillisecondsToHoursMinutesSeconds(milliseconds,timeFormat);
            }
            default -> throw new IllegalArgumentException("Unsupported Time Format: " + timeFormat);
        }
    }

    /**
     * Formats the given duration in milliseconds to seconds.
     *
     * @param milliseconds The duration in milliseconds.
     * @param timeFormat The desired format for the output.
     * @return The formatted time duration in seconds.
     */
    private static String formatMillisecondsToSeconds(long milliseconds,Format timeFormat) {
        String unitSeconds=timeFormat==Format.s ? "s" : " seconds";
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);
        return seconds + unitSeconds;
    }
    /**
     * Formats the given duration in milliseconds to minutes and seconds.
     *
     * @param milliseconds The duration in milliseconds.
     * @param timeFormat The desired format for the output.
     * @return The formatted time duration in minutes and seconds.
     */
    private static String formatMillisecondsToMinutesSeconds(long milliseconds,Format timeFormat) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);
        seconds = seconds % 60;

        String unitSeconds=timeFormat==Format.m_s ? "s " : " seconds";
        String unitMinutes=timeFormat==Format.m_s ? "m " : " minutes ";

        StringBuilder result = new StringBuilder();

        if (minutes > 0) {
            result.append(minutes).append(unitMinutes);
        }

        if (seconds > 0 || minutes == 0) {
            result.append(seconds).append(unitSeconds);
        }

        return result.toString().trim();
    }
    /**
     * Formats the given duration in milliseconds to hours, minutes, and seconds.
     *
     * @param milliseconds The duration in milliseconds.
     * @param timeFormat The desired format for the output.
     * @return The formatted time duration in hours, minutes, and seconds.
     */
    private static String formatMillisecondsToHoursMinutesSeconds(long milliseconds,Format timeFormat) {
        long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60;

        String unitSeconds=timeFormat==Format.h_m_s ? "s " : " seconds ";
        String unitMinutes=timeFormat==Format.h_m_s ? "m " : " minutes ";
        String unitHours=timeFormat==Format.h_m_s ? "h " : " hours ";

        StringBuilder result = new StringBuilder();
        if (hours > 0) {
            result.append(hours).append(unitHours);
        }

        if (minutes > 0) {
            result.append(minutes).append(unitMinutes);
        }

        if (seconds > 0 || (minutes == 0 && hours == 0)) {
            result.append(seconds).append(unitSeconds);
        }

        return result.toString().trim();
    }
    /**
     * Converts the given duration to milliseconds based on the specified time unit.
     *
     * @param duration The duration to be converted.
     * @return The duration in milliseconds.
     * @throws IllegalArgumentException if an unsupported time unit is provided.
     */
    private long convertToMilliseconds(long duration) {
        // this will be replaced with a switch statemennts when we add more time units like HOURS,SECONDS etc in future
        if (this == MILLISECONDS) {
            return duration;
        }
        throw new IllegalArgumentException("Unsupported Time Unit: " + this);
    }
}
