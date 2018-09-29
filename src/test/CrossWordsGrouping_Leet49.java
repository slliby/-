package test;

import java.util.*;

public class CrossWordsGrouping_Leet49 {


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ls = groupAnagrams2(strs);
        for(List<String> l:ls){
            for(String s:l){
                System.out.println(s);
            }
            System.out.println("-------------");
        }

    }
    //整理字母异位词，重点在于判断两个单词是异位词，判断方法有两种，一种是判断长度相等然后判断每个字母数量相等
    //另一种是先把字母排序，然后判断两个字母是否相等，相等就是异位词
    static public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ls = new ArrayList<>();

        //先转换成字符数组，排好序然后又便会字符串放回数组
        String[] str2 = new String[strs.length];
        for(int i=0;i<strs.length;i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            str2[i] = new String(charArray);
        }
        for(int j=0;j<str2.length;j++){

            //没被加进去
            if(str2[j] != null){
                List<String> l = new ArrayList<>();
                l.add(strs[j]);
                for(int k=j+1;k<str2.length;k++){
                    //排列后相等说明是异位词或者原来就相等
                    if(str2[j].equals(str2[k])){
                        //if(!strs[j].equals(strs[k]))，这一步不需要。。。因为题目中重复元素也加进去，重叠，牛逼了
                        l.add(strs[k]);

                        str2[k] = null;
                    }
                }
                //加入到链表
                ls.add(l);
            }
        }


        return ls;
    }
    //discuss中思路很棒，是用一个哈希表来保存，把每个单词排序之后的新单词作为key，value是一个数组，把原来值存到数组中。。很牛逼了
    static public List<List<String>> groupAnagrams2(String[] strs){
        List<List<String>> ls = new ArrayList<>();
        //map存储sort后的值和原来值
        Map<String,List<String>> m = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String keyString = new String(charArray);
            //然后判断并加入哈希表,很巧妙了可以说是
            if(m.containsKey(keyString)){
                List<String> l = m.get(keyString);
                l.add(strs[i]);
                m.put(keyString, l);
            }else{
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                m.put(keyString, l);
            }

        }
        Set<String> s = m.keySet();
        for(String key:s){
            List<String> l = m.get(key);
            ls.add(l);
        }
        return ls;

    }
}
