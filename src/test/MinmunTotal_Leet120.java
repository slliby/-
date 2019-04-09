package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 很简单的动态规划
 * @author wangjiaping
 * @date 2019-04-09
 */
public class MinmunTotal_Leet120 {

    public static void main(String[] aargs) {

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        List<Integer> last = triangle.get(triangle.size() - 1);
        int[] length = new int[last.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> now = triangle.get(i);
            for (int j = 0; j < now.size(); j++) {
                length[j] = Integer.min(length[j], length[j + 1]) + now.get(j);
            }
        }

        return length[0];
    }
}
