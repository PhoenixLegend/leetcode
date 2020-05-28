import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 读题：路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点 思路，我们可以把每一次路径的计算理想化为一个小三角 1 2 3 ab
 * 2到1再到3是一个路径curr; 2到1再到1的父节点是一个路径a; 3到1到1的父节点也是一个路径b
 * 如果选择curr,则说明1是没有父节点的或者curr本身就为最大路径和
 * 如果选择max(a,b)，则将123三个点“缩小”为一个叶子节点x，然后1的父节点继续套娃。 4 x 5 然后重复之前的套路。 每次保留一个路径的最大值。
 * 但是递归的时候，代码的执行和编写时两个方向，计算的时候时从叶子节点算，代码进入的顺序是从根节点入手。再返回递归值参与计算。
 * ps:二叉树的每一个点都是一个节点，读题很重要（之前看成了从一个叶子节点到另一个叶子节点才算做路径）
 */
class Solution {
    static int max;

    public static int maxPathSum(TreeNode root) {
        max = root.val;
        int curr = returnVal(root);
        return Math.max(max, curr);

    }

    public static int returnVal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         * 这里可以优化为 maxleft = Math.max(returnVal(root.left), 0); 因为如果子树是小于0的，那么加起来只会拖累父节点
         */
        int left = returnVal(root.left);
        int right = returnVal(root.right);
        int subtree = root.val + left + right;
        int maxsubpath = Math.max(root.val + left, root.val + right);
        // 比较max和当前子树的所有可能路径:根节点，左路径，右路径，左叶到右叶(左叶，右叶在下一个根节点迭代比较)
        max = Math.max(Math.max(subtree, maxsubpath), Math.max(root.val, max));

        return Math.max(root.val, maxsubpath);
    }
}
// @lc code=end