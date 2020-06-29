package StringManipulation.RabinKarpStringHashing;

public class Main {

    public static void main(String args[]) {

        System.out.println(rabinKarp("aaaaavvabcdef", "abc"));

    }

    public static int rabinKarp(String text, String pattern) {

        int pHash = 0;
        int tHash = 0;

        int prime = 231;

        for (int i = 0; i < pattern.length(); i++) {
            pHash += pattern.charAt(i) * Math.pow(prime, i);
            tHash += text.charAt(i) * Math.pow(prime, i);
        }

        for (int i = 1; i <= text.length() - pattern.length() + 1; i++) {
            if (tHash == pHash && pattern.equals(text.substring(i - 1, i + pattern.length() - 1)))
                return i - 1;
            if (i <= text.length() - pattern.length()) {
                tHash = (tHash - text.charAt(i - 1)) / prime;
                tHash += text.charAt(i + pattern.length() - 1) * Math.pow(prime, pattern.length() - 1);
            }
        }
        return -1;
    }

}
