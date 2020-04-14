package StringManipulation.MaximumOccurrenceOfPrefixInTheArray;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        System.out.println(maximumOccurrencesOfPrefix("abcd"));

    }

    public static String maximumOccurrencesOfPrefix(String str) {

        int[] pi = computerPiTable(str);

        int[] solution = new int[pi.length];

        System.out.println(Arrays.toString(pi));

        for (int i = 0; i < pi.length; i++) {
            solution[pi[i]]++;
        }

        int maxPrefixLen = 0;
        int cur = 0;

        System.out.println(Arrays.toString(solution));

        for (int i = 1; i < solution.length; i++) {
            if (solution[i] >= cur) {
                cur = solution[i];
                maxPrefixLen = i;
            }
        }

        return str.substring(0, maxPrefixLen);

    }

    public static int[] computerPiTable(String str) {
        int[] pi = new int[str.length()];

        int i = 0;
        int j = 1;

        while (j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                pi[j] = i + 1;
                i++;
                j++;
            } else {
                if (i > 0) i = pi[i - 1];
                if (i == 0) {
                    pi[j] = 0;
                    j++;
                }
            }
        }
        return pi;
    }

}
