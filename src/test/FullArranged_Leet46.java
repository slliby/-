package test;

import java.util.ArrayList;
import java.util.List;

public class FullArranged_Leet46 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] nums = new int[]{0,-1,1};
        List<List<Integer>> ls = permute(nums);
        for(List<Integer> l:ls){
            for(Integer i:l){
                System.out.println(i);
            }
            System.out.println("----------");
        }

    }
    //
    static public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        getPermute(nums, l, ls);
        return ls;
    }

    static public void getPermute(int[] nums,List<Integer> l,List<List<Integer>> ls){
        //退出条件
        if(nums.length == 0){
            //不为0
            if(l.size() != 0){
                ls.add(l);
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            //新数组
            int[] newNums = new int[nums.length-1];
            int index = 0;
            for(int j=0;j<nums.length;j++){
                if(i!=j)
                    newNums[index++] = nums[j];
            }
            //新list
            List<Integer> newList = new ArrayList<>();
            newList.addAll(l);
            newList.add(nums[i]);
            getPermute(newNums, newList, ls);

        }


    }
}
