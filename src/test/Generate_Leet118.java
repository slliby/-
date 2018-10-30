package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角，不想提了
 */
public class Generate_Leet118 {

    public static void main(String[] args){

        List<List<Integer>> ls = generate(5);
        for(List<Integer> l : ls){
            System.out.print("[");
            for(int i : l){
                System.out.print(i + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        int len = 0;
        for(int i = 0; i < numRows; i++){
            List<Integer> ls = new ArrayList<>();
            if(i == 0){
                ls.add(1);
                res.add(ls);
                continue;
            }

            len++;
            List<Integer> last = res.get(res.size() - 1);
            for(int j = 0; j <= len; j++){
                int num = (j - 1 >= 0 ? last.get(j - 1) : 0) + (j < len ? last.get(j) : 0);
                ls.add(num);
            }
            res.add(ls);
        }

        return res;
    }
}
