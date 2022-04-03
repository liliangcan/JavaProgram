class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;           //设置起始边界，最外面
        int maxcontain = 0;
        while (left < right){
            int currarea = Math.min(height[left], height[right]) * (right - left);         //计算当前面积
            maxcontain = Math.max(maxcontain, currarea);                 //取最大值为maxcontain
            if (height[left] <= height[right]) { 
                left++; 
            }else{ 
                right--;
            }
        }
        return maxcontain;
    }
}
