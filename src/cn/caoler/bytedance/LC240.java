package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/4/2 7:41 上午
 */
public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
