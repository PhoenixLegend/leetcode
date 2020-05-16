/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 * 分治 DP 
 * 分治算法通常遵守一种通用模式：即：在解决规模为n的问题时，总是先递归地求解a个规模为n/b的子问题，然后再将子问题的解合并起来
 * 1.划分问题：整个问题划分成多个无关联的子问题。
 * 2.递归求解：递归调用求解各个子问题。
   3.合并问题：合并子问题的解，形成原始问题的解

   分治法 —— 各子问题独立；动态规划 —— 各子问题重叠

   回到该题：（还是动态规划比较明显）
   题目要求找出连续的子数组。max 需要表示为 以i开头的最大子数组之和，每次保留最大的值，和当前的值

   中心思想在于：只要我们在一起是正数，那就说明对整体有增益。可以试着保留往后合并。同时比较当前的max，看是否需要更换。
 */

// @lc code=start
class Solution {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            // 先判断当前集合是不是大于0，大于0就对团体有益。否则直接抛弃
            if (curr > 0) {
                curr = curr + nums[i];
            } else {
                curr = nums[i];
            }
            max = Math.max(curr, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println(maxSubArray(nums));
    }
}
// @lc code=end
