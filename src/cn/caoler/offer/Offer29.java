package cn.caoler.offer;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 顺时针打印矩阵
 */
public class Offer29 {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        //定义边界
        int     l = 0,  //左
                r = matrix[0].length - 1, //右
                t = 0, //上
                b = matrix.length - 1;  //下
        int x = 0;
        //数组大小
        int[] res = new int[(r + 1) * (b + 1)];

        /**
         * 从左向右
         * 从上向下
         * 从右向左
         * 从下向上
         */
        while (true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }
}
