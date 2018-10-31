package test;

import structure.ListNode;

/**
 * 分割链表，也是很简单的思路了，其实可以更好，但是太困了，下次再想吧，应该是可以原地换的
 */
public class Partition_Leet86 {

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(2);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        head = partition(head, 3);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static ListNode partition(ListNode head, int x){
        if(head == null){
            return head;
        }
        ListNode smallBegin = null;
        ListNode smallEnd = null;
        ListNode longBegin = null;
        ListNode longEnd = null;
        while(head != null){
            if(head.val < x){
                if(smallBegin == null){
                    smallBegin = head;
                    smallEnd = head;
                }else{
                    smallEnd.next = head;
                    smallEnd = head;
                }
            }else{
                if(longBegin == null){
                    longBegin = head;
                    longEnd = head;
                }else {
                    longEnd.next = head;
                    longEnd = head;
                }
            }
            head = head.next;
        }
        if(smallBegin == null){
            return  longBegin;
        }else if(longBegin == null){
            return smallBegin;
        }else {
            smallEnd.next = longBegin;
            longEnd.next = null;
            return smallBegin;
        }

    }
}
