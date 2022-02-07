package com.aa.sri.dates;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

public class ZonedDateTimeTest {

    @Test
    void basic() {
        // Internally, dates are represented as the number of milliseconds since December 31st 1969, 11:59:59, i.e. 1 = Jan 1, 1970, 00:00:00
        // How to populate Dec 16th 2015 5:05pm

        // ZonedDateTime zonedDateTimeNow = new ZonedDateTime(); // Doesn't compile, because new classes prefer to implement the factory method way of instantiating, instead of a constructor

        // Factory method can be thought of as a personalized constructor - with a slightly different syntax
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
        System.out.println(zonedDateTimeNow); // standard ISO timestamp

        // Now to implement our requirement:
        ZonedDateTime zonedDateTimeReq = ZonedDateTime.of(2015, 12, 16, 17, 5, 0, 0, ZoneId.systemDefault()); // server timezone
        System.out.println(zonedDateTimeReq); // standard ISO timestamp // parameters make sense!!

        // For UTC?
        ZonedDateTime zonedDateTimeUtc = ZonedDateTime.of(2015, 12, 16, 17, 5, 0, 0, ZoneOffset.UTC); // server timezone
        System.out.println(zonedDateTimeUtc); // standard ISO timestamp // parameters make sense!!
        //  2015-12-16T17:05Z - Z = UTC - it's the only timezone that is different from the standard format

    }
}
