import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 * 感觉上像是three sum这道题的变种。由一个确信的值，变成了一个比较的值
 * target 由 0 变成了 变量
 */

// @lc code=start
class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        int rs = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        if (nums.length < 3)
            return rs;
        int min = 2147483647;
        for (int i = 0; i <= nums.length - 2; i++) {
            int sum = target - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                // 为了表示谁更接近，应该用大的去减去小的
                // eg: -3 -2 -100 / 3 2 100
                if (nums[l] + nums[r] > sum) {
                    if (nums[l] + nums[r] - sum <= min) {
                        rs = nums[i] + nums[l] + nums[r];
                        min = nums[l] + nums[r] - sum;
                    }
                }
                if (nums[l] + nums[r] < sum) {
                    if (sum - nums[l] - nums[r] <= min) {
                        rs = nums[i] + nums[l] + nums[r];
                        min = sum - nums[l] - nums[r];
                    }
                }
                if (nums[l] + nums[r] == sum) {
                    rs = nums[i] + nums[l] + nums[r];
                    return rs;
                }
                // 相加太小就右移动，相加太大就左移动
                if (sum < nums[l] + nums[r]) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return rs;
    }
}
// @lc code=end
