package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/4/2 7:05 上午
 */
public class LC85 {


    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            maxArea = Math.max(largestRectangleArea(heights), maxArea);
        }
        return maxArea;
    }


    /**
     * 84题
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int curHeight = heights[i];

            int left = i;
            int right = i;
            while (left > 0 && curHeight <= heights[left - 1]) {
                left--;
            }
            while (right < heights.length - 1 && curHeight <= heights[right + 1]) {
                right++;
            }

            int wid = right - left + 1;
            res = Math.max(res, wid * curHeight);
        }
        return res;
    }
}
