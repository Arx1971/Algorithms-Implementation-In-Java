package GridSeachProblem.DepthFirstSearch.MaxAreaOfIsland;

public class Main {

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        int[][] grid2 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(grid2));
    }

    public static int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, backTrack(grid, i, j));
            }
        }

        return maxArea;
    }

    public static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int backTrack(int[][] grid, int row, int col) {

        if (!isValid(grid, row, col) || grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        int area = 1;

        for (int[] direction : directions) {
            area += backTrack(grid, row + direction[0], col + direction[1]);
        }
        return area;
    }

    public static boolean isValid(int[][] grid, int row, int col) {
        return ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length));
    }

}
