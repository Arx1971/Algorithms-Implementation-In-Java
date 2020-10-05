package DynamicProgramming.CountNumbersOfWayToCoverADistance;

public class Main {

    public static void main(String[] args) {

        System.out.println(countDistance(600));
        System.out.println(countDistance(3));

    }

    public static long countDistance(int n) {
        long mod = (long) 1e9 + 7;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = ((dp[i - 1] % mod) + (dp[i - 2] % mod) + (dp[i - 3] % mod)) % mod;
        }

        return dp[n];
    }

}
