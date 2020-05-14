/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 * 首先，这是一个排序数组，默认是升序。
 * 其次，不能使用额外的数据空间，这决定我们不能new一个新的array变量。
 * 
 * 看起来我们会陷入一个误区，不让我用新的数组，那我的结果只能存在原数组里。但是数组由没有列表那样有remove/add之类的操作。
 * 似乎是无法做到的。
 * 
 * 再次读题：“你不需要考虑数组中'超出新长度'后面的元素。” 以及 “根据你的函数返回的长度, 它会打印出数组中该'长度范围内'的所有元素。”
 * 这句话其实已经给出了提示，我们只需要交换数组内的元素位置就可以了。
 * 比如：[0,0,1,3] -> [0,1,3,0]
 * 这样返回长度3的时候，数组打印只会返回前三个不重复的元素。
 * 所以问题就由“删除”重复项转换为 把不重复的全部“挪”到数组前端
 * 
 * 设置两个指针，第一个指针遍历，第二个指针在往后比较是否与第一个相同
 * 相同跳过，不相同就交换位置
 * 
 * 由于是有序的，所有最后交换完的不重复子数列也是有序的，由“拐点”即可判出“新长度”
 * 
 * ps:注意双指针常遇到的数组越界问题
 * 
 */

// @lc code=start
class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 0; i <= nums.length - 2; i++) {
            int swap = i + 1;
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] == nums[j]) {
                    continue;
                } else {
                    int temp = nums[j];
                    nums[j] = nums[swap];
                    nums[swap] = temp;
                    swap++;
                }
            }
        }
        // 有序的作用体现在这里，由于每次都是交换，可以很明显判断出“折点”的位置就是重复和非重复的交点
        // 0 1 2 3 1 2 “拐点”在3
        for (int l = 0; l <= nums.length - 2; l++) {
            if (nums[l] >= nums[l + 1]) {
                return l + 1;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] a = { 0, 2 };
        System.out.println(removeDuplicates(a));
    }
}
// @lc code=end
