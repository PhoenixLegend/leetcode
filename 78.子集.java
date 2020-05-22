import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 * 两个思路:
 * 1.递归
 * 首先想到，nums的子集个数可以转换为：之前的子集，和逐次加入的数字和之前的子集合并的和。
 * eg：
 * 1 子集为1
 * 1，2 子集为之前的 1 ，新加入的 2，新加入的和之前的子集组合的(1，2)
 * 1，2，3 子集为之前1,2,(1,2) 和新加入的3，新加入的和之前的子集组合的(1,3),(2,3),(1,2,3)
 * 后续的同理(这里)
 * 
 * 2.回溯(全排列那一题的思路一致),后面可以考虑去实现一下
 * eg:输入为1，2，3
 * 假定子集的长度递增
 * 长度的1的时候，1??,?2?,??3
 * 长度为2的时候，12?,1?3,?23
 * 长度为3的时候，123
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rs = new ArrayList();
        rs.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : rs) {
                List<Integer> temp = new ArrayList(curr);
                temp.add(num);
                newSubsets.add(temp);
                /**
                 * 匿名类的写法： newSubsets.add(new ArrayList<Integer>(curr) {{add(num);}});
                 * List<Integer> newList = new ArrayList<>(oldList);
                 */
            }
            for (List<Integer> curr : newSubsets) {
                rs.add(curr);
            }
        }
        return rs;
    }
}
// @lc code=end
