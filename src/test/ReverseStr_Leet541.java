package test;

/**
 * 旋转字符串
 */
public class ReverseStr_Leet541 {

    public static void main(String[] agrs){

        String s = "a";
        System.out.println(reverseStr(s, 2));
    }

    public static String reverseStr(String s, int k){
        char[] cs = s.toCharArray();
        int begin = 0;
        int end = 0;
        while(begin < s.length()){
            if(begin + 2 * k <= s.length()){
                end = begin + 2 * k;
                reverse(cs, begin, begin + k - 1);
                begin = end;
            }else if(begin + k <= s.length()){
                end = s.length();
                reverse(cs, begin, begin + k - 1);
                begin = end;
            }else {
                end = s.length();
                reverse(cs, begin, s.length() - 1);
                begin = end;
            }
        }
        return String.valueOf(cs);
    }

    public static void reverse(char[] cs, int begin, int end){
        while(begin < end){
            cs[begin] ^= cs[end];
            cs[end] ^= cs[begin];
            cs[begin] ^= cs[end];
            begin++;
            end--;
        }
    }
}
