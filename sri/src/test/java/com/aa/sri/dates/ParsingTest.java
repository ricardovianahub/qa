package com.aa.sri.dates;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class ParsingTest {

    @Test
    void parsingStandard() {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2022-02-11T13:00:00-06:00[America/Chicago]");
        System.out.println(zonedDateTime.getOffset());
        System.out.println(zonedDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE));
    }

}
