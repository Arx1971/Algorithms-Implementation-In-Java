package NumberTheory.BinaryExponentiation;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Linear().exponent(2, 3));
        System.out.println(new LogN().exponent(3, 14));
    }

    public static class Linear {

        // running time is O(e) where e is the exponent

        public int exponent(int b, int e) {
            int ans = 1;

            for (int i = 1; i <= e; i++) {
                ans *= b;
            }
            return ans;
        }
    }

    public static class LogN {

        // running time of this algorithm is log(b) where is the exponent

        public double exponent(double x, int n) {
            double result = 1;
            long posN = Math.abs((long) n);
            while (posN > 0) {
                if (posN % 2 == 1) result *= x;
                x *= x;
                posN /= 2;
            }
            return n < 0 ? 1 / result : result;
        }
    }

}
