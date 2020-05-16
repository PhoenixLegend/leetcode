import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 * 回溯 backtrack 养鱼玩法 递归
 * 能满足状态条件的，我就继续下去。满足不了了，就撤回到上一个状态再来
 * 1.结束状态：list长度 == nums.length  ——完成了一个排列组合
 * 2.试探状态：!list.contains(num[i])  ——只要我的目前组合没有那就有序加进来
 * 3.回溯状态:list.remove(list.size() - 1) ——去掉上一个“结束”或者“失败”的对象
 * 
 * ps:有空可以debug试试，很巧妙的思想
 * {1，2，3}为例：
 * state 1： 
 * list = {1} -> i = 1 -> backtrack(state 2) remove等待执行
 * state 2:
 * list = {1,2} -> i = 2 -> backtrack(state 3) remove等待执行
 * state 3:
 * list = {1,2,3} -> i = 3 -> 拿走 -> remove直接执行 -> list = {1,2} -> end of loop -> return state 2
 * ————————————————————————————
 * state 2: 
 * remove直接执行 list = {1} -> i=3 -> list = {1,3} -> baktrack(state 3)  remove等待执行
 * state 3: 
 * list = {1,3,2} -> i = 2 -> 拿走 -> remove直接执行 -> end of loop -> return state 2
 * ……
 *
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(lists, list, nums);
        return lists;
    }

    public static void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums) {
        /**
         * 设置结束状态。但是注意这里不能写成以下形式： lists.add(list); list = new ArrayList<>(); 这样会导致list
         * 瞬间变化，无法回溯，不能保持状态的连续性
         */
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i : nums) {
            // 设置试探状态
            if (!list.contains(i)) {
                list.add(i);
                backtrack(lists, list, nums);
                // 设置撤回状态
                list.remove(list.size() - 1);
            }
        }
    }
}
// @lc code=end
