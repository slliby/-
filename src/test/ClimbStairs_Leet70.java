package test;

/*
爬楼梯，最基础的动态规划，用一维数组维护都很轻松
 */
public class ClimbStairs_Leet70 {

    public static void main(String[] args){
        System.out.println(climbStairs(3));

    }

    public static int climbStairs(int n){
        if(n <= 1){
            return 1;
        }
        int[] step = new int[n + 1];
        step[0] = 1;
        step[1] = 1;
        for(int i =2;i<=n;i++){
            step[i] = step[i - 1] + step[i - 2];
        }


        return step[n];
    }
}
