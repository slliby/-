package test;

import structure.ListNode;

/**
 * 两两交换链表中节点，很简单思路
 * 重点是我用了一个多余的节点放在头节点前，起到头指针的作用，那么无论后面怎么变换
 * 返回头指针后一个节点就可以了
 */
public class SwapPairs_Leet24 {

    public static void main(String[] args){

    }

    public static ListNode swapPairs(ListNode head){
        if(head == null){
            return head;
        }
        ListNode p = head;
        ListNode q = p.next;
        ListNode now = new ListNode(0);
        ListNode temp = now;
        temp.next = head;
        while(q != null){
            p.next = q.next;
            q.next = p;
            temp.next = q;
            if(p.next == null){
                break;
            }
            temp = p;
            p = p.next;
            q = p.next;
        }


        return now.next;
    }
}
