package test;

import structure.ListNode;

public class IntersectionList_Leet160 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    //两个链表的相交点，很简单了，遍历求长度，让更长的先走多余长度，然后一起走，直到碰头，碰不到就没有
    static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        int lenA = 0;
        int lenB = 0;
        ListNode longList = headA;
        ListNode shortList = headB;
        int  k =0;
        //求长度
        while(longList != null){
            lenA++;
            longList = longList.next;
        }
        while(shortList != null){
            lenB++;
            shortList = shortList.next;
        }
        //设置长短链表
        if(lenA<lenB){
            longList = headB;
            shortList = headA;
            k = lenB - lenA;
        }else{
            longList = headA;
            shortList = headB;
            k = lenA - lenB;
        }
        //长链表先走
        while(k>0){
            longList = longList.next;
            k--;
        }
        while(longList!=null && shortList!=null && longList != shortList){
            longList = longList.next;
            shortList = shortList.next;
        }
        //没有相交
        if(longList == null)
            return null;

        return longList;
    }

}
