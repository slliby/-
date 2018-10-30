package test;


/**
 * 如果是求众数那么需要用哈西，但是本题是求出现次数超过一半的数字
 * 那么什么叫超过一半呢？超过一半表示把这个数和数组中每个不和他想等的数字抵消了，这个数字还能留下来
 * 那么很简单了，便利一遍，碰到不想等的就抵消了，直到最后那个数字
 */
public class MajorityElement_Leet169 {

    public static void main(String[] args){

        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums){
        int res = 0;
        int time = 0;
        for(int i = 0; i < nums.length; i++){
            if(time == 0){
                res = nums[i];
                time++;
            }else if(nums[i] == res){
                time++;
            }else{
                time--;
            }
        }


        return res;
    }
}
