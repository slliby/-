package test;

import java.util.*;

/*
4数之和问题，其实这种ksum貌似都是只能分解，最后成为了2sum问题，没什么更简单的方法了
 */
public class SumOfThreeNumber_Leet18 {
    public static void main(String[] args){

        int[] nums = new int[]{0,4,-5,2,-2,4,2,-1,4};
        List<List<Integer>> ls = fourSum(nums, 12);
        for(List l : ls){
            for(int i=0;i<l.size();i++){
                System.out.print(l.get(i) + "\t");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> fourSum(int[] nums, int target){
        /*这时我的思路，大体和别人代码相同，但是大神的神在于把边界条件判断的特别好，进行了跳过
        看完了大神的代码尝试复现下
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int k = j + 1;
                int z = nums.length - 1;
                int goal = target - nums[i] - nums[j];
                while(k < z){
                    if(nums[k] + nums[z] == goal){
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        l.add(nums[z]);
                        ls.add(l);
                        k++;
                        while(k < z && nums[k] == nums[k-1]){
                            k++;
                        }
                    }else if(nums[k] + nums[z] < goal){
                        k++;
                    }else{
                        z--;
                    }
                }
            }
        }

        return ls;
        */
        List<List<Integer>> ls = new ArrayList<>();
        //长度不足4，ok，肯定不满足，直接返回
        if(nums.length < 4)
            return ls;
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<nums.length-3;i++){
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {//以当前点向后取最小的三个都比目标大，那么之后就再也找不到了，排好序了往后结果只会更大
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){//跳过重复的
                continue;
            }

            if(nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target){//类似，以当前点向后能取到的最大结果逗比目标小，那么在当前点就不可能找到，要往后找
                continue;
            }
            int goal1 = target - nums[i];
            for(int j=i+1;j<nums.length-2;j++){
                if(j > i+1 && nums[j] == nums[j - 1]){
                    continue;
                }
                if(nums[j] + nums[len - 2] + nums[len - 1] < goal1){//和上面步骤一样重复
                    continue;
                }
                int goal2 = goal1 - nums[j];
                int k = j + 1;
                int z = len - 1;
                while(k < z){//twosome问题了，就是两边指针同时向中间移动，因为有序，两边相加大于目标右边移动，小于左边移动
                    if(nums[k] + nums[z] == goal2){
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        l.add(nums[z]);
                        ls.add(l);
                        k++;
                        while(k < z && nums[k] == nums[k-1]){
                            k++;
                        }
                    }else if(nums[k] + nums[z] < goal2){
                        k++;
                    }else{
                        z--;
                    }
                }
            }
        }



        return ls;
    }

}
