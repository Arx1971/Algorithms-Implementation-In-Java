package StringManipulation.StringHashing;

public class Main {

    public static void main(String args[]) {

        System.out.println(computeStringHash("Megatron"));

    }

    public static long computeStringHash(String string) {
        long hash = 0;
        int prime = 31; // if string contains upper case and lowercase then 53 is a good choice, for lowercase only prime = 31
        int modulo = (int) (1e9 + 9);

        int p_pow = 1;

        for (int i = 0; i < string.length(); i++) {
            hash = (hash + (string.charAt(i) - 'a' + 1) * p_pow) % modulo;
            p_pow = (p_pow * prime) % modulo;
        }

        return hash;
    }

}
