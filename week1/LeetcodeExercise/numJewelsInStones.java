class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] type = new int[256];  //利用ASC码代替哈希表
        for(int i = 0; i < jewels.length(); i++){
            type[jewels.charAt(i)] = 1;
        }
        int ans = 0;
        for(int i = 0; i < stones.length(); i++){
            //只有是1的才会影响ans
            ans += type[stones.charAt(i)];
        }
        return ans;

        //哈希表解法
        // int ans = 0;
        // Set<Character> jSet = new HashSet<Character>();
        // int jLength = jewels.length(), sLength = stones.length();
        // for (int i = 0; i < jLength; i++) {
        //     //分别记录所有宝石的类型
        //     char jewel = jewels.charAt(i);
        //     jSet.add(jewel);
        // }
        // for (int i = 0; i < sLength; i++) {
        //     char stone = stones.charAt(i);
        //     if (jSet.contains(stone)) {
        //         //若存在jSet中，则说明是宝石
        //         ans++;
        //     }
        // }
        // return ans;

    }
}
