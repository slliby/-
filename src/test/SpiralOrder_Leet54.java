package test;

import java.util.ArrayList;
import java.util.List;
/*
螺旋读取矩阵，很简单的设四个边界指针了，不过这个代码明显有很大的优化空间
但是重要的是算法思想，优化代码的话，等我二刷吧
 */
public class SpiralOrder_Leet54 {

    public static void main(String[] args){

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> l = spiralOrder(matrix);
        for(int i : l){
            System.out.println(i);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0)
            return result;
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        int i = up;
        int j = left;
        while(up <= down && left <= right){

            while(j <= right){
                result.add(matrix[i][j]);
                j++;
            }

            up++;
            if(up > down)
                break;
            i = up;
            j--;

            while(i <= down){
                result.add(matrix[i][j]);
                i++;
            }

            right--;
            if(right < left)
                break;
            j = right;
            i--;

            while(j >= left){
                result.add(matrix[i][j]);
                j--;
            }

            down--;
            if(down < up)
                break;
            i = down;
            j++;

            while (i >= up){
                result.add(matrix[i][j]);
                i--;
            }
            left++;
            if(left > right)
                break;
            j = left;
            i++;
        }
        return result;

    }
}
