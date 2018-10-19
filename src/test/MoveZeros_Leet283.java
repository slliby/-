package test;
/*
移动数组的0全到后面，同时非0元素相对位置不变
很简单了，一次便利，双指针，一个移动，非0元素时另一个上位置设为这个
然后最后后面元素全部置零，ok
 */
public class MoveZeros_Leet283 {

    public static void main(String[]args){

        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for(int i : nums)
            System.out.println(i);
    }

    public static void moveZeroes(int[] nums){
        int len = nums.length;
        if(len <= 1)
            return;

        int i = 0;
        int j = 0;
        while(j < len){
            if(nums[j] != 0){
                nums[i++] = nums[j];
            }
            j++;
        }
        while(i < len){
            nums[i++] = 0;
        }
    }
}
