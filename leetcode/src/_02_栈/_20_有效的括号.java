package _02_栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Description: 地址: https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author zygui
 * @date 2020/4/9 21:31
 */
@SuppressWarnings("all")
public class _20_有效的括号 {
    // {[()]}

    // 因为下面的操作是在做,左右对应的关系(一对一),可以采用map方式来将左右括号对应起来
    /*    private Map<Character, Character> map = new HashMap<>();

    public _20_有效的括号() {
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
    }*/
    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
    }

    // 优化方法1
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {   // 左括号
                stack.push(c);
            } else {    // 右括号
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (map.get(c) != left) return false;
            }
        }
        return stack.isEmpty();
    }

    // --------------------------------------------

    public static boolean isValid1(String s) {
        // 方法1
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        // 遍历给定的字符串的字符
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i); // 拿出字符串的字符
            // 遍历左字符(左括号)
            if (c == '{' || c == '[' || c == '(') {
                // 将左字符入栈
                stack.push(c);
            } else {
                // 右括号
                if (stack.isEmpty()) return false;
                // 如果出现右括号,则弹出栈顶字符,和右括号作匹配
                char left = stack.pop();
                if (left == '{' && c != '}') return false;
                if (left == '[' && c != ']') return false;
                if (left == '(' && c != ')') return false;
            }
        }
        // 判断完之后,看栈是否为空,若为空则说明是有效括号
        return stack.isEmpty();
    }

    // --------------------------------------------

    // 方法2
    public static boolean isValid2(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            s = s.replace("{}", "");
            s = s.replace("[]", "");
            s = s.replace("()", "");
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid1("{[()]}"));
    }
}
