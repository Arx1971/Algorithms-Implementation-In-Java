package SortingAlgorithms.SortIndexByIndexValues;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        indexSort(new int[]{6, 0, 8, 2, 1, 5});

    }

    public static Integer[] indexSort(int[] nums) {

        Integer[] indices = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) indices[i] = i;

        Arrays.sort(indices, (i, j) -> Integer.compare(nums[i], nums[j]));

        System.out.println(Arrays.toString(indices));

        return indices;
    }


}
