package Matrix.GenerateMatrixWithUniqueRowAndColumnValue;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] matrix = uniqueMatrixRowAndColumn(4);

        System.out.println(Arrays.deepToString(matrix));

    }

    public static int[][] uniqueMatrixRowAndColumn(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int val = i + 1;
            for (int j = 0; j < n; j++) {
                if (val <= n) matrix[i][j] = val++;
                else {
                    val = 1;
                    matrix[i][j] = val++;
                }
            }
        }
        return matrix;
    }

}
