package com.aa.sri.dates;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class JavaUtilDateTest {

    @Test
    void basic() {
        // Internally, dates are represented as the number of milliseconds since December 31st 1969, 11:59:59, i.e. 1 = Jan 1, 1970, 00:00:00
        // How to populate Dec 16th 2015 5:05pm
        Date dateWrong = new Date(2015, 12, 16, 17, 5, 0); // Java Y2k!!!!
        System.out.println(dateWrong); // when you print any object you are running is toString() method
        Date dateFixYear = new Date(115, 12, 16, 17, 5, 0); // add 1900 + parameter year = current calendar year
        System.out.println(dateFixYear); // when you print any object you are running is toString() method
        Date dateFixMonth = new Date(115, 11, 16, 17, 5, 0); // add 1 to parameter month = current calendar month
        System.out.println(dateFixMonth); // when you print any object you are running is toString() method
        // Where is the time zone coming from??? CURRENT SERVER!!!! Means that if you run this test from another cloud region, or when daylight savings time kicks in, THE TEST WILL FAIL
        // java.util.Date HAS NO TIMEZONE ATTRIBUTE
    }

}
