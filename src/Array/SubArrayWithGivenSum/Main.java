package Array.SubArrayWithGivenSum;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getRange(new int[]{1, 5, 2, 3, 7}, 10)));

    }

    public static int[] getRange(int[] nums, int target) {
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

        while (left < right) {
            sum -= nums[left++];
            if(sum == target) return Arrays.copyOfRange(nums, left, right);
        }

        return new int[]{-1, -1};
    }

}
