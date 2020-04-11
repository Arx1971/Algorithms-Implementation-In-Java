package DynamicProgramming.PalindromePartitioning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public static int minCut(String string) {
        int dp[] = new int[string.length()];
        for (int i = 0; i < string.length(); i++)
            dp[i] = i;

        for (int i = 1; i < string.length(); i++) {
            for (int start = i, end = i; start >= 0 && end < string.length() && string.charAt(start) == string.charAt(end); end++, start--) {
                int cutPoint = 0;
                if (start != 0) cutPoint = dp[start - 1] + 1;
                dp[end] = Math.min(cutPoint, dp[end]);
            }
            for (int start = i - 1, end = i; start >= 0 && end < string.length() && string.charAt(start) == string.charAt(end); end++, start--) {
                int cutPoint = 0;
                if (start != 0) cutPoint = dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], cutPoint);
            }
        }

        return dp[dp.length - 1];

    }

}