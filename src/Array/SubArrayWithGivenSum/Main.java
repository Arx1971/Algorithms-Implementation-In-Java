package Array.SubArrayWithGivenSum;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getRange(new int[]{1, 5, 2, 3, 7}, 12)));

    }

    public static int[] getRange(int[] arr, int k) {
        int sum = 0;
        int i = 0;
        int j = 1;
        while (j < arr.length) {
            sum += arr[j];
            while (sum > k && i < j) {
                sum -= arr[i++];
            }
            if (sum == k) return new int[]{i + 1, j};
            j++;
        }

        System.out.println(sum);

        while (sum > k && i < j) {
            sum -= arr[i++];
            if (sum == k) return new int[]{i + 1, j};
        }
        return new int[]{-1, -1};
    }

}
