package BitManipulation.BasicsOperators;

public class Main {

    public static void main(String args[]) {
        System.out.println(bitwiseNot(5));
        System.out.println(bitwiseOr(2, 3));
    }

    public static int bitwiseNot(int number) {
        /** 5 -> 0101 -> 1010 -> -6 **/
        return ~number;
    }

    public static int bitwiseOr(int a, int b) {

        /**
         *  a = 2 = 0010
         *  b = 3 = 0011
         *  a | b = 0011 = 3
         * **/

        return a | b;
    }
}
