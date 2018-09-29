package test;

import java.util.*;

import structure.TreeNode;

public class ZigZagLevelOrderBinaryTree_Leet103 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.left = node1;
        List ls = zigzagLevelOrder(root);
        Iterator it = ls.iterator();
        while(it.hasNext()){
            List<Integer> l = (List<Integer>) it.next();
            Iterator i = l.iterator();
            while(i.hasNext()){
                int res = (int) i.next();
                System.out.println(res);
            }
        }
    }
    //锯齿层次遍历，就是一层从左到右遍历，下一层就从右到左，easy
    //但是写起来比较麻烦,所以就是每一层存进去其实都是从左到右层次存进去，不过每层读取出来的数先保存到一个数组中
    //然后判断这层时要从左向右还是从右向左，就操作数组中数据存到list中然后输出。
    static public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();

        if(root == null)
            return ls;
        int flag = 1;
        Queue<TreeNode> q= new ArrayDeque<>();

        q.add(root);
        while(!q.isEmpty()){
            int begin = 0;
            int last = q.size();
            TreeNode temp;
            List<Integer> l = new ArrayList<>();
            List<Integer> s = new LinkedList<>();
            while(begin<last){
                temp = q.remove();
                s.add(temp.val);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                begin++;
            }
            //从左向右
            if(flag == 1){
                for(int i=0;i<s.size();i++){
                    l.add(s.get(i));
                }
            }else{
                for(int i=s.size()-1;i>=0;i--){
                    l.add(s.get(i));
                }
            }
            ls.add(l);
            flag *= -1;

        }


        return ls;
    }

}
