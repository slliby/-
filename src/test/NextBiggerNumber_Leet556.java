package test;

import java.util.ArrayList;
import java.util.List;


/*
就是把一个正整数，把它所有位上的数字可以自由组合，怎么找到这些排列中刚好比原来数字大的最小数字
就是增长幅度最小，这题也不能说简单，但是得感谢我的室友，我们当初讨论过这道题
这题是能在O(n)的时间复杂度内解决的，思考一下怎么才能让它变大，很简单，从一个位置后面找一个比他大的数字交换一下就变大了
假如从个位向高位都是递增的，那么就不能变更大了，所以我们可以从后向前便利，找到第一个非递增位，然后从比他低的位里去找
找到那个比他大的最小数，也很简单，因为到这个点才不是递增的，那么比他低的位都是递增的，就很容易找了，找完之后，看起来是变大了
但是并不是比他大的最小值，为什么呢？因为比他低的位数上是大的数字在高位，小的数字在低位，可以把小的放高位，大的放低位，那么就满足了
只要这一位变大了，那这个数字就是变大了的，而由于交换了之后还是递增的，那么把整个这些位旋转就行了，这个是需要一些数论的基础的

 */
public class NextBiggerNumber_Leet556 {
    public static void main(String[] args){

        System.out.println(nextGreaterElement(123456789));
    }

    public static int nextGreaterElement(int n){
        //如果一开始就到了上限或者为1位数，那么就不需要进行判断了，肯定不满足
        if(n == Integer.MAX_VALUE || n < 10)
            return -1;
        List<Integer> l = new ArrayList<>();
        int m = n;
        //每一位放入数组保存
        while(m > 0){
            l.add(m % 10);
            m /= 10;
        }
        //找到第一个可交换变大的位
        int i = 1;
        for(i=1;i<l.size();i++){
            if(l.get(i) < l.get(i - 1))
                break;
        }
        System.out.println("i: " + i);
        if(i == l.size())
            return -1;
        //找到刚好比他大的位和他交换
        int j = 0;
        for(j=0;j<i;j++){
            if(l.get(j) > l.get(i)){
                int temp = l.get(i);
                l.set(i, l.get(j));
                l.set(j, temp);
                break;
            }
        }
        System.out.println("j: " + j);
        //旋转后面部分，使得增长最小
        for(int k=0;k<(i + 0) /2;k++){
            int temp = l.get(k);
            l.set(k, l.get(i - k - 1));
            l.set(i - k - 1, temp);
        }
        long res = 0;
        //取出结果
        for(i=l.size()-1;i>=0;i--){
            res = res * 10 + l.get(i);
        }
        //有可能交换后结果超出范围了，需要判断
        if(res > Integer.MAX_VALUE)
            return -1;

        return (int)res;
    }
}
