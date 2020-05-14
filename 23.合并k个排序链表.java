import java.util.List;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } } 和双链表排序逻辑一样，该题增加的部分是如何比较K个链表的表头大小。
 * 用普通的办法去比较就需要排序，这样会徒增时间复杂度。 因此其实把这个问题就转变为两个类型问题： 1.如何对k个数据进行排序，且k个数据会不断进出
 * 2.递归操作单向链表
 * 
 * 前者可以使用小顶堆，进出，排序都方便 后者沿用21的逻辑骨架，递归或者迭代
 * 
 * 值得一提的是，java本身并没有heap这个数据类型（自己实现不算） 取而代之的是PriorityQueue（优先队列）
 * 实际上是一个堆（不指定Comparator时默认为最小堆） 1.不允许使用 null 元素(add的时候要判空)。
 * 2.插入方法（offer()、poll()、remove() 、add() 方法）时间复杂度为O(log(n))
 * pps:PriorityQueue只能保证数组的第一个元素是最小/大的。
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                // 小顶堆
                return o1.val - o2.val;
            }
        });
        ListNode rs = new ListNode(0);
        // 这里很重要，需要一个临时背锅侠，否则会被新数据给顶掉
        ListNode curr = rs;
        if (lists.length == 0) {
            return null;
        }
        // 把表头都先加进去
        for (ListNode listNode : lists) {
            if (listNode != null)
                queue.add(listNode);
        }
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            curr.next = temp;
            curr = curr.next;
            if (temp.next != null) {
                queue.add(temp.next);
            }
        }
        return rs.next;
    }
}
// @lc code=end
