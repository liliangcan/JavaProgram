class Solution {
    public int largestRectangleArea(int[] heights) {
        //单调栈解法
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);  //设置right[]默认值为n
        
        Deque<Integer> mono_stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                //当出现比栈顶小的值，则需要出栈，并记录right[]
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            //记录左边界
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            //right-left-1 就是指宽度其实
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;

        //超时不行
        // int ans = 0;
        // for(int i = heights.length-1; i >= 0; i--){
        //     if(heights[i] == 0){
        //         continue;
        //     }
        //     int height = heights[i];        //初始高度
        //     int area = heights[i];          //初始面积
        //     for (int k = i-1; k >= 0; k--) {
        //         //高度更新为最小值
        //         height = Math.min(height, heights[k]);
        //         //面积更新为现在的height乘上现在的宽度的i-k+1
        //         area = Math.max(area, (i - k + 1) * height);
        //     }
        //     //更新结果ans
        //     ans = Math.max(ans, area);
        // }
        // return ans;
    }
}
