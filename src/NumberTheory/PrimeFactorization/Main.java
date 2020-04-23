package NumberTheory.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(primeFactorization(100));
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

    public static List<Integer> primeFactorization(int n) {

        List<Integer> primeFactors = new ArrayList<>();
        List<Integer> primes = primeNumbers((int) Math.sqrt(n + 1));

        for (Integer num : primes) {
            while (n % num == 0) {
                primeFactors.add(num);
                n /= num;
            }
        }
        if (n > 1) primeFactors.add(n);

        return primeFactors;
    }

}
