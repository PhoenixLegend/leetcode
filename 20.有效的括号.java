import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 * ( { [ 就入栈
 * ) } ] 就出栈
 * 出栈的时候对比，直到全部出栈或者列表数据为空则结束循环
 */

// @lc code=start
class Solution_done {
    public static boolean isValid(String s) {
        Stack<Character> in = new Stack<>();
        HashMap<Character, Character> dict = new HashMap<>();
        dict.put('}', '{');
        dict.put(']', '[');
        dict.put(')', '(');
        char[] out = s.toCharArray();
        if (out.length == 0) {
            return true;
        }
        if (out.length == 1) {
            return false;
        }
        for (Character e : out) {
            if ('{' == e || '(' == e || '[' == e) {
                in.push(e);
            }
            if ('}' == e || ')' == e || ']' == e) {
                if (in.size() > 0 && in.pop() == dict.get(e)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (in.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        isValid("{{");
    }

}
// @lc code=end
