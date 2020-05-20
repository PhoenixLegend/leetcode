import java.util.ArrayList;

/**
 * 1.java的基本数据类型是传值调用，对象引用类型是传引用。
 * 
 * 2.当传值调用时，改变的是形参的值，并没有改变实参的值，实参的值可以传递给形参，但是，这个传递是单向的，形参不能传递回实参。
 * 
 * 3.当引用调用时，如果参数是对象，无论对对象做了何种操作，都不会改变实参对象的引用，但是如果改变了对象的内容，就会改变实参对象的内容。
 * 
 * 数学：m行，n列，m<n，所以一共需要走的步数是m+n,概率相当于在其中选择n-1种排列 回溯法：41结果超时，[51,9]。 动态规划：dp[i][j]
 * = dp[i-1][j] + dp[i][j-1] dp[i][j] 是到达 i, j 最多路径
 * 
 */

class Solution {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(uniquePaths(51, 9));
    }

    public static int uniquePath(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        // 抵在上面只能向下
        for (int e = 0; e < m; e++)
            dp[e][0] = 1;
        // 抵在左面只能向右
        for (int e = 1; e < n; e++)
            dp[0][e] = 1;
        // 自底向上，备忘录记录所有的可能路径。空间换时间
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        backtrack(m, n);
        return count;
    }

    public static void backtrack(int m, int n) {
        if (m == 1 || n == 1) {
            count++;
            return;
        }
        m--;
        backtrack(m, n);
        m++;
        n--;
        backtrack(m, n);
        n++;
    }
}