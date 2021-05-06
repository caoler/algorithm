package cn.caoler.medium;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 * @date 2021/3/25 7:56 上午
 */
public class LC695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    int a = dfs(grid, i, j);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    int dfs(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) {
            return 0;
        }

        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;

        return 1 +
        dfs(grid, i - 1, j) +
        dfs(grid, i + 1, j) +
        dfs(grid, i, j - 1) +
        dfs(grid, i, j + 1);
    }

    private boolean inArea(int[][] grid, int i, int j) {
        return 0 <= i && i < grid.length && 0 <= j && j < grid[0].length;
    }
}
