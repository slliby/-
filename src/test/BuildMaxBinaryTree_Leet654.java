package test;

import structure.TreeNode;

/*
构建二叉树，最大的再上，左边为左边数组，右边为右边数组
思路很清晰的就想到了递归，这题应该不是很好非递归
 */
public class BuildMaxBinaryTree_Leet654 {

    public static void main(String[] args){



    }

    public static TreeNode constructMaximumBinaryTree(int[] nums){
        if(nums.length == 0)
            return null;


        return buildTree(nums, 0, nums.length - 1);

    }

    public static TreeNode buildTree(int[] nums, int begin, int end){
        if(begin > end)
            return null;

        int max = nums[begin];
        int index = begin;
        for(int i=begin+1;i<=end;i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(nums, begin, index - 1);
        root.right = buildTree(nums, index + 1, end);

        return root;
    }
}
