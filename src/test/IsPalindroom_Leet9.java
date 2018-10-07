package test;

/*
判断一个数字是不是回文数字，很简单了
首先小于0肯定不是，大于0的话就把这个数字逆序一下，
然后结果和现在这个数字一样，那么就是回文的，嘻嘻嘻
就是不要总想着去比较每一位，而是想一下回文川特征
 */
public class IsPalindroom_Leet9 {

    public static void main(String[] args){

        System.out.println(isPalindrome(-121));
    }

    static public boolean isPalindrome(int x) {

        if(x < 0){
            return false;
        }
        int res = 0;
        int y = x;
        while(y > 0){
            res = res * 10 + y % 10;
            y /= 10;
        }
        if(res == x)
            return true;


        return false;
    }
}
