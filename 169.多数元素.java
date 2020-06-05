import java.util.Arrays;
import java.util.Collection;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 * 同归于尽法（摩尔投票法）：
 * 很灵性，也是看讨论区的“诸国大混战”方法想到的思路。原来专有名词是摩尔投票法。
 * 大致思路就是尽可能让一个数组的数据量“消耗”到只有一个胜利者。
 * 怎么消耗呢？
 * 很灵性。设置一个count计数器（初始值为1）设我们每次都是两军交战1v1。遇到不同阵营的就同归于尽。
 * 那么nums[i]和nums[i+1]相同的话，count++。否则count(--)
 * 如果count再次为0，则说明交战的两边人数相同都同归于尽了,下一个兄弟自动入关等待对手。最后留下的count一定大于0.这个数就是众数
 * 
 * 排序法(直接就想到了)：
 * 先给数组排序，若一定存在多数元素，则中间那个一定时多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int soldier = nums[0];
        if (nums.length == 1) {
            return soldier;
        }
        for (int i = 1; i < nums.length; i++) {
            if (soldier != nums[i]) {
                count--;
                if (count == 0) {
                    soldier = nums[i + 1];
                }
            } else {
                count++;
            }
        }
        return soldier;
    }

    public int majorityElement_sort(int[] nums) {
        //手写冒泡排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums[nums.length / 2];
    }
}
// @lc code=end
