package test;
/*
稍加分析就能知道这是个寻找最长公共子序列的问题
那么就是可以用动态规划的思路，建立一个二位数组，比较分别到两个字符串的m位与n位所拥有的最长子序列
注意是子序列而不是子串，意味着可能是非连续的
维护也很简单，当前相等，就要从左上角的位置所拥有最长数量加1，当前不相等就是从上面和左边选择一个大的
 */
public class MinDistance_Leet583 {

    public static void main(String[] args){

        System.out.println(minDistance("food", "money"));
    }

    public static int minDistance(String word1, String word2){

        int[][] step = new int[word1.length() + 1][word2.length() + 1];
        int longest = 0;
        for(int i=1;i<word1.length()+1;i++){
            for(int j=1;j<word2.length()+1;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    step[i][j] = step[i-1][j-1] + 1;
                }else{
                    step[i][j] = Math.max(step[i-1][j], step[i][j-1]);
                }

                if(step[i][j] > longest)
                    longest = step[i][j];
            }
        }
        return word1.length() + word2.length() - 2 * longest;
    }
}
