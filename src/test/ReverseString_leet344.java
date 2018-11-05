package test;

/**
 * 反转字符串，很简单的
 */
public class ReverseString_leet344 {
    public static void main(String[] args){

        String s = "hello";
        System.out.println(reverseString(s));
    }

    public static String reverseString(String s){
        char[] cs = s.toCharArray();
        char temp;
        for(int i = 0 ; i < cs.length / 2; i++){
            temp = cs[i];
            cs[i] = cs[cs.length - i - 1];
            cs[cs.length - i -1] = temp;
        }

        return String.valueOf(cs);
    }
}
