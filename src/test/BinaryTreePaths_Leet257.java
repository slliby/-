package test;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_Leet257 {

    public static void main(String[] args){

    }

    public static List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        getResult(root, sb, result);
        return result;
    }

    public static void getResult(TreeNode root, StringBuffer sb, List<String> result){
        if(root.left == null && root.right == null){
            result.add(sb.toString());
            return;
        }

        if(root.left != null){
            StringBuffer temp = new StringBuffer(sb);
            sb.append("->" + root.left.val);
            getResult(root.left, sb, result);
            sb = temp;
        }

        if(root.right != null){
            StringBuffer temp = new StringBuffer(sb);
            sb.append("->" + root.right.val);
            getResult(root.right, sb, result);
            sb = temp;
        }
    }
}
