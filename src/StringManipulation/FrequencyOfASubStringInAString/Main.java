package StringManipulation.FrequencyOfASubStringInAString;

public class Main {

    public static void main(String args[]) {

        System.out.println(frequencyOfASubStringInAString("abcdabcdabc", "cd"));

    }

    public static int frequencyOfASubStringInAString(String text, String pattern) {

        int[] pi = computePrefixPiTable(pattern + "#" + text);

        int count = 0;

        for (int i = pattern.length(); i < pi.length; i++)
            if (pi[i] == pattern.length())
                count++;

        return count;
    }

    public static int[] computePrefixPiTable(String pattern) {

        int[] pi = new int[pattern.length()];

        int i = 0;
        int j = 1;

        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[j] = i + 1;
                i++;
                j++;
            } else if (pattern.charAt(i) != pattern.charAt(j) && i > 0) {
                i = pi[i - 1];
            } else if (pattern.charAt(i) != pattern.charAt(j) && i == 0) {
                pi[j] = 0;
                j++;
            }
        }
        return pi;
    }

}
