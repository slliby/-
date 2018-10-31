package test;

import structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断组件个数，这种题目怎么会是中等难度的。。
 * 思路很简单啊，要么用个set，要么用个下标数组，这里范围小用下表数组应该更合适一些
 */
public class NumComponents_Leet817 {

    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        //ListNode l3 = new ListNode(3);
        head.next = l1;
        l1.next = l2;
        //l2.next = l3;
        int[] G = new int[]{0, 2};
        System.out.println(numComponents(head, G));
    }

    public static int numComponents(ListNode head, int[]G){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < G.length; i++){
            set.add(G[i]);
        }
        int num = 0;
        boolean flag = true;
        while(head != null){
            if(set.contains(head.val) && flag){
                num++;
                flag = false;
            }else if(!set.contains(head.val)){
                flag = true;
            }
            head = head.next;
        }


        return num;
    }
}
