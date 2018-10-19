package test;

/*
合并两个有序数组，初学者都应该会的题目了
从后向前合并
 */
public class MergeArrays_Leet88 {
    public static void main(String[] args){

        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        for(int i : nums1){
            System.out.println(i);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1;
        int j = n - 1;
        int end = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[end--] = nums1[i--];
            }else{
                nums1[end--] = nums2[j--];
            }
        }

        while(i >=0 ){
            nums1[end--] = nums1[i--];
        }
        while(j >= 0){
            nums1[end--] = nums2[j--];
        }
    }
}
