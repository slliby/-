package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import structure.TreeNode;

public class InOrderBinaryTree_Leet94 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /*
     * 中序遍历二叉树，递归很简单，非递归也简单，就是用一个栈，从根节点开始，西安房间去，然后一直把左子节点放入，
     * 假如左子节点为空，就出栈一个，数据读取，然后把该节点右节点入栈
     */
    static public List<Integer> inorderTraversal(TreeNode root) {
        //递归
		/*
        List<Integer> l = new ArrayList<>();
        Bianli(l,root);

        return l;
        */
        //非递归
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while(p!=null || !s.isEmpty()){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                l.add(p.val);
                p = p.right;
            }
        }

        return l;

    }

    //递归方法
    private static void Bianli(List<Integer> l, TreeNode root) {
        // TODO Auto-generated method stub
        if(root == null)
            return;
        Bianli(l,root.left);
        l.add(root.val);
        Bianli(l,root.right);
    }



}
