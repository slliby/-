package test;
import  structure.ListNode;

public class OddEvenList_Leet328 {

    public static void main(String[] args){

    }
    //奇偶链表，将技术节点放一起，偶数放一起
    static public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode oddBegin = head;
        ListNode oddLast = head;
        ListNode evenBegin = head.next;
        ListNode evenLast = head.next;
        int flag = 1;
        head = head.next.next;
        while(head != null){
            ListNode temp;
            //奇数节点
            if(flag == 1){
                oddLast.next = head;
                oddLast = oddLast.next;
                //偶数节点
            }else{
                evenLast.next = head;
                evenLast = evenLast.next;
            }

            head = head.next;
            flag *= -1;
        }
        oddLast.next = evenBegin;
        evenLast.next = null;
        return oddBegin;
    }
}
