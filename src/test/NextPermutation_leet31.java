package test;

/**
 * 就是把一个数字最小幅度增大，做过了，从后便利即可
 */
public class NextPermutation_leet31 {

    public static void main(String[] args){

        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }

    public static void nextPermutation(int[] nums){
        if(nums.length <= 1){
            return;
        }
        int i = 0;
        int j = 0;
        for(i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                break;
            }
        }
        if(i >= 0){
            for(j = nums.length - 1; j > i; j--){
                if(nums[j] > nums[i]){
                    nums[i] ^= nums[j];
                    nums[j] ^= nums[i];
                    nums[i] ^= nums[j];
                    break;
                }
            }
        }


        for(j = i + 1; j < (nums.length + 1 + i) / 2; j++){
            //swap
            nums[j] ^= nums[nums.length + i - j];
            nums[nums.length + i - j] ^= nums[j];
            nums[j] ^= nums[nums.length + i - j];
        }
    }
}
