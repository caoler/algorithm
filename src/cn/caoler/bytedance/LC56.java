package cn.caoler.bytedance;

import java.util.Arrays;

/**
 * @author keji
 * @desc
 * @date 2021/3/24 10:11 下午
 */
public class LC56 {
    public int[][] merge(int[][] intervals) {
        // 按区间起始位置进行排序，升序
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] area : intervals) {
            // 没有相交的部分
            if (index == -1 || res[index][1] < area[0]) {
                res[++index] = area;
            } else {
                // 有相交的部分，取大者res[index][1] = max(area[1], res[index][1])
                res[index][1] = Math.max(area[1], res[index][1]);
            }
        }
        // res的初始化行的长度为intervals.length，合并后只有index + 1个
        return Arrays.copyOf(res, index + 1);
    }

}
