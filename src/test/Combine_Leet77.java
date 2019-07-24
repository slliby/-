package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯，好久没做了练下手
 */
public class Combine_Leet77 {
    public static void main(String[] args) {
        combine(4, 2);

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if(k > n || n <= 0 || k <= 0) {
            return res;
        }
        List<Integer> ls = new ArrayList<>();
        getResult(res, ls, n, k, 1);
        return res;
    }

    public static void getResult(List<List<Integer>> res, List<Integer> ls, int n, int k, int j) {
        if(ls.size() == k) {
            List<Integer> ll = new ArrayList<>(ls);
            res.add(ll);
            return;
        }

        if(j > n) {
            return;
        }
        for(int i = j; i <= n; i++) {
            ls.add(i);
            getResult(res, ls, n, k, i + 1);
            ls.remove(ls.size() - 1);
        }

    }
}
