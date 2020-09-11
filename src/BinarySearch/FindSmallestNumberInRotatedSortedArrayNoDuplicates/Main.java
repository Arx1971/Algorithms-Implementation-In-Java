package BinarySearch.FindSmallestNumberInRotatedSortedArrayNoDuplicates;

public class Main {

    public static void main(String[] args) {

        System.out.println(findSmallestNumberInRotatedSortedArray(new int[]{6, 7, 8, 9, 1, 2, 3, 4}));

    }

    public static int findSmallestNumberInRotatedSortedArray(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }

        return nums[right];
    }

}
