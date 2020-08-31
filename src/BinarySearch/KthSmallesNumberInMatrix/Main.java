package BinarySearch.KthSmallesNumberInMatrix;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{2, 7, 8, 9}, {5, 9, 10, 11}, {8, 9, 10, 15}, {9, 15, 20, 24}};
        System.out.println(new BruteForceSolution().KthSmallestElementInMatrix(matrix, 10));
        System.out.println(new BinarySearch().KthSmallestElementInMatrix(matrix, 10));
    }

    public static class BruteForceSolution {

        public int KthSmallestElementInMatrix(int[][] matrix, int k) {

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (priorityQueue.size() == k) {
                        if (priorityQueue.peek() > k) {
                            priorityQueue.poll();
                            priorityQueue.add(matrix[i][j]);
                        }
                    } else priorityQueue.add(matrix[i][j]);
                }
            }
            return priorityQueue.peek();
        }

    }

    public static class BinarySearch {

        public int KthSmallestElementInMatrix(int[][] matrix, int k) {
            int low = matrix[0][0];
            int hi = matrix[matrix.length - 1][matrix[0].length - 1];
            while (low < hi) {
                int mid = low + (hi - low) / 2;
                if (getSmallerOrEqualToTheNumber(matrix, mid) < k) low = mid + 1;
                else hi = mid;
            }
            return low;
        }

        public int getSmallerOrEqualToTheNumber(int[][] matrix, int target) {
            int counter = 0, i = matrix.length - 1, j = 0;
            while (i >= 0 && j < matrix[0].length) {
                if (matrix[i][j] > target) i--;
                else {
                    counter += i + 1;
                    j++;
                }
            }
            return counter;
        }
    }
}
