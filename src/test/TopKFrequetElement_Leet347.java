package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TopKFrequetElement_Leet347 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] nums = new int[]{1,1,1,2,2,3};
        List<Integer> l = topKFrequent(nums, 2);
        for(Integer i:l){
            System.out.println(i);
        }
    }
    //找到出现频率前k个的元素，一看题目就容易想到哈希，关键在于怎么把哈希之后的数值排序，这里重新学习了桶排序，还是比较有意思的排序算法
    //不过桶排序缺点就是空间复杂度要的比较多，创建一个大数组，然后下标为i的存储出现频次为i的元素有哪几个，存储进去
    static public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(nums[i])){
                m.put(nums[i], m.get(nums[i])+1);
            }else
                m.put(nums[i], 1);
        }

        List<Integer>[] sort = new List[nums.length+1];
        Set<Integer> keySet = m.keySet();
        for(Integer key:keySet){
            if(sort[m.get(key)] == null){
                sort[m.get(key)] = new ArrayList<>();
            }
            sort[m.get(key)].add(key);
        }
        int j = sort.length-1;
        while(k>0){
            if(sort[j] != null){
                l.addAll(sort[j]);
                k -= sort[j].size();
            }
            j--;
        }



        return l;
    }

}
