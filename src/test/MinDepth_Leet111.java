package test;

import structure.TreeNode;

/**
 * 找最小深度，递归找就行
 */
public class MinDepth_Leet111 {

    public static void main(String[] args){

    }

    public static int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return minDepth(root.right) + 1;
        }else if(root.right == null){
            return minDepth(root.left) + 1;
        }else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
