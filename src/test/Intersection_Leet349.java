package test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 两个数组交集，没什么好说的了
 */
public class Intersection_Leet349 {

    public static void main(String[] args){

    }

    public static int[] intersection(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }

        for(int j=0;j<nums2.length;j++){
            if(set.contains(nums2[j])){
                list.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
