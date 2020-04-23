package NumberTheory.IntegerFactorization;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(primeFactorsNaive(100));
        System.out.println(primeFactorsNaiveImprovised(100));
    }

    public static List<Integer> primeFactorsNaive(int n) {
        List<Integer> primeFactors = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }
        if (n > 1) primeFactors.add(n);
        return primeFactors;
    }

    public static List<Integer> primeFactorsNaiveImprovised(int n) {

        /*
         * This method will reduce the 50% number to check, all the even number will ignore.
         * */

        List<Integer> primeFactors = new ArrayList<>();

        if (n % 2 == 0) {
            while (n % 2 == 0) {
                primeFactors.add(2);
                n /= 2;
            }
        }
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }
        if (n > 1) primeFactors.add(n);

        return primeFactors;
    }

}
