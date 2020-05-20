import sun.security.rsa.RSASignature;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 * 经典的动态规划问题
 * 根据第一阶的步数，可以爬一步也可以爬两步。
 * 到第N个阶梯的时候，等于第n-1的加一，也等于n-2的加二
 * dp(n) = dp(n-1)+1 || dp(n-2)+2
 * dp(3) = dp(2)+1 || dp(1)+2 = dp(2)+dp(1)
 * 
 * dp(1) = 1 
 * dp(2) = 2 
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // 为了设置数组坐标和阶梯一致，所以弃用0，改为从1开始赋值，故到n结束，长度为n+1
        int[] rs = new int[n + 1];
        rs[1] = 1;
        rs[2] = 2;
        for (int i = 3; i <= n; i++) {
            rs[i] = rs[i - 1] + rs[i - 2];
        }
        return rs[n];
        /**
         * 若直接递归返回如下： return climbStairs(n - 1) + climbStairs(n - 2); 会超时
         */
    }
}
// @lc code=end
