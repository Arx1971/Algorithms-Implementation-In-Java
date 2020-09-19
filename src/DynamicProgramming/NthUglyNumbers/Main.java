package DynamicProgramming.NthUglyNumbers;

public class Main {

    public static void main(String[] args) {

        System.out.println(getNthUglyNo(10));

    }


    public static long getNthUglyNo(int n) {

        long[] dp = new long[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (dp[i] == dp[i2] * 2) i2++;
            if (dp[i] == dp[i3] * 3) i3++;
            if (dp[i] == dp[i5] * 5) i5++;
        }

        return dp[n - 1];
    }

}
