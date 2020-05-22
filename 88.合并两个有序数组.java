/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 * 首先会想到的思路是申请另一个copy nums1的数组，然后双指针比较nums1和nums2的头部，依次加入
 * 新的数组当中，然后赋值给nums1.
 * 之所以这样做是因为nums1本身前面是有序的，直接反应是害怕破坏nums1的结构。
 * 
 * 但是回过头看题目：假设 nums1 有足够的空间（空间大小大于或等于 m + n）
 * 结合示例可以想到，其实不需要申请额外的空间，从两个数组的m-1和n-1开始比谁大
 * 直接把比较的结果输出到nums1的后面（m+n-1
 * 
 */

// @lc code=start
class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;

        while (m > 0 && n > 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[pos] = nums1[m - 1];
                if (m > 0) {
                    m--;
                }
            } else {
                nums1[pos] = nums2[n - 1];
                if (n > 0) {
                    n--;
                }
            }
            pos--;
        }
        // 如果n已经遍历完了但是m还没有，由于m是有序的，直接不管了就ok。否则将n的数据塞进num1
        while (n > 0) {
            nums1[pos] = nums2[n - 1];
            n--;
            pos--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 5, 6, 0, 0, 0 };
        int[] nums2 = { 1, 2, 3 };
        merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
// @lc code=end
