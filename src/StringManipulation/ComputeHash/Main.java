package StringManipulation.ComputeHash;

public class Main {

    public static void main(String args[]) {

        System.out.println(computeHash("abcdef"));

    }

    public static long computeHash(String str) {
        long hash = 0;

        int prime = 31;
        int m = (int) (1e9 + 9);
        int pPow = 1;

        for (int i = 0; i < str.length(); i++) {
            hash += ((str.charAt(i) - 'a' + 1) * pPow) % m;
            pPow = (prime * pPow) % m;
        }
        return hash;
    }
}
