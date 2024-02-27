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
}
