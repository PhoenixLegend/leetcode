import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 * 看起来像是螺旋矩阵的逆过程，在已知序列的同时，反向给二维数组赋值
 */

// @lc code=start
class Solution {
    public static int[][] generateMatrix(int n) {
        int[][] rs = new int[n][n];
        if (n == 0) {
            return rs;
        }
        int length = n;// 宽
        int start = 0;
        // 上弹夹
        Stack nums = new Stack<Integer>();
        for (int i = n * n; i > 0; i--) {
            nums.push(i);
        }
        while (length > 0) {
            if (length == 1) {
                for (int e = start; e <= start + length - 1; e++) {
                    rs[start][e] = (int) nums.pop();
                }
                break;
            }
            // →
            for (int e = start; e <= start + length - 1; e++) {
                rs[start][e] = (int) nums.pop();
            }
            // ↓
            for (int e = start + 1; e < start + length; e++) {
                rs[e][start + length - 1] = (int) nums.pop();
            }
            // ←
            for (int e = start + length - 2; e >= start; e--) {
                rs[start + length - 1][e] = (int) nums.pop();
            }
            // ↑
            for (int e = start + length - 2; e > start; e--) {
                rs[e][start] = (int) nums.pop();
            }
            length -= 2;
            start += 1;
        }
        return rs;
    }

    public static void main(String[] args) {
        int a = 3;
        generateMatrix(a);
    }

}
// @lc code=end
