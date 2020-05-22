import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 * 题目可以转换为：
 * 1.n个0的排列 1种，加入结果集rs
 * 2.在之前的结果集rs上选择一位变化,倒序i--或者正序i++循环，每次改一个。
 * ……
 * 若结果集rs包含，则换下一位变化再比对依次
 * 若全部i遍历完了n都包含则退出循环
 * 若有一个没有包含，则将该值加入结果集rs。重新执行2
 * 
 * ps：讨论区大佬提出了异或，找规律等办法。也是很好的办法可以学习。但是我这种办法也适合一时想不到其他办法的，根据运算思路可以直接完成的同学。
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        // 不要用int[]这是基础数据类型，不是对象，无法加入集合对象当中。需要装箱。
        List<ArrayList<Integer>> rs = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        List<Integer> result = new ArrayList<Integer>();
        // 赋初值为0的链表
        for (int i = 0; i < n; i++) {
            curr.add(0);
        }
        rs.add(curr);
        // 特殊判断
        if (n <= 0) {
            result.add(0);
            return result;
        }
        // 开始套娃
        backtrack(curr, rs);
        // 把结果链表输出成十进制
        for (ArrayList<Integer> e : rs) {
            StringBuilder xxx = new StringBuilder();
            for (Integer integer : e) {
                xxx.append(integer);
            }
            Integer x = Integer.valueOf(xxx.toString(), 2);
            result.add(x);
        }
        return result;
    }

    public static void backtrack(ArrayList<Integer> curr, List<ArrayList<Integer>> rs) {
        // curr链表从左往右看
        for (int i = 0; i < curr.size(); i++) {
            // 定义一个临时链表
            ArrayList<Integer> tmp = new ArrayList<>(curr);
            // 当前位置1变0，或者0变1
            int x = 1 - curr.get(i);
            tmp.set(i, x);
            // 如果当前结果集包含该临时链表则直接跳过
            if (rs.contains(tmp)) {
                continue;
            }
            rs.add(tmp);
            // curr和当前临时链表移形换影
            curr = tmp;
            // 继续套娃
            backtrack(curr, rs);
            // 套娃结束返回
            return;
        }
        // 当遇到一个从左往右即使全部都变一次，也在结果集里面则退出套娃
        return;
    }
}
// @lc code=end
