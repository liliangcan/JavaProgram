class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, ans, 0);
        return ans;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> ans, int current) {
        //当填到最后一位时则这一次排列结束
        if (current == n) {
            ans.add(new ArrayList<Integer>(output));
            //回溯过程中，将数字使用状态重置撤销的时候，会将list的元素移除掉,也会影响到res里面的list情况。
            //因为它们是同一个引用。
            // 全部为空，是因为回溯结束的同时，会将全部数字重置撤销，这样list里面的元素就会为空了
            //同样的，也会影响到res的存放情况
        }
        for (int i = current; i < n; i++) {
            //动态维护数组
            Collections.swap(output, current, i);
            //继续递归填下一个数
            backtrack(n, output, ans, current + 1);
            //撤销操作
            Collections.swap(output, current, i);
        }
    }
}
