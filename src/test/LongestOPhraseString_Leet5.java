package test;

public class LongestOPhraseString_Leet5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(longestPalindrome("cbbd"));
    }
    //最长回文子串的马拉车算法
    //最长回文子串有很多解法，像什么动态规划之类的，但是马拉车算法今天仔细了解了一下，还是很巧妙的
    //他的思路归根到底是什么？网上很多都语焉不详
    //其实思路就是很简单，假如当前点在前面的某一个点的对称区间内，那么由于对称性，在这个区间内的其他值也对称
    //因此当前点和对称点的对称区间有一部分是相等的，我们找到这一部分，然后在判断是否要继续向两边扩展判断

    //那么问题是关于哪个点对称呢？总不可能全循环判断，那样太蠢了，思路就是我们在维护两个变量
    //一个标志他的对称区间辐射范围最远，也可以说最右的点的下标，另一个就标志辐射边界，当在边界内就找到对称点
    //设置点的区间，否则置0，然后再判断扩展长度
    static public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        String res = null;
        StringBuffer sb = new StringBuffer();
        //加#的目的主要就是我们不用判断奇数和偶数位置的点了，因为字母点全到了奇数位置，#全到了偶数位置
        sb.append("#");
        for(int i=0;i<s.length();i++) {
            sb.append(s.charAt(i)+"#");
        }
        String newStr = sb.toString();
        int[] len = new int[newStr.length()];

        int now = 0;//辐射最远位置的下标
        int bound = 0;//边界
        for(int i=1;i<newStr.length();i++) {
            int last = 2 * now - i;
            //不存在对称点
            if(last<0) {
                len[i] = 0;
            }else {
                //存在对称点且当前点在边界内
                if(i < bound) {
                    //为最小值
                    len[i] = Math.min(bound - i, len[last]);
                }else {
                    len[i] = 0;
                }
            }

            //然后继续向两边遍历判断是否还能更长
            while((i+len[i]+1 < len.length) &&(i-len[i]-1>=0) && newStr.charAt(i+len[i]+1) == newStr.charAt(i-len[i]-1)) {
                len[i]++;
            }
            //最后判断辐射最远位置的下标和边界是否要更新
            if(i+len[i] > bound) {
                now = i;
                bound = i + len[i];
            }
        }
        //在便利一次找到最长回文子串
        int max = 0;
        int temp = 0;
        for(int i=0;i<len.length;i++) {
            if(len[i] > max){
                max = len[i];
                temp = i;
            }
        }
        //由于每个位置上的值存的是它对应的最长子串长度，然后找到开始下标，即可
        int begin = (temp - len[temp])/2;
        res = s.substring(begin, begin + max);
        return res;
    }

}
