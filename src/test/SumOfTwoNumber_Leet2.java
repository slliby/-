package test;


import structure.ListNode;

public class SumOfTwoNumber_Leet2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    //两数相加，链表保存的每一位，因此先比较长度，加到更长的那个上面，节省空间
    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode head = l1;
        ListNode temp = null;
        int sum = 0;
        while(l1!=null && l2!=null){
            sum += l1.val + l2.val;
            l1.val = sum%10;
            sum /= 10;
            temp = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            //说明加完了，更高为不会变化，跳出
            if(sum == 0)
                break;
            sum += l1.val;
            l1.val = sum%10;
            sum /= 10;
            temp = l1;
            l1 = l1.next;
        }
        //把l1连过来
        if(l2 != null)
            temp.next = l2;
        while(l2 != null){
            if(sum == 0)
                break;
            sum += l2.val;
            l2.val = sum%10;
            sum /= 10;
            temp = l2;
            l2 = l2.next;
        }
        //还有更高位，创建新节点保存
        if(sum != 0){
            ListNode newNode  = new ListNode(sum);
            temp.next = newNode;
        }
        return head;
    }

}
