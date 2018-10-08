package test;

/*
判断一个数的二进制表达是否是1和0交替的
很简单没难度，不说了，在leet上他也是easy难度的
 */
public class AlternatingBits_Leet693 {

    public static void main(String[] args){

        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(10));
        System.out.println(hasAlternatingBits(11));


    }

    public static boolean hasAlternatingBits(int n){
        if(n < 2)
            return true;
        int flag = n % 2;
        n /= 2;
        int newFlag = 0;
        while(n > 0){
            if(flag == n % 2)
                return false;
            flag = n % 2;
            n /= 2;
        }

        return true;
    }
}
