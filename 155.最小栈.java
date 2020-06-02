import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 * 常数时间内检索到最小元素的栈
 * 维护一个辅助栈，用于存储“每次”入栈时的最小值。
 */

// @lc code=start
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> supportStack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        supportStack = new Stack<>();
        min = 2147483647;
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min = x;
            supportStack.push(x);
        } else {
            min = supportStack.peek();
            if (x <= min) {
                stack.push(x);
                supportStack.push(x);
            } else {
                stack.push(x);
                supportStack.push(min);
            }
        }
    }

    public void pop() {
        stack.pop();
        supportStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return supportStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.pop();
        obj.getMin();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
