package com.aa.sri.pingpong;

public class Factorial {
  /*  public static int of_original(int number) {
        if (number == 1) {
            return 1;
        }
        int temp = number - 1;
        do {
            number = number * temp;
            temp = temp - 1;
        } while (temp > 1);
        return number;
    }

    public static int of_for(int number) {
        int result = 1;
        for (int i = number; i > 1; i--) {
            result = result * i;
        }
        return result;
    }*/

    public static int of(int number) {
        if (number == 0) {
            return 1;
        }
        number = number*of(number - 1);
        return number;
    }

}
