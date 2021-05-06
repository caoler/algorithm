package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/4/7 5:30 下午
 */
public class LC79II {
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
            boolean res = dfs(board, i + 1, j, begin + 1) ||
                    dfs(board, i - 1, j, begin + 1) ||
                    dfs(board, i, j + 1, begin + 1) ||
                    dfs(board, i, j - 1, begin + 1);
            if (res) {
                return true;
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
