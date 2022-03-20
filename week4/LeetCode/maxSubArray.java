class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int ans = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(pre <= 0){         //若之前元素和非正数，则丢弃，选用当前值
                pre = nums[i];
            }else{
                pre = pre + nums[i];    //否则加上当前值成为新的pre
            }
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
