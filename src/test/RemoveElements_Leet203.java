package test;

import structure.ListNode;
/**
 * 凡是链表中的操作，都可以考虑加一个节点来做头指针，有时候会很方便很多
 */
public class RemoveElements_Leet203 {

    public static void main(String[] args){

    }

    public static ListNode removeElement(ListNode head, int val){
        if(head == null){
            return head;
        }

        ListNode p = new ListNode(0);
        p.next = head;
        ListNode q = p;
        while (head != null){
            if(head.val == val){
                q.next = head.next;
            }else {
                q = q.next;
            }
            head = q.next;
        }

        return p.next;
    }
}
