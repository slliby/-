package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 和找出现次数为一半以上的思路一样，就是出现在三分之一次数以上的一定能抵消掉剩下的1/3元素
 * 并且这样的元素最多只有两个，那么很简单，设两个变量进行找就行了
 *
 * 但是有一个问题就是出现三分之一次数的一定能抵消剩下的1/3元素，但抵消后剩下的不一定一定是众数
 * 那么需要在便利一次看这两个元素出现次数，然后判断是否是需要的结果
 */
public class MajorityElement2_Leet229 {

    public static void main(String[] args){
        int[] nums = new int[]{8, 8, 7, 7, 7};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums){
        List<Integer> ls = new ArrayList<>();
        int res1 = 0;
        int res2 = 0;
        int time1 = 0;
        int time2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == res1){
                time1++;
            }else if(nums[i] == res2){
                time2++;
            }else if(time1 == 0){
                res1 = nums[i];
                time1++;
            }else if(time2 == 0){
                res2 = nums[i];
                time2++;
            }else {
                time1--;
                time2--;
            }
        }
        time1 = 0;
        time2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == res1){
                time1++;
            }else if(nums[i] == res2){
                time2++;
            }
        }

        if(time1 > nums.length / 3){
            ls.add(res1);
        }
        if(time2 > nums.length / 3){
            ls.add(res2);
        }
        return ls;
    }
}
