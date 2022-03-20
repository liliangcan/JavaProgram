class Solution {
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length-1;
        //遍历数组，遇到2就放后面，遇到0就放前面
        for(int i = 0; i <= blue; i++){
            while(i <= blue && nums[i] == 2){
                nums[i] = nums[blue];
                nums[blue] = 2;
                blue--;
            }
            while(red <= i && nums[i] == 0){
                nums[i] = nums[red];
                nums[red] = 0;
                red++;
            }
        }
    }
}
