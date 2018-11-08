package test;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题，其实也就是递归，但是可以简化成一个一维数组标记位置被占了
 * 然后从上向下每行选择列，那么行和列都可以不重复了
 */
public class NQueens_Leet51 {

    public static void main(String[] args){

        List<List<String>> result = solveNQueens(15);
        for(List<String> l : result){
            for (String s : l){
                System.out.println(s);
            }
            System.out.println("**********");
        }
    }

    public static List<List<String>> solveNQueens(int n){
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        List<String> ls = new ArrayList<>();
        getResult(result, ls, used,0);

        return result;
    }

    /**
     *
     * @param result,结果
     * @param ls，每次元素链表
     * @param used，标记是否当前列被占了
     * @param row，第几行
     */
    public static void getResult(List<List<String>> result, List<String> ls, boolean[] used, int row){
        //到底了执行完成一次，把当前链表加入结果集合
        if(row == used.length){
            List<String> l = new ArrayList<>(ls);
            result.add(l);
            return;
        }

        //否则从当前行循环所有列看能不能找到合适的，行不用判断，因为一行选一个
        for(int i = 0; i < used.length; i++){
            //当前列有了
            if(used[i]){
                continue;
            }
            //不为空，判断对角线上有没有
            if(!ls.isEmpty()){
                boolean flag = false;
                int col = i;
                for(int j = ls.size() - 1; j >= 0; j--){
                    //其实就是当前行减去前面的行的值等于这一列减去前面对应的Q所在的列的绝对值，相等就是在对角线上
                    int index = ls.get(j).indexOf("Q");
                    if(row - j == Math.abs(i - index)){
                        flag = true;
                        break;
                    }
                }
                //在对角线上也跳过，不能
                if(flag){
                    continue;
                }
            }

            //构造一行
            int k = 0;
            StringBuffer sb = new StringBuffer();
            while(k < i){
                sb.append(".");
                k++;
            }
            sb.append("Q");
            k++;
            while(k < used.length){
                sb.append(".");
                k++;
            }
            String s = sb.toString();
            ls.add(s);
            used[i] = true;
            //向下一行查找
            getResult(result, ls, used, row + 1);
            //把改动修改回来，进行回溯
            used[i] = false;
            ls.remove(s);


        }
    }

}
