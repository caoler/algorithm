package cn.caoler.offer;

/**
 * @author keji
 * @desc 矩阵中的路径
 * @date 2020/11/23 10:44 上午
 */
public class Offer12 {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //下、上、右、左查询

        //判断：1.越界 2.重复访问 3.不匹配：word[k] != board[i][j]
        if (i > board.length || i < 0 || j > board[0].length || j < 0 || word[k] != board[i][j]) {
            return false;
        }
        //查询到最后一位 并且全都满足
        if (k == word.length - 1) {
            return true;
        }
        //如果当前节点满足条件，把当前值置空，防止下次重复访问
        board[i][j] = '\0';
        boolean res =
                dfs(board, word, i + 1, j, k + 1)  //下
                || dfs(board, word, i - 1, j, k + 1) //上
                || dfs(board, word, i, j + 1, k + 1)  //右
                || dfs(board, word, i , j - 1, k + 1); //左
        board[i][j] = word[k];
        return res;
    }
}
