class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        // dfs(candidates, target, ans, combine, 0);
        backtrack(candidates, target, ans, combine, candidates.length-1);
        return ans;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if(target == 0){    //找到一个成功的组合
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        if(idx == 0 && target < candidates[0]){
            return;         //如果已经找到最前面一位还是大于target，就说明组合失败，开始回溯
        }
        if(target < candidates[idx]){   //如果大于target，就继续向前寻找
            backtrack(candidates, target, ans, combine, idx-1);
        }else{
            //当适合时 就开始循环
            for (int first = idx; first >= 0; first--) {
                if (target < 0) {
                    break;
                }
                combine.add(candidates[first]);
                backtrack(candidates, target - candidates[first], ans, combine, first);
                combine.remove(combine.size() - 1);     //注意需要回溯一步
            }
        }
        
    }
    // public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
    //     if (idx == candidates.length) {
    //         return;
    //     }
    //     if (target == 0) {
    //         ans.add(new ArrayList<Integer>(combine));
    //         return;
    //     }
    //     // 直接跳过
    //     dfs(candidates, target, ans, combine, idx + 1);
    //     // 选择当前数
    //     if (target - candidates[idx] >= 0) {
    //         combine.add(candidates[idx]);
    //         dfs(candidates, target - candidates[idx], ans, combine, idx);
    //         combine.remove(combine.size() - 1);
    // }
}
