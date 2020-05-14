import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 * 先排个序，然后 i 遍历，从左到右
 * 接着 i+1 设为l 末尾设为r 
 * 夹逼 l++,r-- 等到arr[t] = -(arr[l]+arr[r])
 * 若arr[l] = arr[l+1] 或者 arr[r] = arr[r-1] 则直接跳过
 */

// @lc code=start
class Solution_done {
    public static List<List<Integer>> threeSum(int[] nums) {
        // 用set保存结果以避免重复的三元组
        Set<List<Integer>> rs = new LinkedHashSet<>();
        Arrays.sort(nums);
        if (nums.length < 3)
            return new ArrayList<>(rs);
        if (nums[0] > 0 || nums[nums.length - 1] < 0)
            return new ArrayList<>(rs);
        for (int i = 0; i <= nums.length - 2; i++) {
            int sum = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    rs.add(Arrays.asList(nums[i], nums[l], nums[r]));
                }
                // 相加太小就右移动，相加太大就左移动
                if (sum < nums[l] + nums[r]) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return new ArrayList<>(rs);
    }

    public static void main(String[] args) {
        int[] b = { -2, 0, 1, 1, 2 };
        int[] a = { 0, 0, 0, 0, 0 };
        List<List<Integer>> rs = threeSum(b);
        for (List<Integer> x : rs) {
            System.out.println(x);
        }
        // int[] c = new int[1];
        // if (c[0] == 0) {
        // System.out.println("0");
        // }
    }

}
// @lc code=end
