package test;

/**
 * 各位相加，其实有个简单的方法，比如一个数字每位分别是A,B,C,D
 * 就是1000*A+100*B+10*C+D = A+B+C+D + (999*A+99*B+9*C)，后面的可以被9整除
 * 所以对9取余数就可以，如果结果大于9就是递归执行，因此不需要再做操作，但是发现9的话不满足这个条件，所以减一然后结果加一就行
 */
public class AddDigits_leet258 {

    public static void main(String[] args){

    }

    public static int addDigits(int num){
        return 1 + (num - 1) % 9;
    }
}
