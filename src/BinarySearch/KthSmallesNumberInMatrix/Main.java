package BinarySearch.KthSmallesNumberInMatrix;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{2, 7, 8, 9}, {5, 9, 10, 11}, {8, 9, 10, 15}, {9, 15, 20, 24}};
        System.out.println(new BruteForceSolution().KthSmallestElementInMatrix(matrix, 10));
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

}
