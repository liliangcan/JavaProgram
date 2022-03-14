class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            //必须得这样一个个添加进去
            numSet.add(num);
        }
        // Set<Integer> numSet = new HashSet(nums); //不是List，不可以这么写，是错误的
        int longestLength = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {    //确定是否是序列的开头，即没有比它小1的数
                int currentNum = num;
                int currentLength = 1;
                //开始延伸序列
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                //更新最大长度
                longestLength = Math.max(longestLength, currentLength);
            }
        }
        return longestLength;
    }
}
