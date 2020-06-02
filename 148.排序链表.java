/**
 * [148] 排序链表
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } } 
 * 线性排列当中，时间复杂度能达到O(n log n)的只有归并和快排
 * 1.找到链表的中点：
 * 单向链表要找到中间位置可以使用快慢指针的方法，快二倍的指针指到头的时候，慢指针的位置就是中点位置。
 * 2.如何断链：
 * 链表里操作最难掌握的应该就是各种断链啊，然后再挂接啊。在合并之前一定保证left和right的两个链表是“断干净”了的，否则会生成循环链表。
 * 3.如何归并：
 * 在[21]题当中已经掌握了两个有序链表的合并，因此直接重写一遍merge代码即可
 */
class Solution {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            //cut 断链操作
            ListNode right = head.next;
            head.next = null;
            ListNode left = head;
            return mergeTwoLists(left, right);
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

        return mergeTwoLists(sortList(left), sortList(right));

    }

    /**
     * 将有两个已经有序排列的链表合并 [21]题
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        // 这里很重要，需要一个临时背锅侠，否则会被新数据给顶掉
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        sortList(head);
    }
}
// @lc code=end
