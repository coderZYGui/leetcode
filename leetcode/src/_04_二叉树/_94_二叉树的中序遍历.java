package _04_二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Description: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author guizy1
 * @date 2021/1/20 16:53
 */
@SuppressWarnings("all")
public class _94_二叉树的中序遍历 {

    // 递归方式省略, 参考前序遍历的迭代

    /*
        使用迭代的方式
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node); // 将根节点入栈
                node = node.left;
            } else if (stack.isEmpty()) {
                return list;
            } else {

            }
        }
    }
}
