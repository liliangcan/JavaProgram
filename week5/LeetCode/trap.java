class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;    //设置双指针的起始位置
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            //更新左右两边的最高处
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            //若左指针对应位置的值较小，就向右移动，否则右指针左移
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
        //就像两把画刷同时从左右两边开始刷，方向只会从当前高度较小值往较大值的方向刷
    }
}
