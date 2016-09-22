package com.i2i.vehicleloan.util;

public class ValidationUtil {
    public static boolean isAlphabetic(String input) {
        return (input.matches("^[\\p{L} .]+$")) ;
    } 

    public static boolean isNumeric(String input) {
        return (input.matches("^[\\d]+$")) ;
    }

    public static boolean isTenDigit(String input) {
        return (input.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")) ;
    }

    public static boolean isValidMailId(String input) {
        return (input.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,6}")) ;
    }
}
