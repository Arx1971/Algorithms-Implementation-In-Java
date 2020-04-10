package DynamicProgramming.WildCardMatching;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(wildCardMatching("adcedb", "*a*b"));
        System.out.println(wildCardMatching("", "*"));
    }


    public static boolean wildCardMatching(String text, String pattern) {

        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i <= pattern.length(); i++) {
            if (pattern.charAt(i - 1) == '*' || pattern.charAt(i - 1) == '?') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        System.out.println(Arrays.toString(dp[0]));

        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j - 1];
                    if (!dp[i][j]) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // if any one of them is true then dp[i][j] = true;
                    }
                }

            }
        }

        for (int i = 0; i < dp.length; i++)
            System.out.println(Arrays.toString(dp[i]));


        return dp[text.length()][pattern.length()];

    }


}
