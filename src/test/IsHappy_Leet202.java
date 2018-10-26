package test;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断是否快乐数，很简单了，一个set存储上一次数值，
 * 如果出现了循环就说明不可能了
 */
public class IsHappy_Leet202 {

    public static void main(String[] args){

    }

    public boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            int res = 0;
            while(n > 0){
                res += (n % 10) * (n % 10);
                n /= 10;
            }

            n = res;
            if(n == 1)
                return true;
        }

        return false;
    }
}
