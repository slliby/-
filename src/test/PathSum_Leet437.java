package test;

import structure.TreeNode;

/**
 * 路经总和，起点和终点只要在一条线上就行，那么对一个节点
 * 既要判断以这个跟节点开始能不能找到一串总和等于sum，同时在子树里也这么找
 */
public class PathSum_Leet437 {

    public static void main(String[] args){

    }

    public static int pathSum(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        return getResult(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);


    }

    public static int getResult(TreeNode root, int sum){
        int res = 0;
        if(root == null){
            return 0;
        }
        if(root.val == sum){
            res++;
        }
        res += getResult(root.left, sum - root.val) +getResult(root.right, sum - root.val);
        return res;
    }

}
