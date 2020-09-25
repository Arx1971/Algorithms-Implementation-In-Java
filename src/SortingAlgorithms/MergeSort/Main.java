package SortingAlgorithms.MergeSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

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


        return nums;
    }

}
