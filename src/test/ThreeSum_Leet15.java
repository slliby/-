package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和，很简单的思路了，就和二数之和，四数之和一样的
 */
public class ThreeSum_Leet15 {

    public static void main(String[] args){

        int[] nums = new int[]{-1, 0, 1, 2, -1, 4};
        List<List<Integer>> res = threeSum(nums);
        for(List<Integer> l : res){
            for(int i : l){
                System.out.print(i + "\t");
            }
            System.out.println("\r\n");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //  先重排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3){
            return  result;
        }

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if(nums[i] + nums[i + 1] + nums[i + 2] > 0){
                break;
            }
            if(nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0){
                continue;
            }
            int begin = i + 1;
            int end = nums.length - 1;
            int target = -1 * nums[i];
            while(begin < end){
                if(nums[begin] + nums[end] == target){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[begin]);
                    ls.add(nums[end]);
                    result.add(ls);
                    begin++;
                    while(begin < end && nums[begin] == nums[begin - 1]){
                        begin++;
                    }
                }else if(nums[begin] + nums[end] > target){
                    end--;
                }else{
                    begin++;
                }
            }
        }

        return result;
    }
}
