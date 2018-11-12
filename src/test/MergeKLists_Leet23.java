package test;

import structure.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 合并K个有序链表，思路就是归并排序，两两排好序，然后继续放进list中进行排序
 */
public class MergeKLists_Leet23 {

    public static void main(String[] args){

        ListNode[] lists = new ListNode[3];
        ListNode head1 = new ListNode(1);
        ListNode p1 = new ListNode(4);
        ListNode p2 = new ListNode(5);
        head1.next = p1;
        p1.next = p2;
        lists[0] = head1;
        ListNode head2 = new ListNode(1);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        head2.next = p3;
        p3.next = p4;
        lists[1] = head2;
        ListNode head3 = new ListNode(2);
        ListNode p5 = new ListNode(6);
        head3.next = p5;
        lists[2] = head3;
        ListNode head = mergeKLists(lists);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }

        List<ListNode> ls = new LinkedList<>();
        for(ListNode l : lists){
            ls.add(l);
        }

        while(ls.size() > 1){
            int len = ls.size();
            for(int i = 0; i < len - 1;i = i + 2){
                ListNode head1 = ((LinkedList<ListNode>) ls).removeFirst();
                ListNode head2 = ((LinkedList<ListNode>) ls).removeFirst();
                ListNode head = new ListNode(0);
                ListNode p = head;
                while(head1 != null && head2 != null){
                    if(head1.val < head2.val){
                        p.next = head1;
                        head1 = head1.next;
                    }else {
                        p.next = head2;
                        head2 = head2.next;
                    }
                    p = p.next;
                }
                while(head1 != null){
                    p.next = head1;
                    head1 = head1.next;
                    p = p.next;
                }
                while(head2 != null){
                    p.next = head2;
                    head2 = head2.next;
                    p = p.next;
                }

                ls.add(head.next);
            }
        }


        return ls.get(0);
    }


}
