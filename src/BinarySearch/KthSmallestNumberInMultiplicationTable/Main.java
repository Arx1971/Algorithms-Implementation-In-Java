package BinarySearch.KthSmallestNumberInMultiplicationTable;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        System.out.println(new BinarySearchSolution().findKthNumber(30000, 30000, 3456));
        System.out.println(new BruteForceSolution().findKthNumber(30000, 30000, 3456));

    }

    public static class BruteForceSolution {

        /*
         *  @Time Complexity -> O(m * n * k * log(m))
         *  @Space Complexity -> O(K)
         * */

        public int findKthNumber(int m, int n, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (priorityQueue.size() == k) {
                        if (priorityQueue.peek() > i * j) {
                            priorityQueue.poll();
                            priorityQueue.add(i * j);
                        }
                    } else priorityQueue.add(i * j);
                }
            }
            return priorityQueue.peek();
        }

    }

    public static class BinarySearchSolution {

        /*
         * @Time Complexity -> O(m * log(mn))
         * @Space Complexity -> O(1)
         * */

        public boolean getCounter(int mid, int m, int n, int k) { // O(m)
            int counter = 0;
            for (int i = 1; i <= m; i++) {
                counter += Math.min(mid / i, n);
            }
            return counter >= k;
        }

        public int findKthNumber(int m, int n, int k) { // O(m * log(mn))
            int low = 1;
            int hi = m * n;

            while (low < hi) {
                int mid = low + (hi - low) / 2;
                if (getCounter(mid, m, n, k)) hi = mid;
                else low = mid + 1;
            }
            return low;
        }

    }

}
