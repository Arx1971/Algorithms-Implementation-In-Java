package StringManipulation.CountNumberUniqueSubStrings;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String args[]) {

        System.out.println(numberOfUniqueSubstring("abcc"));

    }

    public static int numberOfUniqueSubstring(String str) {

        int counter = 0;

        int[] p_pow = new int[str.length()];

        int[] hash = new int[str.length() + 1];

        int prime = 3;
        int m = 7;

        p_pow[0] = 1;

        for (int i = 1; i < str.length(); i++) {
            p_pow[i] = (prime * p_pow[i - 1]) % m;
        }

        for (int i = 0; i < str.length(); i++) {
            hash[i + 1] = (hash[i] + (str.charAt(i) - 'a' + 1) * p_pow[i]) % m;
        }

        for (int i = 1; i <= str.length(); i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j <= str.length() - i; j++) {
                int cur_hash = (hash[j + 1] + m - hash[j]) % m;
                cur_hash = (cur_hash * p_pow[str.length() - j - 1]) % m;
                set.add(cur_hash);
            }
            counter += set.size();
        }

        return counter;
    }

}
