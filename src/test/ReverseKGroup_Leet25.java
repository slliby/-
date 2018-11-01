package test;

import structure.ListNode;

/**
 * 每k个一组进行旋转。也很简单，就是上一题的思路，多一个节点来做头指针，就很
 * 容易，但是多了一个每次判断当前到末尾是否有k个，没有的话这一组不用交换
 **/
public class ReverseKGroup_Leet25 {

    public static void main(String[] args){

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode head = reverseKGroup(l1, 5);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k){
        if(head == null){//非空判断
            return head;
        }

        ListNode now = new ListNode(0);//头指针
        ListNode temp = now;//标记每组的前一个，也是每组的头指针
        now.next = head;
        ListNode p =head;
        ListNode q = head.next;
        while(true){
            ListNode t = p;
            boolean flag = true;
            for(int i = 0; i < k; i++){//判断还有没有k个
                if(t == null){
                    flag = false;
                    break;
                }

                t = t.next;
            }

            if(!flag){//没有k个了，退出
                break;
            }

            for(int i = 1; i < k; i++){//交换
                p.next = q.next;
                q.next = temp.next;
                temp.next = q;
                q = p.next;
            }

            temp = p;//完成后把下一组的头指针设为这一组的末尾节点
            p = temp.next;
            if(p == null){
                break;
            }
            q = p.next;
        }


        return now.next;
    }
}
