package Array.PrefixSumQuery;

public class Main {

    public static void main(String[] args) {

        int[] prefixSum = getPrefixArray(new int[]{1, 2, 3, 4, 5});

        System.out.println(getQuerySum(prefixSum, 0, 3));
        System.out.println(getQuerySum(prefixSum, 0, 3));

    }

    public static int[] getPrefixArray(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }

    public static int getQuerySum(int[] prefixSum, int l, int r) {
        if (l == 0) return prefixSum[r];
        return prefixSum[r] - prefixSum[l - 1];
    }

}
