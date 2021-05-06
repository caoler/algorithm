package cn.caoler.offerSecond;

public class Offer12 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, chars, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board,char[] word, int i,int j, int k) {


        //判断越界
        if (i >= board.length || i < 0 || j >= board[0].length || j <0 || board[i][j] != word[k]) {
            return false;
        }

        //如果已经到最后一位了，那么直接返回就完事了，这一步的时候 board[i][j] == word[k]
        if (k == word.length - 1) {
            return true;
        }

        //如果没到最后一位，那么需要继续遍历
        //下、上、右、左查询
        //如果当前节点满足条件，把当前值置空，防止下次重复访问
        board[i][j] = '\0';
        boolean res =
                dfs(board, word, i + 1, j, k + 1)  //下
                        || dfs(board, word, i - 1, j, k + 1) //上
                        || dfs(board, word, i, j + 1, k + 1)  //右
                        || dfs(board, word, i , j - 1, k + 1); //左
        //当前位置只要判断完了 就给人家矩阵还原了
        board[i][j] = word[k];
        return res;
    }
}
