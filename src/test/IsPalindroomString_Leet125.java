package test;

public class IsPalindroomString_Leet125 {

    public static void main(String[] args){

    }

    public static boolean isPalindroom(String s){

        char[] b = s.toLowerCase().toCharArray();
        int len = b.length;
        if(b.length <= 1)
            return true;
        int i = 0;
        int j = len - 1;
        while(i < j){
            while((i < j) && !(b[i] >= 'a' && b[i] <= 'z') && !(b[i] >= '0' && b[i] <= '9')){
                i++;
            }
            while((i < j) && !(b[j] >= 'a' && b[j] <= 'z') && !(b[j] >= '0' && b[j] <= '9')){
                j--;
            }

            if(i >= j){
                return true;
            }else if(b[i] != b[j]){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
