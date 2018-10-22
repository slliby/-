package test;

/*
思路很简单了，相同数字异或就是为0，那么做一遍相同的全抵消了就行了
说着容易。。。是因为很久以前做过一次，看过答案，印象深刻
 */
public class SingleNuber1_Leet136 {

    public static void main(String[] args){

        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }
}
