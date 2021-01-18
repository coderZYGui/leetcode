package _01_链表;

import java.util.ArrayList;

/**
 * Description:
 *
 * @author zygui
 * @date 2020/3/28 15:25
 */
public class ListNode extends ArrayList<ListNode>{
    int val;            // 存储值
    ListNode next;      // 存储下一个结点的地址

    ListNode(int x) {
        val = x;
    }
}
