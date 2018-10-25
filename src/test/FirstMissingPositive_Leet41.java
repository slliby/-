package test;

/*
 *找第一个缺失的正数，思路很简单也很容易想，就是把对应的数字放在对应位置上
 * 然后找对应位置上不是对应数字的那么就是缺失了
 *
 * 但是不同之处在于这个的放在对应位置上需要有判断
 * 首先，当前位置上数字超过了数字下标范围就不换，因为没地方放
 * 小于等于0也不放，因为也没地方放，然后就是当前位置和他应该被放在的位置上数字一样时，也不用换
 * 因为重复了，知道这些这代码就很好写了，对吧
 */
public class FirstMissingPositive_Leet41 {

    public static void main(String[] args){

        int[] nums = new int[]{7,8,9,11,12};
        System.out.println(firstMissingpositive(nums));
    }

    public static int firstMissingpositive(int[] nums){
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i] <= 0 || nums[i] == i + 1 || nums[i] > len || nums[i] == nums[nums[i] - 1])
                continue;

            //exchange nums[i],nums[nums[i] - 1],
            int temp = nums[i];
            nums[i] = nums[nums[i] - 1];
            nums[temp - 1] = temp;
            i--;
        }
        for(int j = 0;j < len;j++){
            if(nums[j] != j + 1)
                return j + 1;
        }

        return len + 1;
    }
}
