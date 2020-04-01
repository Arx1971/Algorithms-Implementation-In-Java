package DynamicProgramming.CoinChnagePrintAllDenomination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(PrintAllDenominationOfCoin(new int[]{1, 3, 4}, 6));

    }

    public static List<Integer> PrintAllDenominationOfCoin(int[] coins, int target) {

        int dp[] = new int[target + 1];
        int coinDenomination[] = new int[target + 1];

        Arrays.fill(dp, target + 1);

        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] + 1 < dp[i]) {
                    dp[i] = dp[i - coins[j]] + 1;
                    coinDenomination[i] = coins[j];
                }
            }

        }

        List<Integer> list = new ArrayList<>();

        while (target > 0) {
            list.add(coinDenomination[target]);
            target -= coinDenomination[target];
        }

        return list;

    }

}
