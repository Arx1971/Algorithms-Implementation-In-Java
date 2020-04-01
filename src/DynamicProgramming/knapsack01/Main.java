package DynamicProgramming.knapsack01;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {
        System.out.println(zeroOneKnapSack(new int[]{2, 3, 4, 5}, new int[]{1, 2, 5, 6}, 8, 4));
    }


    public static int zeroOneKnapSack(int[] weights, int[] profits, int w, int item) {

        int dp[][] = new int[item + 1][w + 1];

        for (int i = 1; i <= item; i++) {
            for (int j = 1; j <= w; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(profits[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else dp[i][j] = dp[i - 1][j];

            }
        }
        for (int i = 0; i < dp.length; i++)
            System.out.println(Arrays.toString(dp[i]));

        return dp[item][w];

    }


}
