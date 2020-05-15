/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 * 很明显最简单的方法，就是用代码模拟手算
 * 注意判0，直接返回0。遍历两数组相乘，再遍历相加
 * 但是可预见的麻烦是，处理单个相乘会导致每一位产生进位carry，最后相加还会产生进位carry
 * 
 * --
 * 优化：可以先保留每一部分的乘积，最后再统一对10取模，相加的时候进位
 * --
 * 抖音上有一种算法：分治 - Karatsuba算法 
 */

// @lc code=start
class Solution {
    public static String multiply(String num1, String num2) {
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        StringBuilder rs = new StringBuilder("0");
        int[] tmp = new int[a.length + b.length];
        if (a[0] == '0' || b[0] == '0') {
            return "0";
        }
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                // 正序输入
                int position = a.length + b.length - i - j - 2;
                tmp[position] = tmp[position]
                        + Integer.parseInt(String.valueOf(a[i])) * Integer.parseInt(String.valueOf(b[j]));
                ;
                int carry = tmp[position] / 10;
                tmp[position + 1] = tmp[position + 1] + carry;
                tmp[position] = tmp[position] % 10;
            }
        }
        // 倒序输出,并准备进位,去除首位可能为0的数据
        for (int out = tmp.length - 1; out >= 0; out--) {
            rs.append(tmp[out]);
        }
        // 正则 ^开始 符合0* 的全部换成 ""空字符串
        return rs.toString().replaceFirst("^0*", "");
    }

    public static void main(String[] args) {
        System.out.println(multiply("9127983", "9816238711231"));
    }
}
// @lc code=end
