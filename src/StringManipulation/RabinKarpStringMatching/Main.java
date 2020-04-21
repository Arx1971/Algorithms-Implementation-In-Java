package StringManipulation.RabinKarpStringMatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(stringMatching("abcdef", "cdef"));

    }

    public static List<List<Integer>> stringMatching(String text, String pattern) {

        List<List<Integer>> solution = new ArrayList<>();

        int patternHash = 0;
        int tHash = 0;
        int prime = 31;

        for (int i = 0; i < pattern.length(); i++) {
            patternHash += (pattern.charAt(i)) * prime;
            tHash += (text.charAt(i)) * prime;
        }

        List<Integer> textHash = new ArrayList<>();

        if (patternHash == tHash) {

            if (pattern.equals(text.substring(0, pattern.length()))) {
                solution.add(Arrays.asList(0, pattern.length() - 1));
            }

        }


        for (int i = 0; i < text.length(); i++) {
            textHash.add((text.charAt(i)) * prime);
        }

        for (int i = 1; i < text.length() - pattern.length() + 1; i++) {
            tHash -= textHash.get(i - 1);
            tHash += textHash.get(i + pattern.length() - 1);
            if (patternHash == tHash) {
                if (pattern.equals(text.substring(i, i + pattern.length()))) {
                    solution.add(Arrays.asList(i, i + pattern.length()));
                }
            }
        }
        return solution;

    }

}
