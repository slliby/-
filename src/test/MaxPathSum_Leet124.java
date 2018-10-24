package test;

import structure.TreeNode;
/*
找最大路径和，可以看出这是个最大深度问题，DFS，那么很简单的可以回溯
就是先到最底层，然后判断左子树，右子树和左右根三个和的最大值
注意，为了更好判断我把空节点返回值为整型最小值，因此需要先进行判断是否大于0在进行运算，不然直接加就超范围了

然后，返回上一层你能得到的最大值，这个最大值和上面那个最大值不一样，上面那个是到当前根节点的结果
是我们需要的结果
而返回的只能是根结点，然后最多加上一边子树能得到的最大值，因为是两个节点的连线，我们现在找到的是一端，不能有两个起点
 */
public class MaxPathSum_Leet124 {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args){
        TreeNode root =new TreeNode(1);

        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root){
        findMax(root);

        return max;
    }

    public static int findMax(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int i = findMax(root.left);
        int j = findMax(root.right);
        System.out.println("i: " + i);
        System.out.println("j: " + j);
        if(i > 0 && j > 0){
            max = Math.max(Math.max(Math.max(i, j), i + j + root.val) , max);
        }else if(i > 0){
            max = Math.max(Math.max(i, i + root.val), max);
        }else if(j > 0){
            max = Math.max(Math.max(j, j + root.val), max);
        }else{
            max = Math.max(root.val , max);
        }

        System.out.println("max: " + max);
        return root.val + Math.max(Math.max(i, j ), 0);
    }
}
