package test;

public class UglyNumber_Leet263 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(isUgly(125));

    }

    //判断一个数是不是丑数，也就是只能由2,3,5乘得到，很简单咯，迭代除直到为2,3,5为止

    static public boolean isUgly(int num) {
        if(num <= 0)
            return false;
        if(num == 1)
            return true;
        while(num!=2 && num!=3 && num !=5){
            if(num%2 == 0){
                num /= 2;
            }else if(num %3 == 0){
                num /= 3;
            }else if(num %5 == 0){
                num /=5;
            }else
                break;
        }
        if(num!=2 && num!=3 && num !=5)
            return false;


        return true;
    }
}
