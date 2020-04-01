package DynamicProgramming.CoinChnage_II;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        System.out.println(NumberOrSolution(new int[]{1, 3, 4}, 5));

    }

    public static int NumberOrSolution(int coins[], int target) {

        int dp[] = new int[target + 1];

        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        return dp[target];

    }

}
