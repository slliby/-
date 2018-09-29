package test;

import java.util.ArrayList;
import java.util.List;


public class LongestSubstring_Leet3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    //无重复字符的最长子串，这种题目很简单，设置个头尾指针，为了方便就用了list，然后遍历
    //如果list中包含该元素就一直移除首元素直到不包含，然后再加入，不然直接加入，每次加入判断空间是否大于最长，最后返回最长
    static public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1)
            return s.length();
        List<Character> l = new ArrayList<>();
        int len = 0;
        for(int i=0;i<s.length();i++){
            while(l.contains(s.charAt(i))){
                l.remove(0);
            }
            l.add(s.charAt(i));
            if(l.size() > len){
                len = l.size();
            }
        }

        return len;
    }

}
