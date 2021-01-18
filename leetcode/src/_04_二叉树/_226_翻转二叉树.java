package _04_二叉树;

/**
 * Description: 翻转二叉树 https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author guizy
 * @date 2020/11/16 23:22
 */
public class _226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        // 前序遍历, 交换结点
/*        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);*/


        // 后序遍历, 交换结点
/*        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;*/

        // 中序遍历, 交换节点

        invertTree(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //invertTree(root.right);
        invertTree(root.left);  // 之所以改为root.left, 在交换左右结点的时候已经更改了right

        return root;
    }
}
