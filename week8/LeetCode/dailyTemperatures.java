class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        //首先定义一个全为0 的ans数组
        int[] ans = new int[length];
        //然后定义一个单调栈作为辅助工具
        Deque<Integer> stack = new LinkedList<Integer>();
        //循环遍历整个temperatures数组中的数据
        for (int i = 0; i < length; i++) {
            //定义当前温度
            int currT = temperatures[i];
            //当栈不为空且当前温度大于栈顶索引对应的温度时，则栈顶元素出栈，且让ans[prevIndex] = i - prevIndex
            while (!stack.isEmpty() && currT > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            //最后将当前索引入栈
            stack.push(i);
        }
        return ans;
    }
}
