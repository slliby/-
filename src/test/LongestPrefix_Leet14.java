package test;

public class LongestPrefix_Leet14 {

    public static void main(String[] args){
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestPrefix(strs));
    }

    public static String longestPrefix(String[] strs){
        StringBuffer sb1 = new StringBuffer();
        String res = "";
        if(strs.length == 0)
            return res;
        for(int i=0;i<strs[0].length();i++){
            sb1.append(strs[0].charAt(i));
            for(int j=0;j<strs.length;j++){
                if(!strs[j].startsWith(sb1.toString())){
                    return res;
                }
            }
            res = sb1.toString();
        }

        return res;
    }
}
