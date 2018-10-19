package test;

import structure.TreeNode;

import java.util.*;

/*
从底向下层次便利，我的思路是头插法放进一个list
但是应该还能递归，找到最底层，一层层向上
 */
public class LevelOrderBottom_Leet107 {

    public static void main(String[] args){

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> ls = new LinkedList<>();
        if(null == root){
            return ls;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode temp;
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<len;i++){
                temp = queue.poll();
                l.add(temp.val);
                if(null != temp.left){
                    queue.add(temp.left);
                }
                if(null != temp.right){
                    queue.add(temp.right);
                }
            }
            ((LinkedList<List<Integer>>) ls).addFirst(l);
        }

        return ls;
    }
}
