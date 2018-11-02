package test;

import structure.TreeNode;

/**
 * 很简单的题目，很简单的递归
 */
public class HasPathSum_Leet112 {

    public static void main(String[] args){

    }

    public static boolean hasPathSum(TreeNode root, int sum){
        if(root == null){
            return false;
        }
        if(root.val == sum && root.left == null && root.right == null){
            return true;
        }
        return (root.left == null ? false : hasPathSum(root.left, sum - root.val))
                ||(root.right == null ? false : hasPathSum(root.right, sum - root.val));
    }
}
