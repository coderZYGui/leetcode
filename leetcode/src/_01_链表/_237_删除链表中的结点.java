package _01_链表;

/**
 * Description: https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author zygui
 * @date 2020/3/28 14:14
 */
@SuppressWarnings("all")
public class _237_删除链表中的结点 {

    /**
     * 删除node结点
     * @param node 被删除的结点
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
