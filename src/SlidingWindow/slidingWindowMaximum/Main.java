package SlidingWindow.slidingWindowMaximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String args[]) {

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();

        int[] solution = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (int i = k; i < nums.length; i++) {

            solution[i - k] = nums[deque.peekFirst()];

            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.removeFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.removeLast();

            deque.addLast(i);
        }

        solution[solution.length - 1] = nums[deque.peekFirst()];

        return solution;
    }

}
