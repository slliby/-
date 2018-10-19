package test;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/*
每一层的平均值，
 easy*/
public class AverageOfLevels_leet637 {

    public static void main(String[] args){

    }

    public List<Double> averageOfLevels(TreeNode root){
        List<Double> l = new ArrayList<>();
        if(root == null){
            return l;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode temp;
        while(!queue.isEmpty()){
            int len = queue.size();
            double sum = 0;
            for(int i=0;i<len;i++){
                temp = queue.poll();
                sum += temp.val;
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            double res = sum / len;
            l.add(res);
        }
        return l;
    }
}
