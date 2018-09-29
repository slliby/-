package test;

public class KLargestNumber_Leet215 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        quickSort(nums, 0, nums.length-1);

        System.out.println(findKthLargest(nums, 4));
        System.out.println(findKthLargest2(nums, 4));
    }
    //寻找第k大的元素，我的想法是先排序，然后直接找，这样时间复杂度取决于排序算法时间复杂度，我写的是快拍，并不是很快
    //网上思路：，遍历两遍，第一遍找到最大值和最小值，然后直接定义个这么大数组，那么所有取值减去最小值的差作为下标，放进来数量，然后就能找到第k个最大元素了

    static public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);

        return nums[nums.length-k];
    }
    static public void quickSort(int[]nums,int begin,int end){
        if(begin>=end)
            return;
        int temp = nums[begin];
        int i = begin;
        int j = end;

        while(i<j){
            while(j>i && nums[j]>=temp)
                j--;
            if(j>i){
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
            }
            while(i<j && nums[i]<=temp)
                i++;
            if(i<j){
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
            }
        }
        nums[i] = temp;
        quickSort(nums, begin, i-1);
        quickSort(nums, i+1, end);
    }


    //discuss思路
    static public int findKthLargest2(int[] nums, int k){
        int max = nums[0];
        int min = nums[0];
        int res = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max)
                max = nums[i];
            if(nums[i]<min)
                min = nums[i];
        }

        int[] arrange = new int[max-min+1];
        for(int i=0;i<nums.length;i++){
            arrange[nums[i]-min]++;
        }
        int index = arrange.length-1;

        while(k>0){
            k -= arrange[index];
            res = index+min;
            index--;
        }
        return res;
    }


}
