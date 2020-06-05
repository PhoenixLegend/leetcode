/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 思路：
 * 1.用一个hash表把所有节点存起来，有相同的就返回。
 * 2.暴力法，挨个儿遍历找出相同的节点
 * 3.动动脑袋。双指针。
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headB == null || headA == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            // 长度不等且不相交，会陷入死循环
            //    a = a.next==null?headB:a.next;
            //    b = b.next==null?headA:b.next;
            // 但是判断当前值是否为null的话，可以在第二轮同时为null
            // 妙哉！
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
// @lc code=end
