import java.util.HashMap;

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } } 思路，我会首先想到，移动k位其实是个幌子，因为事实上你只能移动 k%链表长度
 * 个位数 其次，可以先将单链表首尾相连，然后找到移动后的首尾位，再拆开。得到预期结果。
 * 
 * 1.首尾相连：最后一个node.next = 第一个node 2.首尾分拆：第一个node给返回值，最后一个node.next = null
 */
class Solution {
    public static ListNode rotateRight(ListNode head, int k) {
        HashMap<Integer, ListNode> nodes = new HashMap<>();
        int i = 1;
        ListNode visit = new ListNode(-1);
        visit = head;
        // visit 为空 和 1 单独处理直接返回原值
        if (visit == null || visit.next == null) {
            return head;
        }
        while (visit != null) {
            nodes.put(i, visit);
            visit = visit.next;
            i++;
        }
        nodes.get(nodes.size()).next = nodes.get(1);
        int pos = nodes.size() - k % nodes.size() + 1;
        visit = nodes.get(pos - 1).next;
        // 拆开
        nodes.get(pos - 1).next = null;

        return visit;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        // head.next.next = new ListNode(2);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        rotateRight(head, 0);
    }
}
// @lc code=end
