class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        if (rows == 0 || columns == 0) {
            return 0;
        }
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        //首先记录第一行第一列的路径和
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //然后根据已有的不断记录每一个到每一个格子的路径和
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
