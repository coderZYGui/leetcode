package _01_链表;


/**
 * Description: https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author zygui
 * @date 2020/3/28 15:24
 */
@SuppressWarnings("all")
public class _206_反转链表 {

    // 递归实现
    public ListNode reverseList(ListNode head) {

        // 判断链表为空,或者链表中只有一个结点
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 非递归实现
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
    }
}
