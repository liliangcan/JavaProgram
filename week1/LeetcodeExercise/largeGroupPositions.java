class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = s.length();
        int count = 1;
        for (int i = 0; i < n; i++) {
            //当已经是最后一个了，或者到了下一个相同字母的分组
            if (i == n-1 || s.charAt(i) != s.charAt(i + 1)) {
                if (count >= 3) {
                    //当长度大于等于3时就将左右边界加入ans
                    ans.add(Arrays.asList(i - count + 1, i)); //将数组转换成list
                }
                //将count恢复为1
                count = 1;
            } else {
                count++;
            }
        }
        return ans;
    }
}
