package test;

import structure.TreeNode;

public class BulidBinaryTreeByInAndPostOrder_Leet105 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    //根据后序和中序创建二叉树，也是很简单了，和根据前序中序创建类似，不过不同的在于
    //从后向前遍历后序数组，因为最后遍历的肯定是根节点，先创建，然后他的右子树的根节点是他当前位置左移一个下标
    //而左子树根节点需要在后序数组左移他的右子树的节点个数，嘻嘻
    static public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null;
        if(inorder.length==0 || postorder.length==0)
            return root;

        root = build(inorder, postorder, postorder.length-1, 0, inorder.length-1);
        return root;
    }
    //其实中序数组的目的在于找到当前根节点位置，然后把他左右子树的下标范围划分开来，esay啦
    public static TreeNode build(int[] inorder,int[]postorder,int beginIndex,int inBegin,int inEnd){
        if(inBegin>inEnd)
            return null;
        if(inBegin == inEnd){
            TreeNode root = new TreeNode(inorder[inBegin]);
            return root;
        }

        TreeNode root = new TreeNode(postorder[beginIndex]);
        int i = 0;
        for(i=inBegin;i<=inEnd;i++){
            if(inorder[i] == root.val)
                break;
        }
        //右子树
        root.right = build(inorder, postorder, beginIndex-1, i+1, inEnd);
        //左子树
        root.left = build(inorder, postorder, beginIndex-inEnd+i-1, inBegin, i-1);
        return root;

    }
}
