package com.aa.sri.pingpong;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PP007Test {

    // Send first name, last name as parameters and return the following (header):
    // Dear Mr. [First Name] [Last Name] (initials with periods)
    @Test
    void createHeader() {
        KeyHeader keyHeader = new KeyHeader();
        String actual = keyHeader.createHeader("Denzil", "Washington");
        assertEquals("Dear Mr. [Denzil] [Washington] (DW.)", actual);
    }

}
