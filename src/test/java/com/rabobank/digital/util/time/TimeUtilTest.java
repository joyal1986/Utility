package com.rabobank.digital.util.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TimeUtilTest {
    @Test
    public void testFormatMillisecondsToSeconds() {
        assertEquals("5 seconds", TimeUtil.MILLISECONDS.format(5000, TimeUtil.Format.seconds));

        assertEquals("10 seconds", TimeUtil.MILLISECONDS.format(10145, TimeUtil.Format.seconds));

        assertEquals("0 seconds", TimeUtil.MILLISECONDS.format(10, TimeUtil.Format.seconds));

        NullPointerException timeFormatNullException = assertThrows(NullPointerException.class, () -> {
            TimeUtil.MILLISECONDS.format(10,null);
        });
        assertEquals("Time Format can not be null", timeFormatNullException.getMessage());
    }
    @Test
    public void testFormatMillisecondsToMinutesSeconds() {
        assertEquals("2 minutes", TimeUtil.MILLISECONDS.format(120000,TimeUtil.Format.minutes_seconds));
        assertEquals("45 seconds", TimeUtil.MILLISECONDS.format(45000,TimeUtil.Format.minutes_seconds));
        assertEquals("3 minutes 34 seconds", TimeUtil.MILLISECONDS.format(214000,TimeUtil.Format.minutes_seconds));
        assertEquals("0 seconds", TimeUtil.MILLISECONDS.format(100,TimeUtil.Format.minutes_seconds));

        assertEquals("2m", TimeUtil.MILLISECONDS.format(120000,TimeUtil.Format.m_s));
        assertEquals("45s", TimeUtil.MILLISECONDS.format(45000,TimeUtil.Format.m_s));
        assertEquals("3m 34s", TimeUtil.MILLISECONDS.format(214000,TimeUtil.Format.m_s));
        assertEquals("0s", TimeUtil.MILLISECONDS.format(100,TimeUtil.Format.m_s));
    }
    @Test
    public void testFormatMillisecondsToHoursMinutesSeconds() {
        assertEquals("3 minutes 34 seconds", TimeUtil.MILLISECONDS.format(214000,TimeUtil.Format.hours_minutes_seconds));
        assertEquals("5 hours 3 minutes 14 seconds", TimeUtil.MILLISECONDS.format(18194000,TimeUtil.Format.hours_minutes_seconds));
        assertEquals("4 seconds", TimeUtil.MILLISECONDS.format(4000,TimeUtil.Format.hours_minutes_seconds));
        assertEquals("0 seconds", TimeUtil.MILLISECONDS.format(40,TimeUtil.Format.hours_minutes_seconds));

        assertEquals("3m 34s", TimeUtil.MILLISECONDS.format(214000,TimeUtil.Format.h_m_s));
        assertEquals("5h 3m 14s", TimeUtil.MILLISECONDS.format(18194000,TimeUtil.Format.h_m_s));
        assertEquals("4s", TimeUtil.MILLISECONDS.format(4000,TimeUtil.Format.h_m_s));
        assertEquals("0s", TimeUtil.MILLISECONDS.format(40,TimeUtil.Format.h_m_s));
    }
}
