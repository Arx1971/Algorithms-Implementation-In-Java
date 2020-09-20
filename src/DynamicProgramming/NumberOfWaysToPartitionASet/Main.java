package DynamicProgramming.NumberOfWaysToPartitionASet;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(numberWayPartitionASet(i));
        }
    }

    public static int numberWayPartitionASet(int n) {

        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][i - 1];
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
        }
        return dp[n][0];
    }

}


/*
*
*
*  {1, 2, 3} -> Given a set of number's how many ways to split them.
             { {1}, {2}, {3} }
             { {1}, {2, 3} }
             { {2}, {1, 3} }
             { {3}, {1, 2} }
             { {1, 2, 3} }.
     given n = 3
     output = 5
* */