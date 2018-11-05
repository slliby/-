package test;

/**
 * 仅仅反转字母，很简单的双指针了，
 easy*/
public class ReverseOnlyLetters_leet917 {

    public static void main(String[] args){

        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public static String reverseOnlyLetters(String S){
        char[] cs = S.toCharArray();
        int i = 0;
        int j = S.length() - 1;
        while(i < j){
            if(!(cs[i] >= 'a' && cs[i] <= 'z') && !(cs[i] >= 'A' && cs[i] <= 'Z')){
                i++;
            }else if(!(cs[j] >= 'a' && cs[j] <= 'z') && !(cs[j] >= 'A' && cs[j] <= 'Z')){
                j--;
            }else {
                char temp;
                temp = cs[i];
                cs[i++] = cs[j];
                cs[j--] = temp;
            }

        }
        return String.valueOf(cs);
    }
}
