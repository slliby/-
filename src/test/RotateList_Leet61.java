package test;

import structure.ListNode;

/*
旋转一个单向链表，很简单了
思路就是可以把链表看成左右两部分
所谓的旋转，其实就是把右边部分放到左边，左边部分放到右边
思路理解就很好写代码
 */
public class RotateList_Leet61 {

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(4);
        ListNode p4 = new ListNode(5);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = null;
        head = rotateRight(head, 2);
        while(head != null){
            System.out.print(head.val + "\t");
            head = head.next;
        }

    }

    public static ListNode rotateRight(ListNode head, int k){
        ListNode p = head;
        ListNode q = p;
        int len = 0;
        while(p != null){
            len++;
            q = p;
            p = p.next;
        }

        if(len <= 1){
            return head;
        }
        p = head;
        k %= len;
        for(int i=0; i<len-k-1; i++){
            p = p.next;
        }
        q.next = head;
        head = p.next;
        p.next = null;

        return head;
    }

}
