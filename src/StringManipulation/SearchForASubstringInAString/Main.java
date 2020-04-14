package StringManipulation.SearchForASubstringInAString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(findAllTheSubstringMatchInText("abcabccda", "abc"));

    }

    public static List<List<Integer>> findAllTheSubstringMatchInText(String text, String pattern) {

        int[] pi = computePrefixTablePi(pattern + "#" + text);

        List<List<Integer>> solution = new ArrayList<>();

        for (int i = pattern.length(); i < pi.length; i++) {
            if (pi[i] == pattern.length()) {
                solution.add(Arrays.asList(i - 2 * pattern.length(), i - pattern.length() - 1));
            }
        }

        return solution;

    }

    public static int[] computePrefixTablePi(String pattern) {

        int[] pi = new int[pattern.length()];

        int i = 0;
        int j = 1;

        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[j] = i + 1;
                i++;
                j++;
            } else if (pattern.charAt(i) != pattern.charAt(j) && i > 0) {
                i = pi[i - 1];
            } else if (pattern.charAt(i) != pattern.charAt(j) && i == 0) {
                pi[j] = 0;
                j++;
            }
        }
        return pi;
    }

}
