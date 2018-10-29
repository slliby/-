package test;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找到指定节点距离为k的节点，其实向下还是很好找，递归就行
 * 难度在于向上，那么可以便利一次，给所有节点标记好对应的父节点，这个思路可以用map
 * 那么找完向下的在向上找，向上的同时对上面的每个节点向下，当然不能在向上的那一方向。就可以了
 */
public class DistanceK_Leet863 {

    public static void main(String[] args){

        TreeNode root = new TreeNode(3);
        TreeNode p1 = new TreeNode(5);
        TreeNode p2 = new TreeNode(1);
        TreeNode p3 = new TreeNode(6);
        TreeNode p4 = new TreeNode(2);
        TreeNode p5 = new TreeNode(0);
        TreeNode p6 = new TreeNode(8);
        TreeNode p7 = new TreeNode(7);
        TreeNode p8 = new TreeNode(4);
        root.left = p1;
        root.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;
        p4.left = p7;
        p4.right = p8;
        System.out.println(distanceK(root, p1, 2));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        findParent(root, parent);
        findRes(target, k, res);

        TreeNode now = target;
        int i = k;
        while(parent.get(now) != null && i > 0){
            TreeNode temp = parent.get(now);
            i--;
            if(i == 0){
                res.add(temp.val);
            }else if(temp.left == now){
                findRes(temp.right, i - 1, res);
            }else {
                findRes(temp.left, i - 1, res);
            }

            now = temp;
        }

        return res;
    }


    public static void findRes(TreeNode now, int k, List<Integer> res){
        if(now == null){
            return;
        }

        if(k == 0){
            res.add(now.val);
            return;
        }

        findRes(now.left, k - 1, res);
        findRes(now. right, k - 1, res);

    }

    public static void findParent(TreeNode parentNode,Map<TreeNode, TreeNode> parent){
        if(parentNode.left != null){
            parent.put(parentNode.left, parentNode);
            findParent(parentNode.left, parent);
        }

        if(parentNode.right != null){
            parent.put(parentNode.right, parentNode);
            findParent(parentNode.right, parent);
        }
    }

}
