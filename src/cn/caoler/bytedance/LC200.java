package cn.caoler.bytedance;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 * 这个题解属于是无敌模板了
 * @date 2021/3/25 8:23 上午
 */
public class LC200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length ; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if(!isArea(grid, i , j)) {
            return;
        }
        if(grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public boolean isArea(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >=0 && j < grid[0].length;
    }
}
