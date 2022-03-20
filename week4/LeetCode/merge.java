class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){      //若最多一个区间则直接返回
            return intervals;
        }
        //浅试lambda，排序
        Arrays.sort(intervals,(interval1,interval2)->interval1[0]-interval2[0]);
        List<int[]> ans = new ArrayList<int[]>();
        for(int i = 0,j = i+1; j < intervals.length; i = j){
            while(j < intervals.length){
                //若前一个包含后一个，则跳过下一个
                if(intervals[i][1] >= intervals[j][1]){
                    j++;
                }else if(intervals[i][1] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]){
                    intervals[i][1] = intervals[j][1];  //若前一个跟后一个相交，则取最大的范围
                    j++;
                }else{
                    break;
                }
            }
            ans.add(intervals[i]);      //将这个新数组加入到ans中
        }
        return ans.toArray(new int[ans.size()][2]);

        // if (intervals.length == 0) {
        //     return new int[0][2];
        // }
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     public int compare(int[] interval1, int[] interval2) {
        //         return interval1[0] - interval2[0];
        //     }
        // });
        // List<int[]> merged = new ArrayList<int[]>();
        // for (int i = 0; i < intervals.length; i++) {
        //     int L = intervals[i][0], R = intervals[i][1];
        //     if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
        //         merged.add(new int[]{L, R});
        //     } else {
        //         merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
        //     }
        // }
        // return merged.toArray(new int[merged.size()][]);
    }
}
