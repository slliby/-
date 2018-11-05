package test;

public class NumSquares_Leet279 {

    public static void main(String[] args){

        System.out.println(numSquares(13));
    }

    public static int numSquares(int n){
        /**
         * 我的思路就是很普通的动态规划，太慢了，有更快的动态规划，当然还有找规律，这个后面再推
        if(n <= 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }
        int[] nums = new int[n + 1];
        int i = 1;
        int num = 1;
        while(i <= n){
            if(i == num * num){
                nums[i] = 1;
                num++;
            }else {
                nums[i] = 10000;
                for(int j = i / 2; j < i; j++){
                    nums[i] = Math.min(nums[i], nums[j] + nums[i - j]);
                }
            }
            i++;
        }

        return nums[n];
         */
        /**
         * 更巧妙动态规划，从前面往后更新，我的思路是往前面查找更新自己，而这个是向后移动过程中更新后面
         *
         */
        if(n <= 0){
            return 0;
        }
        int[] nums = new int[n + 1];
        for(int i = 0; i <= n; i++){
            nums[i] = Integer.MAX_VALUE;
        }
        nums[0] = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 1; i + j * j <= n; j++){
                nums[i + j * j] = Math.min(nums[i + j * j], nums[i] + 1);
            }
        }
        return nums[n];
    }
}
