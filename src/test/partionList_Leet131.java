package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个字符串可以被拆分成多少个回文字符串，简单的回溯法，需要多谢一个判断回文而已
 * @author wangjiaping
 * @date 2019-04-17
 */
public class partionList_Leet131 {

    public static void main(String[] args) {

        String s = "aab";
        List<List<String>> res = partition(s);
        res.forEach(l -> {
            l.forEach(i -> {
                System.out.print(i + "\t");
            });
            System.out.print("\n");
        });
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        List<String> list = new ArrayList();
        resolver(s, result, list, 0, s.length() - 1);
        return result;
    }

    public static void resolver(String s, List<List<String>> result, List<String> list, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            result.add(list);
            return;
        }
        for(int i = beginIndex; i <= endIndex; i++) {
            if (checkPalindrome(s, beginIndex, i)) {
                List<String> newList = new ArrayList(list);
                newList.add(s.substring(beginIndex, i + 1));
                resolver(s, result, newList, i + 1, endIndex);
            }
        }
    }

    public static boolean checkPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
