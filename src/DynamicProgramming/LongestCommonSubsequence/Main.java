package DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        System.out.println(longestCommonSubsequence(new int[]{6, 2, 5, 1, 7, 4, 8, 3}));

    }

    public static int longestCommonSubsequence(int[] arr) {

        int dp[] = new int[arr.length];

        dp[0] = 1;

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(dp[i], max);
            }
        }

        return max;
    }

}
