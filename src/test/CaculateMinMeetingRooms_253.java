package test;

import java.util.Arrays;

/**
 * 会议室问题，贪心算法，分别把开始时间与结束时间排序，那么在每个结束时间之前有几个开始时间那么就需要多少个会议室
 * 双指针滑动比较，然后取最大值
 * @Author: wangjiaping
 * @Date: 2019-07-24 09:22
 */
public class CaculateMinMeetingRooms_253 {

    public static void main(String[] args) {

    }
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int[] begin = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.parallelSort(begin);
        Arrays.parallelSort(end);
        int i = 0; int j = 0;
        int room = 0;
        int max = 0;
        while (i < intervals.length || j < intervals.length) {
            if (i < intervals.length && j < intervals.length) {
                if (begin[i] < end[j]) {
                    room++;
                    i++;
                } else {
                    room--;
                    j++;
                }
            } else if (i < intervals.length) {
                while (i < intervals.length) {
                    i++;
                    room++;
                }
            } else if (j < intervals.length) {
                while (j < intervals.length) {
                    j++;
                    room--;
                }
            }
            max = room > max ? room : max;
        }
        return max;
    }

}
