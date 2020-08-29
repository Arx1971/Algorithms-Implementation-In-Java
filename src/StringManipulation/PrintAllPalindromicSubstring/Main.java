package StringManipulation.PrintAllPalindromicSubstring;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(BruteForce.printAllPalindromicSubstring("abcbc"));

    }


    public static class BruteForce {
        public static List<String> printAllPalindromicSubstring(String str) {
            List<String> allPalindromicSubstring = new ArrayList<>();

            for (int i = 0; i < str.length(); i++) {
                getLength(str, i, i, allPalindromicSubstring);
                getLength(str, i, i + 1, allPalindromicSubstring);
            }
            return allPalindromicSubstring;
        }

        public static List<String> getLength(String str, int i, int j, List<String> palindromes) {

            while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
                palindromes.add(str.substring(i, j + 1));
                i--;
                j++;
            }
            return palindromes;
        }
    }

}
