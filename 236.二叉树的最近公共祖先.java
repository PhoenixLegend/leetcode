/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 分别递归左右子树
 * 1.若pq任一一个==root则返回root为LCA
 * 2.若root为空，则直接返回莫得LCA
 * 3.遍历的时候，注意，只要p和q分别在两边，那么此时的root就一定是LCA
 * （就这一点没想到，自己好好反思）
 * 236.共祖二叉树的最近公先.png 参考这个逻辑
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (p == root || q == root) {
            return root;
        } else if (lowestCommonAncestor(root.left, p, q) == null) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (lowestCommonAncestor(root.right, p, q) == null) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    /**
     * 根据解题思路可以直接得到上面的递归实现。重点就是把握了“我只要调用了那我就当此时的调用是一个结果”的思想
     * 但是结果超时，很明显因为递归使用太多了，可以把递归的值存下来。
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    /**
     * 这样可读性很好，但是分析各个if条件，结果还可以更优化，把多个if合并
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null || right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}

// @lc code=end
