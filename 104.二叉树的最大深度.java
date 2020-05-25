/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 不要使用全局变量，否则leetcode会判不通过。后者先声明全局变量，然后再方法里面初始化。
 */
class Solution {
    static int max;

    public static void main(String[] args) {
        max = 0;
        int curr = 0;
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        preorder(root, curr);
        System.out.println(max);

    }

    public static void preorder(TreeNode root, int curr) {
        if (root == null) {
            max = curr > max ? curr : max;
            return;
        }
        curr++;
        preorder(root.left, curr);
        preorder(root.right, curr);
        curr--;
    }
}
// @lc code=end
