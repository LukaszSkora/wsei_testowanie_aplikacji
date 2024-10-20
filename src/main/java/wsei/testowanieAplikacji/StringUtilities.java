package wsei.testowanieAplikacji;

import java.util.Arrays;

public class StringUtilities {

    public String reverse(String s) {
        String reversedStr = "";

        for (int i = 0; i < s.length(); i++) {
            reversedStr = s.charAt(i) + reversedStr;
        }
        return reversedStr;
    }

    public String removeWhitespace(String s) {
        return s.replaceAll("\\s+","");
    }

    public Boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public String camelCase(String s) {
        s = s.trim().replace(" ", "_");

        if (s.isEmpty()) return "";

        String[] parts = s.split("_");

        String camelCaseString = "";
        for (String part : parts){
            camelCaseString = camelCaseString
                    + part.substring(0, 1).toUpperCase()
                    + part.substring(1).toLowerCase();
        }
        return camelCaseString;
    }

    public String upper(String s) {
        return s.toUpperCase();
    }

    public String removeA(String s) {
        return s.replaceAll("[a,A]","");
    }
}
