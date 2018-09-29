package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2_Leet90 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] nums = new int[]{1,1};
        List<List<Integer>> ls = subsetsWithDup(nums);
        for(List<Integer> l:ls){
            for(Integer i:l){
                System.out.print(i);
            }
            System.out.print("\n");
        }
    }
    //子集，不许有重复子集存在。这种题目理解了就很简单了，其实和全排列的题目一样甚至跟简单，因为全排列规定了顺序
    //这个不规定顺序，相同元素的子集就是一样，那么全排列每次都是从前向后遍历加，这个就是只加自己后面的元素就行
    //同样，不允许重复元素，那么也是加一个判断标志即可，全排列还需要判断自己是否被使用，但是这个不用，因为只会向后遍历，遍历到的都是没事用的
    //遍历到一个元素，如果和上一个相同且上一个为false，那么这个也没加进去的必要，因为在上一个为true的那个递归情况中，就已经存在了加入一个这元素的可能了
    //回溯算法说起来很复杂，但是实现起来都是一个套路，还是比较有趣
    static public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);
        getSubSet(nums,ls,l,0,flag);

        return ls;
    }

    static public void getSubSet(int[]nums,List<List<Integer>> ls,List<Integer> l,int index,boolean[] flag){
        ls.add(new ArrayList<>(l));

        for(int i=index;i<nums.length;i++){
            if(i>0 && !flag[i-1] && nums[i]==nums[i-1])
                continue;
            flag[i] = true;
            l.add(nums[i]);
            getSubSet(nums, ls, l, i+1, flag);
            flag[i] = false;
            l.remove(l.size()-1);
        }
    }

}
