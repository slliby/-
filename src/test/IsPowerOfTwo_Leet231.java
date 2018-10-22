package test;
/*
判断一个数字会否是2的幂，很简单其实。。不需要逐位计算。
直接找到整型范围内最大，然后去除以我们的数字，余数为0就是true，否则false
3的幂也是这么求，因为它两都是质数
 */
public class IsPowerOfTwo_Leet231 {

    public static void main(String[] args){
        System.out.println(isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int n){
        if(n <= 0)
            return false;
        int max = (int) Math.pow(2,30);
        if(max % n == 0){
            return true;
        }
        return false;

    }
}
