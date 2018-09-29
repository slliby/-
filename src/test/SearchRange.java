package test;

public class SearchRange {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 6;
        int[] range = searchRange(nums, target);
        for(int i:range){
            System.out.println(i);
        }
    }
    //查找元素在有序数组中的开始结束位置，时间复杂度logn，很容易想到二分查找
    static public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1,-1};
        if(nums.length==0)
            return range;
        int begin = 0;
        int end = nums.length-1;
        int mid = 0;
        while(begin<=end){
            mid = (begin+end)/2;
            if(nums[mid] == target)
                break;
            else if(nums[mid] > target){
                end = mid-1;
            }else{
                begin = mid + 1;
            }
        }
        if(nums[mid] == target){
            int i = 0;
            for(i=mid;i>=0;i--){
                if(nums[i]!=target){
                    break;
                }
            }
            range[0] = i+1;
            int j = 0;
            for(j=mid;j<nums.length;j++){
                if(nums[j]!=target){
                    break;
                }
            }
            range[1] = j - 1;
        }


        return range;
    }

}
