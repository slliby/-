package test;

/*
目前有一个字符，每次可以做两个操作，capy和paste，copy会覆盖上一次copy，那么得到需要的长度的最少操作次数
思路就是动态规划，得到1需要0次，然后向后遍历，每个数字需要的次数是在他前面能整除他的最大数字所需的次数加上
相除的商，深入理解下就是其实所有数字都是有这么个最大能整除的数字复制过来的，所谓的翻倍和复制操作次数一样，嘻嘻


但是这题有更好的思路，貌似是贪心法？需要用到数学证明，下次有空再提
 */

public class MinStep_Leet650 {
    public static void main(String[] args){

        System.out.println(minSteps(3));
    }

    static public int minSteps(int n) {
        int[] time = new int[n+1];
        time[1] = 0;
        for(int i=2;i<=n;i++){
            for(int j=i-1;j>0;j--){
                if(i % j == 0){
                    time[i] = time[j] + i / j;
                    break;
                }
            }
        }
        return time[n];
    }
}
