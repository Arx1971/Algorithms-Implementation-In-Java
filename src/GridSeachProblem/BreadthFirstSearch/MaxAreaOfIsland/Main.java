package GridSeachProblem.BreadthFirstSearch.MaxAreaOfIsland;


import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        int[][] grid2 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(grid2));

    }

    public static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxAreaOfAIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxAreaOfAIsland = Math.max(maxAreaOfAIsland, areaOfAIsland(grid, i, j));
                }
            }
        }
        return maxAreaOfAIsland;
    }

    public static int areaOfAIsland(int[][] grid, int row, int col) {

        int maxArea = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = 0;

        while (!queue.isEmpty()) {
            maxArea++;
            int[] parent = queue.poll();
            for (int[] dir : directions) {
                int r = dir[0] + parent[0];
                int c = dir[1] + parent[1];
                if (isValid(grid, r, c) && grid[r][c] == 1) {
                    grid[r][c] = 0;
                    queue.add(new int[]{r, c});
                }
            }
        }
        return maxArea;
    }
}
