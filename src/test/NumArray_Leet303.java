package test;

/**
 * 区域检索，数组查找，很简单的动态规划，直接计算出所有的和，然后相减就行
 */
public class NumArray_Leet303 {
    int[] sums;

    public NumArray_Leet303(int[] nums) {
        int len = nums.length;
        sums = new int[len + 1];
        sums[0] = 0;
        for(int a = 1; a < len + 1; a++){
            sums[a] = sums[a - 1] + nums[a - 1];
        }
    }

    public int sumRange(int i, int j){
        return sums[j + 1] - sums[i];

    }

    public static void main(String[] args){
        NumArray_Leet303 test = new NumArray_Leet303(new int[]{-2, 0, 3, -5, 2,-1});
        System.out.println(test.sumRange(0,2));
        System.out.println(test.sumRange(2,5));
        System.out.println(test.sumRange(0,5));
    }
}
