package test;

/*
删除已排序数组重复元素，也很简单，都是双指针
 */
public class RemoveDuplicates_leet26 {

    public static void main(String[] args){

    }

    public static int removeDuplicates(int[] nums){
        int len = nums.length;
        if(len <= 1)
            return len;

        int i = 1;
        int j = 1;
        while(j < len){
            if(nums[j] != nums[j - 1]){
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
