class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[][] left = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    //left[i][j]指该点左边连续1的数量
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    //如果是0则直接下一轮循环
                    continue;
                }
                int width = left[i][j];     //初始宽度是左边连续1的数量
                int area = width;           //初始面积是宽度乘上1
                for (int k = i-1; k >= 0; k--) {
                    //宽度更新为最小值
                    width = Math.min(width, left[k][j]);
                    //面积更新为现在的width乘上现在的高度的i-k+1
                    area = Math.max(area, (i - k + 1) * width);
                }
                //更新结果ans
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}
