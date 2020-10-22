package Array.PrefixSumQuery;

public class Main {

    public static void main(String[] args) {

        System.out.println(new RangeQuery(new int[]{1, 2, 3, 4, 5}).getQuerySum(2, 3));
        System.out.println(new RangeQuery(new int[]{1, 2, 3, 4, 5}).getQuerySum(0, 4));
        
    }

    public static class RangeQuery {

        private final int[] prefixArray;

        public RangeQuery(int[] arr) {
            prefixArray = getPrefixArray(arr);
        }

        private int[] getPrefixArray(int[] arr) {
            int[] prefixSum = new int[arr.length];
            prefixSum[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }
            return prefixSum;
        }

        public int getQuerySum(int l, int r) {
            if (prefixArray.length == 0) return 0;
            if (l == 0) return prefixArray[r];
            return prefixArray[r] - prefixArray[l - 1];
        }

    }
}
