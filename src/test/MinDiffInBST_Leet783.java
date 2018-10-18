package test;

import structure.TreeNode;

import java.util.Stack;
/*
找二叉搜索树两个节点的最小差，很简单了
首先明确什么是二叉搜索树，BST就是一个树，左边的值都小于根结点，右边都大于根节点
同时子树都满足这条件，那么很简单，中序遍历肯定是个递增序列，找相邻的最小差就行了
 */
public class MinDiffInBST_Leet783 {
    public static void main(String[] args){

        TreeNode root = new TreeNode(27);
        TreeNode t1 = new TreeNode(34);
        TreeNode t2 = new TreeNode(58);
        TreeNode t3 = new TreeNode(50);
        TreeNode t4 = new TreeNode(44);
        root.right = t1;
        t1.right = t2;
        t2.left = t3;
        t3.left = t4;
        System.out.println(minDiffInBST(root));
    }

    public static int minDiffInBST(TreeNode root){
        int diff = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int lastNum = Integer.MAX_VALUE;
        TreeNode  p =root.left;
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                if(lastNum != Integer.MAX_VALUE && p.val - lastNum < diff){
                    diff = p.val - lastNum;
                }
                lastNum = p.val;
                p = p.right;

            }
        }
        return diff;
    }
}
