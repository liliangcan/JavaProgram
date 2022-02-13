class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                //若两边对应的位置的数相等，则同时改变，否则不需要变动
                if (image[i][left] == image[i][right]) {
                    image[i][left] ^= 1;
                    image[i][right] ^= 1;
                }
                left++;
                right--;
            }
            //若有中间位置，则需要改变
            if (left == right) {
                image[i][left] ^= 1;
            }
        }
        return image;
    }
}
