package BinarySearch.FindFirstAndLastPositionOfElementInSortedArray;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(firstAndLastPositionOfTarget(new int[]{5, 7, 7, 8, 8, 10}, 8)));

    }

    public static int[] firstAndLastPositionOfTarget(int[] nums, int target) {
        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false);
        return new int[]{start, end};
    }

    public static int binarySearch(int[] nums, int target, boolean flag) {
        int index = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (flag) {
                    index = mid;
                    right = mid - 1;
                } else {
                    index = mid;
                    left = mid + 1;
                }
            } else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return index;
    }

}
