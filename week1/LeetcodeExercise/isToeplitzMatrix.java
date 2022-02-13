class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                //判断当前位置与左上角的数是否相等
                if(matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }

    // public boolean isToeplitzMatrix(int[][] matrix) {
    //     for(int i = 0; i < matrix[0].length-1; i++){
    //         if(!isSame(matrix,0,i)){
    //             return false;
    //         }
    //     }
    //     for(int i = 1; i < matrix.length-1; i++){
    //         if(!isSame(matrix,i,0)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public boolean isSame(int[][] matrix,int i,int j){
    //     int cur = matrix[i][j];
    //     for( ; i < matrix.length-1 && j < matrix[0].length-1; i++,j++){
    //         if(matrix[i+1][j+1] != cur){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    //题意理解错误
    // public boolean isToeplitzMatrix(int[][] matrix) {
    //     int row = matrix.length;
    //     int col = matrix[0].length;
    //     if(row <= col){
    //         for(int i = 0; i <= col-row; i++){
    //             boolean ans = isSame(matrix,0,i);
    //             if(!ans){
    //                 return false;
    //             }
    //         }
    //     }else{
    //         for(int i = 0; i <= row-col; i++){
    //             boolean ans = isSame(matrix,i,0);
    //             if(!ans){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;

    // }
    
}
