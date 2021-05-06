package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/3/31 7:51 上午
 */
public class LC84 {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            int curHeight = heights[i];

            int left = i;
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }

            int right = i;
            while (right < length - 1 && heights[right + 1] >= curHeight) {
                right++;
            }

            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;
    }


}
