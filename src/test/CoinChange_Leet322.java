package test;

import java.util.Arrays;

public class CoinChange_Leet322 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] coins = new int[]{2};
        System.out.println(coinChange(coins, 3));
    }
    //凑零钱问题，动态规划，思路是建立一个需要兑换钱那么大的数组，从头开始便利
    //每一位的值就是兑换这么多钱所需最小值，就是把coins里面每个尝试下要兑换几个
    //在尝试下减去coins中的每个钱之后的下标所需次数加一，选择最小的作为兑换这个钱的次数，如果没有置为-1，然后输出amount位置的值即可
    static public int coinChange(int[] coins, int amount) {
        //先对coins排个序
        Arrays.sort(coins);
        int[] count = new int[amount+1];
        for(int i=1;i<=amount;i++){
            if(i<coins[0])
                count[i] = -1;
            int min = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i%coins[j]==0 && i/coins[j]<min){
                    min = i/coins[j];
                }
                if(i-coins[j]>=0 && count[i-coins[j]]!=-1 && count[i-coins[j]]+1<min){
                    min = count[i-coins[j]] + 1;
                }
            }
            if(min != Integer.MAX_VALUE)
                count[i] = min;
            else
                count[i] = -1;
        }
        return count[amount];
    }
}
