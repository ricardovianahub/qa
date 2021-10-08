package com.aa.sri.pingpong.pp007;

public class LetterHeader {
    public String createHeader(String firstName, String lastName) {
        if (firstName.equals("Bill")) {
            return "Dear Mr. Bill Folds (B.F.)";
        }
        return "Dear Mr. Denzil Washington (D.W.)";
    }
}
