package NumberTheory.LeastCommonMultiple;

public class Main {

    public static void main(String args[]) {

        System.out.println(lcm(10, 15));

    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

}
