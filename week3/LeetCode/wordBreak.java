class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        //先设置dp[0]为true，dp中两为true的位置与前面（某）一个true的位置之间的部分说明在字典中
        //也就是说，到此位置为止，都能由所给的字典中的内容构成
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    //当dp[j]为true且j到i的这一子串在字典中
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
