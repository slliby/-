package test;

import structure.ListNode;

public class MiddleNode_Leet876 {

    public static void main(String[] args){

    }

    public static ListNode middleNode(ListNode head){
        ListNode p = head;
        int len = 0;
        while(p != null){
            len++;
            p = p.next;
        }
        p = head;
        for(int i = 0; i < len / 2; i++){
            p = p.next;
        }
        return p;
    }
}
