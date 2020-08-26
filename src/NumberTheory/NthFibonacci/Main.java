package NumberTheory.NthFibonacci;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i <= 92; i++) {
            System.out.println(NthFibonacci(i));
        }

    }

    public static long NthFibonacci(int n) {
        long nthFib = 0;
        double phiPos = ((1 + Math.sqrt(5)) / 2);
        double phiNeg = ((1 - Math.sqrt(5)) / 2);
        double powPhiPos = Math.pow(phiPos, n);
        /*double powPhiNeg = Math.pow(phiNeg, n);

        System.out.println(((powPhiPos - powPhiNeg) / Math.sqrt(5)));*/

        nthFib = (long) Math.round(((powPhiPos) / Math.sqrt(5)));

        return nthFib;
    }

}
