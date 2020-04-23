package NumberTheory.PrimeNumberGriesAndMisra;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(primeNumbers(100));

    }

    public static List<Integer> primeNumbers(int n) {

        List<Integer> primes = new ArrayList<>();

        int[] lp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (lp[i] == 0) {
                lp[i] = i;
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && primes.get(j) <= lp[i] && i * primes.get(j) <= n; j++)
                lp[i * primes.get(j)] = lp[i];
        }
        return primes;
    }

}
