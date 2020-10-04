package DynamicProgramming.FriendPairingProblem;

public class Main {

    public static void main(String[] args) {
        System.out.println(countOfNumberFriendPairs(5));
    }

    public static long countOfNumberFriendPairs(int n) {

        if (n <= 2) return n;

        long mod = (long) 1e9 + 7;

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = ((dp[i - 1] % mod) + (((i - 1) % mod) * (dp[i - 2]) % mod)) % mod;
        }

        return dp[n];
    }

}
