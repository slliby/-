package test;

public class ToLowerClass_Leet709 {

    public static void main(String[] args){

        System.out.println('a' - 'A');
    }

    public static String toLowerCase(String str){
        char[] cs = str.toCharArray();
        for(int i=0;i<cs.length;i++){
            if(cs[i] >= 'A' && cs[i] <= 'Z')
                cs[i] += 32;
        }
        str = new String(cs);
        return str;
    }
}
