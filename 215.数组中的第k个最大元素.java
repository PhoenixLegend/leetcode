/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 * 思路，这个题目没什么思路，就是做一个倒序排序，然后取数组位。
 * 你可以手写一个冒泡，它可能不快，但是写出来最简单。
 * 也可以用快排，或者PriorityQueue维护一个大顶堆。
 * 后续感兴趣的可以接着写
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        int nums[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        findKthLargest(nums, 4);
    }

    public static int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums[k - 1];

    }
}
// @lc code=end
