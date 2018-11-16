package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 找和为目标数的组合可能，思路很简单，就是先排序在回溯找就可以了，但是我这里没判断0的可能也成功了，神奇
 * 可能例子里面就没有负数和0的情况吧
 */
public class CombinationSum_Leet39 {

    public static void main(String[] args){

        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> ls = combinationSum(candidates,7);
        for(List<Integer> l : ls){
            for(int i : l){
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ls = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        Arrays.sort(candidates);
        getResult(candidates, target,0, ls, l);
        return ls;

    }

    public static void getResult(int[] candidates, int target, int index, List<List<Integer>> ls, List<Integer> l){
        if(target == 0){
            List<Integer> ll = new LinkedList<>(l);
            ls.add(ll);
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] <= target){
                l.add(candidates[i]);
                getResult(candidates, target - candidates[i], i, ls, l);
                l.remove(l.size() - 1);
            }else{
                break;
            }
        }
    }
}
