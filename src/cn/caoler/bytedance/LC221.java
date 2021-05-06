package cn.caoler.bytedance;

/**
 * @author keji
 * @desc 最大正方形
 *
 * 若形成正方形（非单 1），以当前为右下角的视角看，则需要：当前格、上、左、左上都是 1
 * 可以换个角度：当前格、上、左、左上都不能受 0 的限制，才能成为正方形
 *
 *
 * 递推公式
 * // 伪代码
 * if (grid[i - 1][j - 1] == '1') {
 *     dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
 * }
 *
 *https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
 *
 * @date 2021/3/26 3:18 下午
 */
public class LC221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int max = 0;
        int height = matrix.length;
        int wight = matrix[0].length;

        //任何一个正方形，我们都「依赖」当前格 左、上、左上三个方格的情况
        //但第一行的上层已经没有格子，第一列左边已经没有格子，需要做特殊 if 判断来处理
        //为了代码简洁，我们 假设补充 了多一行全 '0'、多一列全 '0'
        //因为不赋值的情况下，默认都是0，那么相当于左边和上面各自多加了一列和一行，并且赋值为0
        int[][] dp = new int[height + 1][wight + 1];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wight; j++) {
                //只有当前格子为1才去判断他的上和左和左上
                if (matrix[i][j] == '1') {

                    //dp 具体定义：dp[i + 1][j + 1] 表示 「以第 i 行、第 j 列为右下角的正方形的最大边长」
                    //为什么不是dp[i][j] 的原因如上初始化的时候
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max * max;
    }
}
