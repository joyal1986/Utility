package com.rabobank.digital.util.time;

import java.util.Objects;

public final class TimeUtil {
    private TimeUtil() {
    }

    /**
     * Formats the given duration based on the specified time unit and format.
     *
     * @param duration   The duration to be formatted.
     * @param timeUnit   The time unit for the duration.
     * @param timeFormat The desired format for the output.
     * @return The formatted time duration.
     * @throws NullPointerException if time format is null.
     * @throws IllegalArgumentException if an unsupported time format is provided.
     */
    public static String format(long duration,Unit timeUnit,Format timeFormat) {
        // As a starting point our requirement is only to handle milliseconds as input and do different formatting.
        // But in future this function should be reusable for other units like HOURS, SECONDS etc.
        // So the plan is to convert other units to milliseconds before do any formatting.
        long milliseconds = convertToMilliseconds(duration, timeUnit);
        Objects.requireNonNull(timeFormat,"Time Format can not be null");
        switch (timeFormat){
            case seconds -> {
                return formatMillisecondsToSeconds(milliseconds);
            }
            case minutes_seconds -> {
                return formatMillisecondsToMinutesSeconds(milliseconds);
            }
            case hours_minutes_seconds -> {
                return formatMillisecondsToHoursMinutesSeconds(milliseconds);
            }
            default -> throw new IllegalArgumentException("Unsupported Time Format: " + timeFormat);
        }
    }

    /**
     * Formats the given duration in milliseconds to seconds.
     *
     * @param milliseconds The duration in milliseconds.
     * @return The formatted time duration in seconds.
     */
    public static String formatMillisecondsToSeconds(long milliseconds) {
        long seconds = milliseconds / 1000;
        return seconds + " seconds";
    }
    /**
     * Formats the given duration in milliseconds to minutes and seconds.
     *
     * @param milliseconds The duration in milliseconds.
     * @return The formatted time duration in minutes and seconds.
     */
    public static String formatMillisecondsToMinutesSeconds(long milliseconds) {
        long minutes = (milliseconds / 1000) / 60;
        long seconds = (milliseconds / 1000) % 60;

        StringBuilder result = new StringBuilder();

        if (minutes > 0) {
            result.append(minutes).append(" minutes ");
        }

        if (seconds > 0 || minutes == 0) {
            result.append(seconds).append(" seconds");
        }

        return result.toString().trim();
    }
    /**
     * Formats the given duration in milliseconds to hours, minutes, and seconds.
     *
     * @param milliseconds The duration in milliseconds.
     * @return The formatted time duration in hours, minutes, and seconds.
     */
    public static String formatMillisecondsToHoursMinutesSeconds(long milliseconds) {
        long hours = (milliseconds / 1000) / 3600;
        long minutes = ((milliseconds / 1000) % 3600) / 60;
        long seconds = (milliseconds / 1000) % 60;

        StringBuilder result = new StringBuilder();
        if (hours > 0) {
            result.append(hours).append(" hours ");
        }

        if (minutes > 0) {
            result.append(minutes).append(" minutes ");
        }

        if (seconds > 0 || (minutes == 0 && hours == 0)) {
            result.append(seconds).append(" seconds");
        }

        return result.toString().trim();
    }
    /**
     * Converts the given duration to milliseconds based on the specified time unit.
     *
     * @param duration The duration to be converted.
     * @param timeUnit The time unit of the duration.
     * @return The duration in milliseconds.
     * @throws NullPointerException if time unit is null.
     * @throws IllegalArgumentException if an unsupported time unit is provided.
     */
    public static long convertToMilliseconds(long duration, Unit timeUnit) {
        if (Objects.requireNonNull(timeUnit,"Time Unit can not be null") == Unit.MILLISECONDS) {
            return duration;
        }
        throw new IllegalArgumentException("Unsupported Time Unit: " + timeUnit);
    }
}
