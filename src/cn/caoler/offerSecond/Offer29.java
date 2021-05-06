package cn.caoler.offerSecond;

public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        //提前约定好边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            //从左向右
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            //边界向内收缩 1
            //并且判断一下 有没有与另外一个边界重合
            if (++t > b) {
                break;
            }

            //从上往下
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }

            //从右往左
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if (b-- < t) {
                break;
            }

            //从下往上
            for (int i = b; i >= t ; i--) {
                res[x++] = matrix[i][l];
            }

            if (++l > r) {
                break;
            }
        }
        return res;
    }

}
