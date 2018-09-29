package test;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString_leet205 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(isIsomorphic("ab", "aa"));
    }

    //判断两个字符串是否是异构字符串，就是将一个单词全替换为另一个，字符串相等
    //思路就是判断对应关系，我用了两个hashmap检查其实算慢了，discuss中的是创建一个256大
    //的int数组，遍历s和t，s和t的asc码为下标的位置加一，然后判断为值是否相等，
    static public boolean isIsomorphic(String s, String t) {
        if(t.length() != s.length())
            return false;
        if(s.length() == 0)
            return true;
        Map<Character,Character> m1 = new HashMap<>();
        Map<Character,Character> m2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!m1.containsKey(s.charAt(i))){
                m1.put(s.charAt(i), t.charAt(i));
            }
            else if(m1.get(s.charAt(i)) != t.charAt(i))
                return false;

            if(!m2.containsKey(t.charAt(i))){
                m2.put(t.charAt(i), s.charAt(i));
            }
            else if(m2.get(t.charAt(i)) != s.charAt(i))
                return false;
        }

        return true;
    }
}
