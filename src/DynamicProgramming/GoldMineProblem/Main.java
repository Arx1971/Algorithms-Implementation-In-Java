package DynamicProgramming.GoldMineProblem;

public class Main {

    public static void main(String[] args) {
        int[][] mat = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};

        System.out.println(goldMine(mat));
        System.out.println(goldMine(new int[][]{
                {10, 33, 13, 15},
                {22, 21, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}}));
    }

    public static int goldMine(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            dp[i][col - 1] = matrix[i][col - 1];
        }

        for (int j = col - 2; j >= 0; j--) {
            for (int i = 0; i < row; i++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == row - 1) {
                    dp[i][j] = matrix[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.max(dp[i + 1][j + 1], Math.max(dp[i][j + 1], dp[i - 1][j + 1]));
                }
            }
        }
        int max = dp[0][0];
        for (int i = 1; i < row; i++) {
            max = Math.max(dp[i][0], max);
        }

        return max;
    }

}
