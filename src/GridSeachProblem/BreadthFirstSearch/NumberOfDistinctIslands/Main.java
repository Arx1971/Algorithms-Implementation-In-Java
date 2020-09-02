package GridSeachProblem.BreadthFirstSearch.NumberOfDistinctIslands;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        int[][] grid2 = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1}
        };

        System.out.println(numberOfDistinctIsland(grid));
        System.out.println(numberOfDistinctIsland(grid2));
    }

    public static int numberOfDistinctIsland(int[][] grid) {

        Set<String> numberOfDistinctIsland = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    String str = breadthFirstSearch(grid, i, j);
                    numberOfDistinctIsland.add(str);
                }
            }
        }

        return numberOfDistinctIsland.size();
    }

    public static String breadthFirstSearch(int[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        grid[row][col] = 0;
        String str = "X";

        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            int r = parent[0];
            int c = parent[1];
            if (isValid(grid, r + 1, c) && grid[r + 1][c] == 1) {
                queue.add(new int[]{r + 1, c});
                grid[r + 1][c] = 0;
                str += "D";
            }
            if (isValid(grid, r - 1, c) && grid[r - 1][c] == 1) {
                queue.add(new int[]{r - 1, c});
                grid[r - 1][c] = 0;
                str += "U";
            }
            if (isValid(grid, r, c + 1) && grid[r][c + 1] == 1) {
                queue.add(new int[]{r, c + 1});
                grid[r][c + 1] = 0;
                str += "R";
            }
            if (isValid(grid, r, c - 1) && grid[r][c - 1] == 1) {
                queue.add(new int[]{r, c - 1});
                grid[r][c - 1] = 0;
                str += "L";
            }
        }

        return str;
    }

    public static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static boolean isValid(int[][] gird, int row, int col) {
        return row >= 0 && row < gird.length && col >= 0 && col < gird[0].length;
    }

}
