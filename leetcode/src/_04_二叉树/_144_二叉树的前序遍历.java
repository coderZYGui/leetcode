package _04_二叉树;

/**
 * Description: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author guizy1
 * @date 2021/1/20 10:26
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
@SuppressWarnings("all")
public class _144_二叉树的前序遍历 {
    /*
        在leetcode看到大佬的解法, 可以统一 前序/中序/后序遍历的代码
     */
    class FlagNode {
        TreeNode node;
        int flag; // 0用来标记未访问过的元素, 1用来标记访问过的元素

        public FlagNode(TreeNode node, int flag) {
            this.node = node;
            this.flag = flag;
        }
    }

    public List<Integer> preorderTraversal4(TreeNode root) {
        /*
            过程:
            1、首先将root节点入栈, 标记未访问标记0
            2、进入while, 栈不为空, 弹出栈顶元素root, 进入if判断, 将右/左入栈, 并重新标记root为标记为1
            3、此时栈仍不为空, fn.flag被改为1了, 此时进入else, 添加到list
            4、此时栈不为空, 弹出栈顶元素(left), 标记为0, 将left的右/左入栈, 并重新标记left为1
            5、.....以此类推
         */
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<FlagNode> stack = new Stack<>();
        // 将根节点压入栈
        stack.push(new FlagNode(root, 0));
        while (!stack.isEmpty()) {
            FlagNode fn = stack.pop();
            // 表示该节点未被访问过
            if (fn.flag == 0) {
                // 因为是本题为前序遍历, 根左右, 所以入栈顺序为: 右左根
                if (fn.node.right != null) stack.push(new FlagNode(fn.node.right, 0));
                if (fn.node.left != null) stack.push(new FlagNode(fn.node.left, 0));
                stack.push(new FlagNode(fn.node, 1));
            } else {
                // 将flag为1的添加到list(访问过的节点)
                list.add(fn.node.val);
            }
        }
        return list;
    }

    // ----------------------------------------------------------------------------------------

    /*
        使用迭代实现: 使用栈这种结构
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            list.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode node = root;
        while (true) {
            if (node != null) {
                list.add(node.val);
                if (node.right != null) stack.push(node.right);
                node = node.left;
            } else if (stack.isEmpty()) { // 这种情况表示, 只有左子节点
                return list;
            } else {
                node = stack.pop();
            }
        }
    }

    /*
        使用递归的实现方式
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}

