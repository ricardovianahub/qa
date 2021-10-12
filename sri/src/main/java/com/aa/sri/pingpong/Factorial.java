package com.aa.sri.pingpong;

public class Factorial {

    public static int of(int number) {
        if (number <= 1) {
            return 1;
        }
        number = number * of(number - 1);
        return number;
    }

}
