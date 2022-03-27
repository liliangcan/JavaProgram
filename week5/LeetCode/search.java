class Solution {
    public int search(int[] nums, int target) {
        int n = (int)nums.length;
        //若数组为空，返回-1
        if (n == 0) {
            return -1;
        }
        //若数组长度为1，直接判断这个数是否是目标数就行
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        //使用二分查找法进行搜索
        int left = 0, right = n - 1;
        while (left <= right) {
            //设置中间位置的下标
            int mid = (left + right) / 2;
            //若此位置刚好是目标数，则返回此下标
            if (nums[mid] == target) {
                return mid;
            }
            //若左半边是顺序的
            if (nums[0] <= nums[mid]) {
                //若目标数在左半边之内，则更新右边界
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    //否则更新左边界
                    left = mid + 1;
                }
            } else {
            //若右半边是顺序的
                //若目标数在右半边之内，则更新左边界
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    //否则更新右边界
                    right = mid - 1;
                }
            }
        }
        //没找到就返回-1
        return -1;
    }
}
