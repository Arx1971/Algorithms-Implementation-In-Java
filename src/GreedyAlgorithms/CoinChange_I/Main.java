package GreedyAlgorithms.CoinChange_I;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        System.out.println(CoinChange(new int[]{1, 3, 4}, 6));

    }

    public static int CoinChange(int[] coin, int target) {

        int dp[] = new int[target + 1];

        Arrays.fill(dp, target + 1);

        dp[0] = 0;

        for (int i = 1; i <= target; i++) {

            for (int j = 0; j < coin.length; j++) {

                if (i >= coin[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
                }

            }
        }

        return dp[target] == target + 1 ? -1 : dp[target];

    }

}
