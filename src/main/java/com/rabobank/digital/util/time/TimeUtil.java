package com.rabobank.digital.util.time;

public final class TimeUtil {
    private TimeUtil() {
    }
    public static String formatMillisecondsToSeconds(long milliseconds) {
        long seconds = milliseconds / 1000;
        return seconds + " seconds";
    }

}
