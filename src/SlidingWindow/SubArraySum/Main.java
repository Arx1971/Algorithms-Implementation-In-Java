package SlidingWindow.SubArraySum;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        System.out.println(Arrays.toString(subArraySumEqualsToTarget(new int[]{2, 5}, 8)));

    }

    public static int[] subArraySumEqualsToTarget(int[] nums, int target) {

        int left = 0;
        int right = 1;
        int sum = nums[left];

        while (right < nums.length) {
            if (sum < target)
                sum += nums[right++];
            else sum -= nums[left++];

            if (sum == target)
                return Arrays.copyOfRange(nums, left, right);
        }

        return new int[]{-1, -1};

    }

}
