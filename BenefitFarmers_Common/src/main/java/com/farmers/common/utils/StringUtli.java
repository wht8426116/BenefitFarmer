package com.farmers.common.utils;

public class StringUtli {
    public static Boolean isEmpty(String...s) {
        for (String ss : s) {
            if (ss == null || ss.equals("")) {
                return true;
            }
        }
        return false;
    }
}
