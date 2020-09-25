package SortingAlgorithms.MergeSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(mergeSort(new int[]{4, 56, 2, 3, 2, 1, 2, 43, 5, 34, 3})));

    }

    public static int[] mergeSort(int[] nums) {
        if (nums.length < 2) return nums;
        int[] left = Arrays.copyOfRange(nums, 0, nums.length / 2);
        int[] right = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
        mergeSort(left);
        mergeSort(right);
        return merge(nums, left, right);
    }

    public static int[] merge(int[] nums, int[] left, int[] right) {
        int i = 0, j = 0, index = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                nums[index++] = left[i++];
            } else if (right[j] < left[i]) {
                nums[index++] = right[j++];
            } else {
                nums[index++] = right[j++];
                nums[index++] = left[i++];
            }
        }

        while (i < left.length) {
            nums[index++] = left[i++];
        }

        while (j < right.length) {
            nums[index++] = right[j++];
        }
        return nums;
    }

}
