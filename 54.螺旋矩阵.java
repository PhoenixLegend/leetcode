import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *simulate. It's always best to run the simulation on edge cases like a single column or a single row to see if anything breaks or not.
 * [54] 螺旋矩阵
 * 这种的题目和大数相乘（字符串相乘）的思路是一样的。都是模拟运算，通过代码去模拟实现手算的过程。
1.如何遍历第一遍。走一遍外圈。
2.走了一遍外圈之后，如何沿用第一步的方式再走一遍内圈。（如果有内圈的话）
  我这里用的方法是设置一个起始位start，每走一次外圈，start就加1。同时为了保证圈每次走的圈都不会重复，
  圈的高和宽也同理需要减2。
3.如何设置边缘场景。题目的提示3给出了这样的提示，一定要注意单行或者单列的情况。如果一时间想不到如何实现
  先画一下，然后创建边缘场景debug一下是比较好的方法。
 */

// @lc code=start
class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rs = new ArrayList<>();
        if (matrix.length == 0) {
            return rs;
        }
        int length = matrix[0].length;// 宽
        int size = matrix.length; // 高
        int start = 0;
        while (size > 0 && length > 0) {
            if (size == 1) {
                for (int e = start; e <= start + length - 1; e++) {
                    rs.add(matrix[start][e]);
                }
                break;
            }
            if (length == 1) {
                for (int e = start; e <= start + size - 1; e++) {
                    rs.add(matrix[e][start]);
                }
                break;
            }
            // →
            for (int e = start; e <= start + length - 1; e++) {
                rs.add(matrix[start][e]);
            }
            // ↓
            for (int e = start + 1; e < start + size; e++) {
                rs.add(matrix[e][start + length - 1]);
            }
            // ←
            for (int e = start + length - 2; e >= start; e--) {
                rs.add(matrix[start + size - 1][e]);
            }
            // ↑
            for (int e = start + size - 2; e > start; e--) {
                rs.add(matrix[e][start]);
            }
            length -= 2;
            size -= 2;
            start += 1;
        }
        return rs;
    }

    public static void main(String[] args) {
        int[][] matri2 = { { 7 }, { 9 }, { 6 } };
        int[][] matrix2 = { { 7, 8, 9 } };
        int[][] matrix = { { 6, 7 }, { 10, 11 } };
        System.out.println(spiralOrder(matrix));
    }

}
// @lc code=end
