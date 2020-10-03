package DynamicProgramming.RodCuttingProblem;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(rodCutting(arr));
    }

    public static int rodCutting(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], prices[j] + dp[i - j - 1]);
            }
        }

        return dp[n];
    }

}
