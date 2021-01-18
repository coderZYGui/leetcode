package _03_队列;

import java.util.Stack;

/**
 * Description: 栈实现队列 https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * @author zygui
 * @date 2020/4/11 21:27
 */
public class _232_用栈实现队列 {

    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public _232_用栈实现队列() {

    }

    // 入队
    public void push(int x) {
        inStack.push(x);
    }

    // 出队
    public int pop() {
        checkOutStack();
        return outStack.pop();
    }

    // 获取队头元素
    public int peek() {
        checkOutStack();
        return outStack.peek(); // 获取队头元素
    }

    // 队列是否为空
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

    private void checkOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
