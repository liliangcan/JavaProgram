class Solution {
    public int dominantIndex(int[] nums) {
        int firstMax = 0, secondMax = 0, ans = -1;
        for(int i = 0; i < nums.length; i++){   //遍历数组，找到最大和倒数第二大的数
            if(nums[i] > firstMax){
                secondMax = firstMax;
                firstMax = nums[i];
                ans = i;
            }else if(nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        if(firstMax >= secondMax*2){    //判断第一大的数是否最小是第二大的数的两倍
            return ans;
        }else{
            return -1;
        }

    }
}
