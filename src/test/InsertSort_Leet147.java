package test;

import structure.ListNode;

public class InsertSort_Leet147 {

    /*
    list的插入排序，思路很简单了，就是每次拿出一个节点到
    已排序list中插入，就是插到前面去而已，就是各种边界判断比较麻烦
    譬如可能要插到开始，可能位置不用变等等
     */
    public static void main(String[] args){

        ListNode head = new ListNode(4);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        head = insertionSortList(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode insertionSortList(ListNode head){
        if(head == null)
            return head;
        ListNode p = head.next;
        ListNode last = head;
        while(p != null){
            ListNode q = p.next;
            System.out.println(q);
            ListNode t = head;
            ListNode k = null;
            while(t.val < p.val){
                k = t;
                t = t.next;
            }

            if(k == null){
                p.next = head;
                head = p;
            }else{
                if(t != p) {
                    k.next = p;
                    p.next = t;
                }else{
                    last = p;
                }
            }

            p = q;
            last.next = p;

        }


        return head;
    }
}
