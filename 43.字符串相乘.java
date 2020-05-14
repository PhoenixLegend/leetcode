/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 * 很明显最简单的方法，就是用代码模拟手算
 * 注意判0，直接返回0。遍历两数组相乘，再遍历相加
 * 但是可预见的麻烦，首先要处理单个相乘导致每一位的进位carry，还得处理最后相加的进位carry
 * 
 * --
 * 优化：可以先保留每一部分的乘积，最后再统一对10取模，相加的时候进位
 * --
 * 抖音上有一种算法：分治 - Karatsuba算法 麻烦不看了
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        String rs = "0";

        int[] tmp = new int[a.length * b.length];
        if (a[0] == 0 || b[0] == 0) {
            return rs;
        }
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                // 正序输入，倒序输出

            }
        }

        return rs;
    }
}
// @lc code=end
