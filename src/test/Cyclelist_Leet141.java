package test;

import structure.ListNode;

/*
判断链表是否有环，很简单的双指针了，有环双指针必然相遇
 */
public class Cyclelist_Leet141 {
    public static void main(String[] args){

    }

    public boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }

        ListNode p = head;
        ListNode q = head;
        while(true){
            if(p.next != null){
                p = p.next;
            }else{
                return false;
            }

            if(q.next != null && q.next.next != null){
                q = q.next.next;
            }else{
                return false;
            }

            if(p == q){
                return true;
            }
        }
    }
}
