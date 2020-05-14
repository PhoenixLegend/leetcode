import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 * 
 * 需要找出目标值，遍历的时间复杂度是O(n)。
 * 因此要利用旋转的升序数组来优化
 * 
 * 要求算法时间复杂度必须是 O(log n) 级别 
 * 需要“折半”才能有log级别的复杂度
 * 这里给出了提示，初步推测需要二分查找算法 binary-search
 * 
 * 1.数组一分为二 ，判断那边是有序那边是无序的（判定用子数组的头>尾）
 * 2.1 若有序，判断头和target大小，头<target<尾，换该子数组直接套娃。
 * 2.2 否则直接换另一个数组套娃
 * 由于升序，一次旋转的特性，必定至少存在一个子数组是有序的。
 * 
 */

// @lc code=start
class Solution {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
        if (nums.length == 1 && nums[0] != target) {
            return -1;
        }
        // 左有序
        if (nums[0] <= nums[nums.length / 2 - 1]) {
            // 且满足target范围
            if (nums[0] <= target && target <= nums[nums.length / 2 - 1]) {
                return search(Arrays.copyOfRange(nums, 0, nums.length / 2), target);
            }
            // 不满足则一定在右边
            else {
                if (search(Arrays.copyOfRange(nums, nums.length / 2, nums.length), target) == -1) {
                    return -1;
                }
                return nums.length / 2 + search(Arrays.copyOfRange(nums, nums.length / 2, nums.length), target);
            }
            // 右有序
        } else {
            // 且满足target范围
            if (nums[nums.length / 2] <= target && target <= nums[nums.length - 1]) {
                if (search(Arrays.copyOfRange(nums, nums.length / 2, nums.length), target) == -1) {
                    return -1;
                }
                return nums.length / 2 + search(Arrays.copyOfRange(nums, nums.length / 2, nums.length), target);
            }
            // 不满足则一定在左边
            else {
                return search(Arrays.copyOfRange(nums, 0, nums.length / 2), target);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 7, 8, 9, 1, 2, 6 };
        System.out.println(search(a, 5));
    }
}
// @lc code=end
