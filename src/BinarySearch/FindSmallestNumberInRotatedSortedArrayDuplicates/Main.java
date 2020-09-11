package BinarySearch.FindSmallestNumberInRotatedSortedArrayDuplicates;

public class Main {

    public static void main(String[] args) {

        System.out.println(FindSmallestNumberInRotatedSortedArrayDuplicates(new int[]{6, 7, 0, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5})); // duplicates

    }

    public static int FindSmallestNumberInRotatedSortedArrayDuplicates(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[right]) right--;
            else if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[right];
    }

}
