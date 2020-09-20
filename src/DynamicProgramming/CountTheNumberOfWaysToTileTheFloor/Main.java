package DynamicProgramming.CountTheNumberOfWaysToTileTheFloor;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(numberOfWaysTileNMFloor(5, 2));

    }

    public static long numberOfWaysTileNMFloor(int n, int m) {
        if (n < m) return 1;
        if (n == m) return 2;

        long mod = (long) (1e9 + 7);

        long[] dp = new long[n + 1];
        Arrays.fill(dp, 1);
        dp[m] = 2;
        dp[0] = 0;

        for (int i = m + 1; i <= n; i++) {
            dp[i] = ((dp[i - 1] % mod) + (dp[i - m] % mod)) % mod;
        }
        return dp[n];
    }

}
