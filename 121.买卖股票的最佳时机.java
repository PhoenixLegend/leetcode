/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 * 卖出价格需要大于买入价格
 * 没有交易完成, 最大利润为 0
 * 
 * 
 * 动态规划的思想：你昨天卖和今天卖的区别
 * 一维数组存储，当天卖出的最大利益。dp[i]
 * 一维数组存储，第i天卖出，前几天的最小值min[i] = min{min[i-1],price[i]}
 * 自底向上，全部记录。
 * 
 * 状态转移方程：
 * dp[i] = max{dp[i-1],prices[i]-min[i-1]}
 * 初始状态：
 * i = 0 return 0 dp[0] = 0 
 * i = 1 return   dp[1] = max{dp[0],prices[1]-min} min = price[0]
 * i = 2 return   dp[2] = max{dp[1],prices[2]-min} min = min{min,price[2]}
 * ……
 * i = i return   dp[i] = max{dp[i-1],prices[i]-min} min = min{min,price[i-1]}
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
}
// @lc code=end
