package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FullArranged2_Leet42 {

    public static void main(String[] args){
        int[] nums = new int[]{3,3,0,3};
        List<List<Integer>> ls = permuteUnique(nums);
        for(List<Integer> l:ls){
            for(Integer i:l){
                System.out.println(i);
            }
            System.out.println("-----");
        }
    }

    static public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> l =new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        //方法二要先排序
        Arrays.sort(nums);
        //getPermuteUnique(nums, l, ls);
        getPermuteUnique2(nums, flags, ls, l);
        return ls;
    }
    //不重复的全排列，我的想法也是一个个加进去，但是我加进去时判断是否已经有了这个list了，，没有才加进去，
    //而在网上看到的思路是他从一开始就设定一个标技数组，每一位都是false，然后把输入数组县排序，然后遍历添加，添加前先判断是否
    //当前标记为true，就表示添加过了，或者当前位置大于1，他与前一位值相等。前一位标记为false，这说明了什么呢，说明了两个数字相同时，这个顺序添加一次就行了
    //那么在前一位的递归中就有了这一步，因此我们这时候就跳过，这种思路比较神奇，说实话暂时我还想不出来。。。
    static public void getPermuteUnique(int[] nums,List<Integer> l,List<List<Integer>> ls){
        //退出条件
        if(nums.length == 0){
            //还不能重复，因此判断是否有了
            if(l.size()!=0 && !ls.contains(l)){
                ls.add(l);
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            int[] newNums = nums.clone();
            //好的复制方法，只删除某一个元素，就是先把这个元素和最后交换，然后数组缩容
            int temp = newNums[i];
            newNums[i] = newNums[newNums.length-1];
            newNums[newNums.length-1] = temp;
            newNums = Arrays.copyOf(newNums, newNums.length-1);

            //复制List
            List<Integer> newList = new ArrayList<>();
            newList.addAll(l);
            newList.add(nums[i]);
            getPermuteUnique(newNums, newList, ls);
        }

    }

    //网上方法
    static public void getPermuteUnique2(int[] nums,boolean[] flags,List<List<Integer>> ls,List<Integer> l){
        //退出条件
        if(l.size() == nums.length){
            if(l.size() != 0){
                //这里不能直接把l放进去，为什么呢？我的理解是因为他这里l没有变得，从始至终是同一个l
                //而前面的我的方法里是复制一个进行地柜，因此可以直接插入，这样看起来他这个在最后才创建一个新list似乎好一些
                ls.add(new ArrayList<>(l));
            }
            return;
        }

        for(int i=0;i<nums.length;i++){
            //这时跳过，已经有这一组了
            if(flags[i] || (i>0 && !flags[i-1] && nums[i]==nums[i-1]))
                continue;
            l.add(nums[i]);
            flags[i] = true;
            //递归
            getPermuteUnique2(nums, flags, ls, l);
            //添加其他元素的尝试，其实就是回溯
            flags[i] = false;
            l.remove(l.size()-1);
        }
    }
}
