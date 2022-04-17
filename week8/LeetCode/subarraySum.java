class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //设置初始map
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            //如果map中有pre-k的值，则更新count
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            //更新map中pre的值
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
