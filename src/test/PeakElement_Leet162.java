package test;

public class PeakElement_Leet162 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] nums = new int[]{1,3,2,1};
        System.out.println(findPeakElement(nums));
    }

    //寻找峰值元素，时间复杂度logn，想法是二分查找，既然本来不一定有序，那么对左右都要继续二分查找
    //思路很简单，代码很简单，尴尬的是我写的返回值而不是返回下标，妈嗨
    static public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        int res = findPeak(nums,0,nums.length);


        return res;
    }
    static public int findPeak(int[] nums,int begin,int end){
        if(begin>end)
            return -1;

        int mid = (begin+end)/2;
        if(mid==0){
            if(nums[mid]>nums[mid+1])
                return mid;
        }else if(mid==nums.length-1){
            if(nums[mid]>nums[mid-1])
                return mid;
        }else{
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
                return mid;
        }


        if(findPeak(nums, begin, mid-1)!=-1){
            return findPeak(nums, begin, mid-1);
        }
        if(findPeak(nums, mid+1,end)!=-1){
            return findPeak(nums, mid+1,end);
        }

        return -1;

    }
}
