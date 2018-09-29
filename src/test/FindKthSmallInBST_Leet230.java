package test;

import structure.TreeNode;

import java.util.Stack;

public class FindKthSmallInBST_Leet230 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    //从二叉搜索树中找第k小的元素，思路就是中序遍历，但是总觉得这样很麻烦
    static public int kthSmallest(TreeNode root, int k) {
        TreeNode p = root;
        Stack<TreeNode> s = new Stack<>();
        while(p!=null || !s.isEmpty()){
            if(p!=null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                k--;
                if(k==0)
                    break;
                p = p.right;
            }
        }

        return p.val;
    }
}
