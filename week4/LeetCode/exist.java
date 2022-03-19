class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        //设置一个用来记录当前节点是否使用过的矩阵
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //检查是否可以以当前节点作为起点
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            //若直接值不等于，则false
            return false;
        } else if (k == s.length() - 1) {
            //若已经是最后一位匹配上了，则true
            return true;
        }
        visited[i][j] = true;   //设置该位置为使用过
        //设置方向
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;     //设置初始result为false
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            //当周围节点为合理位置时
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {     //若邻居节点没有使用过
                    //则开始检查以邻居节点为起点时，剩下的字符串能否匹配成功
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;      //恢复该位置为未使用
        return result;
    }
}
