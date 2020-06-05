import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } } 
 * 思路：
 * 1.使用一个hash表存储链表，如果遍历一遍直接由next == null则直接返回没有环 
 * 2.如果遍历一遍发现由next == 之前hash表的数据，返回有环
 * 如果空间复杂度设置为O(1)，则不能申请额外空间。
 * 和追及问题一致，只有有环，那么速度快的（一次前进两个节点一定能追上一次一个节点的指针） 快慢指针法
 */
class Solution {
    // 利用追击问题思路完成判别
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // 借用hash数据集合完成判别
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> list = new HashSet<>();
        ListNode curr = head;
        list.add(curr);
        while (curr.next != null) {
            if (list.contains(curr.next)) {
                return true;
            }
            curr = curr.next;
            list.add(curr);
        }
        return false;
    }
}

// @lc code=end
