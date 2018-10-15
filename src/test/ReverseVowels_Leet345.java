package test;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels_Leet345 {
    public static void main(String[] args){
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s){
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] cs = s.toCharArray();
        int begin = 0;
        int end = cs.length - 1;
        char temp;
        while(begin < end){
            while(begin < end && !set.contains(cs[begin]))
                begin++;
            while(begin < end && !set.contains(cs[end]))
                end--;
            if(begin < end){
                temp = cs[begin];
                cs[begin] = cs[end];
                cs[end] = temp;
                begin++;
                end--;
            }

        }

        String res = new String(cs);
        return res;
    }
}
