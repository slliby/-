package test;


public class SaleStock1_Leet121 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    //出售股票问题，只准卖一次，便利一次，对于一个数，是为股票价格最小值
    //遍历所有价格比他高的天知道碰到比他价格低的天，找到这些天中的最大利润
    //然后又把比他低的那天价格视为最小值，继续向后遍历，
    static public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length <= 1)
            return 0;
        int minValue = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]-minValue>max)
                max = prices[i] - minValue;

            if(minValue>prices[i])
                minValue = prices[i];
        }

        return max;
    }
}
