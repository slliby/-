package test;

public class JumpGame2_Leet45 {

    /*
     * 计算最短步数调到末尾，也是可以从后向前动态规划
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = new int[] {2,3,0,1,4};

        System.out.println(jump(nums));
    }
    /*动态规划
    static public int jump(int[] nums) {
        int len = nums.length;
        //长度小于等于1，0步
        if(len <= 1)
            return 0;
        nums[len - 1] = 0;
        for(int i=len-2;i>=0;i--) {
            int step = nums[i];
            int min = 100000;
            for(int j=i+1;j<len && j<=(i+step);j++) {
                min = Math.min(min, nums[j]+1);
            }
            nums[i] = min;
        }

        return nums[0];
    }
    */
    //但是最好的还是贪心算法,其实就是维护同样步数能跳的最远的距离
    //就是同样的步数能跳的范围在一个区间内，我们只记录开头和结尾
    //然后继续遍历这个区间，继续维护下一步的范围，当然，每个区间的开头必然在上一个区间之后的
    //当有一步能到末尾了，就满足，可以跳出
    static public int jump(int[] nums) {
        int len = nums.length;
        //长度小于等于1，0步
        if(len <= 1)
            return 0;

        int begin = 0;
        int end = 0;
        int num = 0;
        int max = 0;
        while(true) {
            for(int i=begin;i<=end;i++) {
                max = Math.max(max, nums[i] + i);
            }
            num++;
            if(max >= len - 1) {
                break;
            }

            begin = end + 1;
            end = max;
        }

        return  num;
    }

}
