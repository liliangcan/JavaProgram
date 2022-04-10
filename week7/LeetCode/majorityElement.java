class Solution {
    public int majorityElement(int[] nums) {
        //很有意义的投票法
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            //如果跟候选人相等，就+1，否则-1
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
