/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 如果是两个节点的链表a->b->null的反转
 * a.next.next = a
 * a.next = null
 * 如果是三个节点的链表a->b->c->null 中分断链
 * a->b->null c->null
 * 反转：
 * b->a->null c->null
 * 合并，右边直接接左边遍历：
 * c.next = b
 * 节点增加也一样，归并方法[148].排序链表
 * 
 * ps：我看了题解才发现这个题其实很简单，直接两两递归传递就ok了
 */
class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode rs = head.next;
            head.next.next = head;
            head.next = null;
            return rs;
        }
        ListNode fast = head;
        ListNode slow = head;
        //length >= 3
        while (fast.next != null) {
            slow = slow.next;
            if (fast.next.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
        }
        //cut 断链操作
        ListNode right = slow.next;
        slow.next = null;
        ListNode left = head;
        return merge(reverseList(left), reverseList(right));
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode temp = right;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = left;
        return right;
    }
}
// @lc code=end
