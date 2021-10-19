package com.aa.workshop;

import org.junit.jupiter.api.Test;

public class T0023FundamentalReference {

    @Test
    void test1() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("1").append("2").append("3");
        StringBuilder sb2 = sb1;

        sb1.append("4");

        System.out.println("sb1 = " + sb1.toString());
        System.out.println("sb2 = " + sb2.toString());
    }

}

//        sb1 = 1234
//        sb2 = 123
