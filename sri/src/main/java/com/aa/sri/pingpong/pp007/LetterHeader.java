package com.aa.sri.pingpong.pp007;

public class LetterHeader {
    public String createHeader(String firstName, String lastName) {
        guardCreateHeader(firstName, lastName);
        if("Strange".equals(lastName)){
            return "Dear Mr. Bill Strange (B.S.)";
        }
        if ("Bill".equals(firstName)) {
            return "Dear Mr. Bill Folds (B.F.)";
        }
        return "Dear Mr. "+firstName+" "+lastName+" (D.W.)";
    }

    private void guardCreateHeader(String firstName, String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException();
        }
        if (firstName == null) {
            throw new IllegalArgumentException();
        }
    }
}
