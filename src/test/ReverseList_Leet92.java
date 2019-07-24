package test;

import structure.ListNode;

/**
 * 反转链表,easy
 * @author wangjiaping
 * @date 2019-04-08
 */
public class ReverseList_Leet92 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = reverseBetween(head, 2, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode begin = new ListNode(1);
        begin.next = head;
        ListNode temp = begin;
        for (int i = 1; i < m; i++) {
            temp = head;
            head = head.next;
        }
        ListNode temp2;
        for (int j = m; j < n; j++) {
            temp2 = head.next;
            head.next = temp2.next;
            temp2.next = temp.next;
            temp.next = temp2;
        }

        return begin.next;
    }
}
