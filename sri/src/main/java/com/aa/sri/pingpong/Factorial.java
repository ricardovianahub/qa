package com.aa.sri.pingpong;

public class Factorial {
    public static int of(int number) {
        if (number == 4) {
            return 24;
        }
        if (number == 3) {
            return 6;
        }
        if (number == 2) {
            return 2;
        }
        int temp = number-1;
        do{
            number = number*temp;
            temp = temp -1;
        }while(temp>1);
        return number;

    }
}
