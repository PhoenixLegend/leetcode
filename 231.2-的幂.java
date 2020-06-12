/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 * 1 2 4 8 16……
 * 0000 0010 0100 1000（除0之外，最多一个1）
 * 遇到1之前，一直右移
 * 移了n位，就让他判断是否和2的n次方是否相等（解法？）
 * 
 * 解法1：移位运算：把二进制数进行左右移位。左移1位，扩大2倍；右移1位，缩小2倍。 return (n>0) && (1<<30) % n == 0; 1<<30为int最大的2的整数幂
 * 解法2：&运算，同1则1。 return (n > 0) && (n & -n) == n; 负数取补码，取反末尾加1
 * 解法3：递归除以2，取余数是否为奇数
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (1 << 30) % n == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n == 1)
            return true;
        if (n == 0)
            return false;
        if (n % 2 != 0)
            return false;
        return isPowerOfTwo(n / 2);
    }
}
// @lc code=end
