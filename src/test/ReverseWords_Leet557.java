package test;

/**
 * 反转字符串
 */
public class ReverseWords_Leet557 {

    public static void main(String[] args){
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s){
        char[] cs = s.toCharArray();
        int begin = 0;
        int end = 0;
        while(begin < cs.length){
            end = s.indexOf(' ', begin);
            if(end == -1) {
                reverse(cs, begin, s.length() - 1);
                break;
            }else {
                reverse(cs, begin, end - 1);
                begin = end + 1;
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

