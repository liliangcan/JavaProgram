class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);             //首先进行排序
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int first = 0; first < n; first++) {       // 枚举 a
            if (first > 0 && nums[first] == nums[first - 1]) {      // 需要和上一次枚举的数不相同
                continue;
            }
            int third = n - 1;              // c 对应的指针初始指向数组的最右端
            int target = -nums[first];                  //另外两个数之和为第一个数的负值
            for (int second = first + 1; second < n; second++) {        // 枚举 b
                if (second > first + 1 && nums[second] == nums[second - 1]) {   // 需要和上一次枚举的数不相同
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 如果指针重合，随着 b 后续的增加，就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
