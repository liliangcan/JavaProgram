class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);  //先排序
        for(int i = 0; i < nums.length-1; ){    //再挨个比较
            if(nums[i] != nums[i+1]){
                return nums[i];     //找到目标就返回
            }else{
                i = i+2;
            }
        }
        return nums[nums.length-1];     //能从上面的for循环出来说明就是最后一个数是单身狗
    }
}
