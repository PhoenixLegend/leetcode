/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxlength = 0;
        int start = 0;
        if ("".equals(s)) {
            return "";
        }

        for (int r = 0; r < arr.length; r++) {
            for (int l = 0; l <= r; l++) {
                if (l == r) {
                    dp[l][r] = true;
                    if (r - l >= maxlength) {
                        maxlength = r - l + 1;
                        start = l;
                    }
                }
                if (r - l == 1 && arr[l] == arr[r]) {
                    dp[l][r] = true;
                    if (r - l >= maxlength) {
                        maxlength = r - l + 1;
                        start = l;
                    }
                }
                if (r - l > 1 && dp[l + 1][r - 1] && arr[l] == arr[r]) {
                    dp[l][r] = true;
                    if (r - l >= maxlength) {
                        maxlength = r - l + 1;
                        start = l;
                    }
                }
            }
        }
        return s.substring(start, start + maxlength);
    }
}
// @lc code=end

