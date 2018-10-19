package test;

public class KLargestNumber_Leet215 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        //quickSort(nums, 0, nums.length-1);

        //System.out.println(findKthLargest(nums, 4));
        //System.out.println(findKthLargest2(nums, 4));
        System.out.println(findKthLargest3(nums, 4));
    }
    //寻找第k大的元素，我的想法是先排序，然后直接找，这样时间复杂度取决于排序算法时间复杂度，我写的是快拍，并不是很快
    //网上思路1：，遍历两遍，第一遍找到最大值和最小值，然后直接定义个这么大数组，那么所有取值减去最小值的差作为下标，放进来数量，然后就能找到第k个最大元素了


    //直接快排思路，142ms运行时间
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


    //discuss思路，这种思路时间复杂度其实还好，但是空间复杂度太大，运行时间6ms
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



    //大神思路，就是快排，但是每次快排特性在于能把一个点放到最终位置，那么判断这个位置和k的比较
    //大于k就继续快排起左边，小于就快排其右边,时间57ms，但是优势在于不需要额外空间
    //假如到了那种在100w个元素中查找时，就会很有利
    static public int findKthLargest3(int[] nums, int k){
        int index = 0;
        int begin = 0;
        int end = nums.length - 1;
        while(true){
            int temp = nums[begin];
            int m = begin;
            int n = end;
            while(m < n){
                while(n > m && nums[n] <= temp){
                    n--;
                }
                if(n > m){
                    nums[m] ^= nums[n];
                    nums[n] ^= nums[m];
                    nums[m] ^= nums[n];
                }
                while(m < n && nums[m] > temp){
                    m++;
                }
                if(m < n){
                    nums[m] ^= nums[n];
                    nums[n] ^= nums[m];
                    nums[m] ^= nums[n];
                }
            }
            nums[m] = temp;
            index = m;
            if(index == k - 1){
                break;
            }else if(index > k - 1){
                end = index - 1;
            }else{
                begin = index + 1;
            }

        }

        return nums[index];
    }

}
