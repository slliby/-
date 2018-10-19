package test;
/*
删除有序数组的重复项，最多允许两个相同的连续项
我的思路还是双指针，大神的思路

大神思路，因为数组有序，那么就判断一个数字是否比他两位之前的大，大的话那么就目前为止肯定不是连续的
否则连续的，那前两位这样比不了就可以直接放入
 */
public class RemoveDuplicates2_Leet80 {

    public static void main(String[] args){

        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums){
        /*我的思路就是下面，比人家慢太多了
        int len = nums.length;
        if(len <= 1)
            return len;

        int num = 0;
        int i = 1;
        int j = 1;
        while(j < len) {
            if(nums[j] == nums[j - 1]){
                num++;
            }else{
                num = 0;
            }
            if(num < 2){
                nums[i++] = nums[j];
            }else{
                while(j < len - 1 && nums[j + 1] == nums[j]){
                    j++;
                }
                num = 0;
            }
            j++;
        }
        return i;
        */

        int i = 0;
        int j = 0;
        for(j=0;j<nums.length;j++){
            if(i < 2 || nums[j] > nums[i - 2]){
                nums[i++] = nums[j];
            }
        }

        return i;
    }
}
