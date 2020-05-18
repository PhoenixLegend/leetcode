import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *simulate. It's always best to run the simulation on edge cases like a single column or a single row to see if anything breaks or not.
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rs = new ArrayList<>();
        if (matrix.length == 0) {
            return rs;
        }
        int length = matrix[0].length;// 宽
        int size = matrix.length; // 高
        int start = 0;
        while (size > 0) {
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
                rs.add(matrix[e][length - 1]);
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
