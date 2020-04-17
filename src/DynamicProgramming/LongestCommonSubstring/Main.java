package DynamicProgramming.LongestCommonSubstring;

public class Main {

    public static void main(String args[]) {

        System.out.println(longestCommonSubstring("acvcd", "cvc"));

    }

    public static int longestCommonSubstring(String text, String pat) {

        int[][] dp = new int[text.length() + 1][pat.length() + 1];

        int ans = 0;

        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= pat.length(); j++) {

                if (text.charAt(i - 1) == pat.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(dp[i][j], ans);
                } else dp[i][j] = 0;

            }
        }
        return ans;
    }

}
