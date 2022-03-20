class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0) {       //若其中有一个字符串为空串（其实也就是边界情况）
            return n + m;
        }
        int[][] D = new int[n + 1][m + 1];//定义DP动态数组
        for (int i = 0; i < n + 1; i++) {   // 边界状态初始化
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    //若最后一位不一样，则需要left_down加一
                    left_down++;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }
}
