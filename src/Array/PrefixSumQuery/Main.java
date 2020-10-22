package Array.PrefixSumQuery;

public class Main {

    public static void main(String[] args) {



    }

    public static class RangeQuery {

        private final int[] arr;

        public RangeQuery(int[] arr) {
            this.arr = arr;
        }

        public int[] getPrefixArray() {
            int[] prefixSum = new int[arr.length];
            prefixSum[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }
            return prefixSum;
        }

        public int getQuerySum(int[] prefixSum, int l, int r) {
            if (l == 0) return prefixSum[r];
            return prefixSum[r] - prefixSum[l - 1];
        }

    }
}
