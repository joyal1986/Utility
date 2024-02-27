package com.rabobank.digital.util.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeUtilTest {
    @Test
    public void testFormatMillisecondsToSeconds() {
        assertEquals("5 seconds", TimeUtil.formatMillisecondsToSeconds(5000));
        assertEquals("10 seconds", TimeUtil.formatMillisecondsToSeconds(10145));
        assertEquals("0 seconds", TimeUtil.formatMillisecondsToSeconds(10));
    }
}
