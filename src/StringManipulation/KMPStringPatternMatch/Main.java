package StringManipulation.KMPStringPatternMatch;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(KMP("abbabcd", "abcd"));

    }

    public static boolean KMP(String text, String pattern) {

        int[] pi = computePrefixFunctionPi(pattern);

        int i = 0;
        int j = 0;

        while (j < text.length()) {
            if (text.charAt(j) == pattern.charAt(i)) {
                i++;
                j++;
            } else {
                if (i == 0) j++;
                else i = pi[i - 1];
            }
            if (i == pattern.length()) {
                System.out.println("Pattern Found in: " + i + " " + j);
                return true;
            }
        }

        return false;

    }

    public static int[] computePrefixFunctionPi(String pattern) {

        int[] pi = new int[pattern.length()];

        pi[0] = 0;

        int i = 0, j = 1;

        while (j < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[j] = i + 1;
                i++;
                j++;
            } else if (pattern.charAt(i) != pattern.charAt(j) && i == 0) {
                pi[j] = 0;
                j++;
            } else if (pattern.charAt(i) != pattern.charAt(j) && i > 0) {
                i = pi[i - 1];
            }

        }

        return pi;

    }

}
