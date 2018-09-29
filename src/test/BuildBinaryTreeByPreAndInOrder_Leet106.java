package test;

import structure.TreeNode;
public class BuildBinaryTreeByPreAndInOrder_Leet106 {


    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    //晚上好热。。写了个根据前序和中序遍历构建二叉树的代码
    //思路很简单，代码有点难搞，思路就是遍历前序数组，因为每次扫描到的都是当前根节点
    //扫描到一个，创建节点为当前值，然后去中序遍历里找到他，把他左边的元素作为他的左子树，右边的作为右字数递归创建
    //当然这样子中序遍历数组每次就要缩小范围，需要个左右指针，因为上一层节点帮你划分了大范围，你只能在这里面划分小范围，有点二分查找的意思了
    //然后左右子树怎么找到对应的根节点呢？同样的对前序加一个指针，左子树的根节点只需要当前的位置加一就行，而右子树根节点需要华东左子树长度那么多
    static public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        //空树
        if(preorder.length==0 || inorder.length==0)
            return root;
        root = bulid(preorder, inorder, 0, 0, inorder.length-1);
        return root;
    }

    static public TreeNode bulid(int[] preorder,int[] inorder,int beginIndex,int inBegin,int inEnd){
        //左或者右子树为空了不需要创建
        if(inBegin > inEnd)
            return null;
        //长度为1，只有一个节点，创建了就返回吧
        if(inBegin == inEnd){
            TreeNode root = new TreeNode(inorder[inBegin]);
            return root;
        }
        //直接创建
        TreeNode root = new TreeNode(preorder[beginIndex]);
        //记录下标
        int i = 0;
        for(i=inBegin;i<=inEnd;i++){
            if(inorder[i] == root.val)
                break;
        }
        //递归创建左右子树，左子树在当前的左边找，右子树在右边找
        root.left = bulid(preorder, inorder, beginIndex+1, inBegin, i-1);
        root.right = bulid(preorder, inorder, beginIndex+i-inBegin+1, i+1, inEnd);
        return root;
    }
}
