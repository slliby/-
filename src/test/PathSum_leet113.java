package test;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 变成了寻找所有路径，还是很简单的dfs嘛
 */
public class PathSum_leet113 {

    public static void main(String[] args){

    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        getResult(root, sum, result, ls);

        return result;
    }

    public static void getResult(TreeNode root, int sum, List<List<Integer>> result, List<Integer> ls){
        if(root == null){
            return;
        }

        if(root.val == sum && root.left == null && root.right == null){
            List<Integer> res = new ArrayList<>(ls);
            res.add(root.val);
            result.add(res);
        }
        ls.add(root.val);
        if(root.left != null){
            getResult(root.left, sum - root.val, result, ls);
        }
        if(root.right != null){
            getResult(root.right, sum - root.val, result, ls);
        }

        ls.remove(ls.size() - 1);

    }
}
