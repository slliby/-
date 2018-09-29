package test;

import java.util.ArrayList;
import java.util.List;


public class TelePhoneLetter_Leet17 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<String> l = letterCombinations("23");
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }
    }
    //回溯算法，在我看来，归根到底就是一个最大深度搜索，到底了在返回来看其他情况，因此使用递归来解即可
    //这题是电话号码的字符串问题，很典型
    static public List<String> letterCombinations(String digits) {
        List<String> l = new ArrayList<>();
        String[] tel = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        getString(0,digits,"",tel,l);
        return l;
    }

    static public void getString(int index,String digits,String nowString,String[] tel,List<String> l){
        //先写退出条件
        if(index == digits.length()){
            if(nowString.length() != 0){
                l.add(nowString);
            }
            return;
        }
        int temp = digits.charAt(index) - '2';
        String s = tel[temp];
        for(int i=0;i<s.length();i++){
            //nowString += s.charAt(i);这样就错了，会一直加到同一个字符串里去，因此要一个新字符串
            String nextString = nowString + s.charAt(i);
            getString(index+1,digits,nextString,tel,l);
        }
    }

}
