package test;

import structure.ListNode;

/*
判断是否环形链表并找到环入口，要画图
设起点到环入口为a，入口到快慢指针第一次相遇为b，b又到环起点为c
则a+2b+c = 2a+2b+2c
则a+c，那么相遇后江一个指针易到起点然后一起向后移动，相遇就是起点了
画个图吧
 */
public class DeteCycle_Leet142 {

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(0);
        ListNode p3 = new ListNode(-4);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = head;
        System.out.println(deteCycle(head).val);
    }

    public static ListNode deteCycle(ListNode head){
        if(head == null){
            return null;
        }

        ListNode p = head;
        ListNode q = head;
        while(true){
            if(p.next == null){
                return null;
            }else{
                p = p.next;
            }

            if(q.next != null && q.next.next != null){
                q = q.next.next;
            }else{
                return null;
            }

            if(p == q){
                break;
            }
        }

        p = head;
        while(q != p){
            p = p.next;
            q = q.next;
        }
        return q;

    }
}
