package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/4/13 5:33 下午
 */
public class TEST {
    int length;
    char[] array;
    int rows;
    int cols;
    boolean[][] used;
    int[][] LIST = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        length = word.length();
        array = word.toCharArray();
        rows = board.length;
        cols = board[0].length;
        used = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dfs(board, i, j, 0 )) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int begin) {
        if (!inArea(i,j) || used[i][j]) return false;
        if(begin == length - 1) return board[i][j] == array[begin];
        if (board[i][j] == array[begin]) {
            used[i][j] = true;
            for (int[] ints : LIST) {
                int x = ints[0] + i;
                int y = ints[1] + j;
                if(dfs(board, x ,y, begin +1)) {
                    return true;
                }
            }
            used[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int i, int j) {
        if(i < 0 || i >= rows || j < 0 || j >= cols){
            return false;
        }
        return true;
    }

}
