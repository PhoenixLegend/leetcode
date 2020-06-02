/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 * 思路：同141题不一样的是，142题需要返回环的入口点（别被题目所误导，结果是返回listNode）
 * 如果沿用141的追击问题思路，141题判定是环的情况是当slow追上了fast的时候，而追上的点并不
 * 代表这个点就是入口点。因此142题需要另外找到一种数学方法，用已知条件： 1.slow的位置和经过距离 slow的移动速度为1
 * 2.fast的位置和经过距离 fast的移动速度为2
 * 
 * 首先我们假设二者从同一起点开始进入环s长度（即没有入环之前的单程线）：
 * 由于fast的速度始终是slow的2倍，当slow到环一半的时候，fast已经回到起点
 * slow回到起点时，fast刚好比slow多跑一圈，二者在起点相遇。
 * 用公式表示为：fast出发的那一刻（还没有出发），它就需要追一个s长度的距离，才能碰到slow 相遇时间为t：则 2t -t = s => t = s
 * 此时slow跑了一个 1 * t = 1 * s = s 即一圈的长度。
 * 
 * 其次我们引入入环值之前的单程线，长度为d： 由于fast的速度始终是slow的2倍，当slow入环的时候，fast已经跑了2d的长度
 * 也就意味着slow从环起点开始的时候，fast在环内已经跑了一个d的长度。
 * 用公式表示为：从slow入环开始，fast出发的那一刻（还没有出发），它就需要追一个s-d的长度，才能碰到slow 相遇时间为t：则 2t -t =
 * s-d => t = s-d 此时slow跑了一个 1 * t = 1 * (s - d) = s - d的长度。 换言之，此时二者相遇的位置在起点往后
 * s - (s - d) = d的长度，与最开始的起点到环入口的距离一致。
 * 
 * ∴ 环的入口 => 二者相遇的位置距离环入口点的距离.next(持续d次) = 起点到环入口点的位置.next(持续d次)
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode comeonbaby = head;
        while (fast != null) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                // 此时相遇了，用slow或者fast的位置走next,一定能碰到起点走next
                while (slow != comeonbaby) {
                    slow = slow.next;
                    comeonbaby = comeonbaby.next;
                }
                return comeonbaby;
            }
        }
        return null;
    }
}
// @lc code=end
