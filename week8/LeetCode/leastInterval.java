class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countForTask = new HashMap<Character, Integer>();
        int maxExec = 0;    //最多的执行次数
        int maxCount = 0;
        for (char ch : tasks) {
            //默认数量为0
            int exec = countForTask.getOrDefault(ch, 0) + 1;
            countForTask.put(ch, exec);
            //同时记录更新最多执行次数的任务的个数maxCount
            if(maxExec == exec){
                maxCount++;
            }else if(exec > maxExec){
                maxCount = 1;
            }
            maxExec = Math.max(maxExec, exec);
            
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

    /*
        如果我们没有填「超出」了 n+1n+1 列，那么图中存在 00 个或多个位置没有放入任务，
        由于位置数量为 (\textit{maxExec} - 1)(n + 1) + \textit{maxCount}(maxExec−1)(n+1)+maxCount，因此有：

        ∣task∣<(maxExec−1)(n+1) + maxCount

        如果我们填「超出」了 n+1n+1 列，那么同理有：
        ∣task∣>(maxExec−1)(n+1)+maxCount

        因此，在任意的情况下，需要的最少时间就是(maxExec−1)(n+1)+maxCount 和 ∣task∣ 中的较大值。

    */
}
