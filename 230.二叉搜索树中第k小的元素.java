import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 1.遍历，放入一个小顶堆，然后取数
 2.遍历的话，基于二叉搜索树的特性，左节点<根节点<右节点 那通过中序排序就可以直接输升序的排列
 3.那还做个锤子小顶堆啊
 4.任何递归都可以改为迭代。所以该题有两种解法
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> rs = new ArrayList<>();
        track(root, rs);
        return rs.get(k - 1);
    }

    public static void track(TreeNode root, ArrayList<Integer> rs) {
        while (root == null) {
            return;
        }
        track(root.left, rs);
        rs.add(root.val);
        track(root.right, rs);
    }
}