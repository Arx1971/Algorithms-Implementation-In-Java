package StringManipulation.LongestPrefixEqualToSuffix;

public class Main {

    public static void main(String[] args) {

        System.out.println(longestPrefixEqualToSuffix("aaaaaad"));
        System.out.println(longestPrefixEqualToSuffix("abcdabc"));
        System.out.println(longestPrefixEqualToSuffix("abcdefghtabc"));
    }

    public static String longestPrefixEqualToSuffix(String str) {

        int[] pi = new int[str.length()];

        int i = 0, j = 1;

        while (j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                pi[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    pi[j] = 0;
                    j++;
                } else {
                    i = pi[i - 1];
                }
            }
        }
        return str.substring(0, pi[pi.length - 1]).length() == 0 ? "No Solution Found": str.substring(0, pi[pi.length - 1]);
    }

}
