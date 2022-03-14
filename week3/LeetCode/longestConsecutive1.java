class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);  //直接先对数组进行排序
        if(nums.length == 0){       //若大小为0，则返回0
            return 0;
        }
        int maxLength = 0, tempLength = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){       //若出现相等的元素则跳过
                continue;
            }
            if(nums[i] - nums[i-1] == 1){       //若出现连续的元素，则tempLength++
                tempLength++;
            }else{          //否则tempLength回归1
                maxLength = Math.max(maxLength, tempLength);
                tempLength = 1;
            }
        }
        maxLength = Math.max(maxLength, tempLength);
        return maxLength;
    }
}
