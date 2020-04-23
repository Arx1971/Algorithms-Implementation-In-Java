package NumberTheory.SievePrime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(sievePrime(100));

    }

    public static List<Integer> sievePrime(int n) {

        boolean[] sievePrime = new boolean[n + 1];

        List<Integer> primes = new ArrayList<>();

        Arrays.fill(sievePrime, true);

        for (int i = 2; i <= n; i++) {
            if (sievePrime[i]) {
                primes.add(i);
                for (int j = i * i; j <= n; j += i) sievePrime[j] = false;
            }
        }
        return primes;
    }

}
