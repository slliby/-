package test;

import java.util.ArrayList;
import java.util.List;


public class SubSet_Leet78 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ls = subsets(nums);
        for(List<Integer> l:ls){
            for(Integer i:l){
                System.out.print(i);
            }
            System.out.print("\n");
        }
    }

    //获取子集问题，开始想不出来，走入误区，想到了index标志，但是循环内部写错了，其实可以直接简单的依次移除来就行
    static public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        int index = 0;
        getSubSet(nums, ls, l, 0);

        return ls;
    }
    static public void getSubSet(int[] nums,List<List<Integer>> ls,List<Integer> l,int index){
        ls.add(new ArrayList<>(l));

        for(int i=index;i<nums.length;i++){
            l.add(nums[i]);
            getSubSet(nums, ls, l, i+1);
            l.remove(l.size()-1);
        }

    }
}
