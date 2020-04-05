package StringManipulation.LongestPalindromicSubstring;

public class Main {

    public static void main(String args[]) {

        System.out.println(longestPalindromicSubstring("babacde"));

    }

    public static String longestPalindromicSubstring(String string) {

        int start = 0, end = 0;

        for (int i = 0; i < string.length(); i++) {

            int len = Math.max(expandPalindrome(string, i, i), expandPalindrome(string, i, i + 1));

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + (len) / 2;
            }

        }

        return string.substring(start, end + 1);
    }

    public static int expandPalindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
