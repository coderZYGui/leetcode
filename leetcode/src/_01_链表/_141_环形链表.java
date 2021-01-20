package _01_链表;

/**
 * Description: 判断链表是否有环 https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author zygui
 * @date 2020/3/28 16:12
 */
@SuppressWarnings("all")
public class _141_环形链表 {

    // 使用快慢指针来解决
    public boolean hasCycle(ListNode head) {

        // 如果链表为空或者只有一个结点,肯定没有环
        if (head != null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

}
