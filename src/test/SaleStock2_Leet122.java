package test;


public class SaleStock2_Leet122 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    //出售股票问题，不限定次数,也很简单，便利一次，对于每天，设定为最小值，然后向后遍历
    //当天价格比前一天高就一直想后，停下时昨天价格减去最小价格就是之前那么些天最大利润
    //然后把当天价格设置为最低继续向后循环
    //但是要注意的是最后跳出循环时很可能最后一天减去最小价格这一步可能没加上，因此要判断

    static public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int maxValue = prices[0];
        int minValue = prices[0];
        int sum = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i] > maxValue){
                maxValue = prices[i];
            }else{
                sum += maxValue - minValue;
                maxValue = prices[i];
                minValue = prices[i];
            }
        }
        if(maxValue > minValue)
            sum += maxValue - minValue;
        return sum;
    }
}
