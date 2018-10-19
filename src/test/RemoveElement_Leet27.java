package test;

/*
移除数组中值为给定值元素，也是双指针，很
 easy了
 */
public class RemoveElement_Leet27 {

    public static void main(String[] args){

    }

    public static int removeElement(int[] nums, int val){
        int len = nums.length;
        if(len == 0)
            return 0;

        int i = 0;
        int j = 0;
        while(j< len){
            if(nums[j] != val){
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
