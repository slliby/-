package test;

public class JumpGame_Leet55 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


    /*从后向前维护，运行较慢，因为便利的元素更多
    static public boolean canJump(int[] nums) {
        int len = nums.length;
        //长度不足1，直接成功
        if(len <= 1)
            return true;
        //1标记能到末尾
        nums[len - 1] = 1;
        for(int j=len-2;j>=0;j--) {
            int i = nums[j];
            nums[j] = 0;
            for(int k=1;(k+j)<len && k<=i;k++) {
                if(nums[j+k] == 1) {
                    nums[j] = 1;
                    break;
                }
            }
        }

        return nums[0] == 1 ? true : false;
    }
    */
    //从前向后维护能到达的最右边界
    static public boolean canJump2(int[] nums) {
        int len = nums.length;
        //长度不足1，直接成功
        if(len <= 1)
            return true;
        //标记能到达的最右
        int reach = 0;
        int i = 0;
        for(i=0;i<=reach&&i<len;i++) {
            reach = reach > (i + nums[i]) ? reach : (i + nums[i]);
        }
        //说明到了能到的又边界倒是没到头
        if(i < len)
            return false;
        return true;

    }
}
