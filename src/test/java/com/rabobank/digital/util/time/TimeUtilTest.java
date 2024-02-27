package com.rabobank.digital.util.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TimeUtilTest {
    @Test
    public void testFormatMillisecondsToSeconds() {
        assertEquals("5 seconds", TimeUtil.format(5000,Unit.MILLISECONDS,Format.seconds));

        assertEquals("10 seconds", TimeUtil.format(10145,Unit.MILLISECONDS,Format.seconds));

        assertEquals("0 seconds", TimeUtil.format(10,Unit.MILLISECONDS,Format.seconds));

        NullPointerException timeFormatNullException = assertThrows(NullPointerException.class, () -> {
            TimeUtil.format(10,Unit.MILLISECONDS,null);
        });
        assertEquals("Time Format can not be null", timeFormatNullException.getMessage());

        NullPointerException timeUnitNullException = assertThrows(NullPointerException.class, () -> {
            TimeUtil.format(10,null,Format.seconds);
        });
        assertEquals("Time Unit can not be null", timeUnitNullException.getMessage());
    }
    @Test
    public void testFormatMillisecondsToMinutesSeconds() {
        assertEquals("2 minutes", TimeUtil.format(120000,Unit.MILLISECONDS, Format.minutes_seconds));
        assertEquals("45 seconds", TimeUtil.format(45000,Unit.MILLISECONDS,Format.minutes_seconds));
        assertEquals("3 minutes 34 seconds", TimeUtil.format(214000,Unit.MILLISECONDS,Format.minutes_seconds));
        assertEquals("0 seconds", TimeUtil.format(100,Unit.MILLISECONDS,Format.minutes_seconds));
    }
    @Test
    public void testFormatHoursToHoursMinutesSeconds() {
        assertEquals("3 minutes 34 seconds", TimeUtil.format(214000,Unit.MILLISECONDS,Format.hours_minutes_seconds));
        assertEquals("5 hours 3 minutes 14 seconds", TimeUtil.format(18194000,Unit.MILLISECONDS,Format.hours_minutes_seconds));
        assertEquals("4 seconds", TimeUtil.format(4000,Unit.MILLISECONDS,Format.hours_minutes_seconds));
        assertEquals("0 seconds", TimeUtil.format(40,Unit.MILLISECONDS,Format.hours_minutes_seconds));
    }
}
