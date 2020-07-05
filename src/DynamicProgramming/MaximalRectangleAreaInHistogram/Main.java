package DynamicProgramming.MaximalRectangleAreaInHistogram;

import java.util.Stack;

public class Main {

    public static void main(String args[]) {

        System.out.println(getMaxAreaInHistogram(new int[]{1, 0, 1, 1, 1}));

    }

    public static int getMaxAreaInHistogram(int[] nums) {
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            while (stack.peek() != -1 && current <= nums[stack.peek()]) {
                int height = nums[stack.pop()];
                int width = i - stack.peek() - 1;
                area = Math.max(area, height * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = nums[stack.pop()];
            int width = nums.length - stack.peek() - 1;
            area = Math.max(area, height * width);
        }

        return area;
    }

}
