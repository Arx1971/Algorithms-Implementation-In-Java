package SlidingWindow.SmallestClosestNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String args[]) {

        System.out.println(smallestClosestNumber(new int[]{1, 3, 0, 2, 5}));

    }

    public static List<Integer> smallestClosestNumber(int nums[]) {
        List<Integer> solution = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && stack.peek() >= nums[i])
                stack.pop();

            if (stack.isEmpty()) solution.add(-1);
            else solution.add(stack.peek());

            stack.push(nums[i]);
        }

        return solution;
    }

}
