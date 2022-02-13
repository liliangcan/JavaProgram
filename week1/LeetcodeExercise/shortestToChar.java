class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        //这里pre=Integer.MIN_VALUE/2是为了防止从左向右遍历数组时i-pre越界，因为i>=0，不除以2会越界
        //另外，从右向左遍历是Integer.MAX_VALUE不除以2则没问题的，
        int prev = Integer.MIN_VALUE / 2;
        //分别从左到右和从右到左两次遍历
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            ans[i] = i - prev;
        }
        prev = Integer.MAX_VALUE;
        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            ans[i] = Math.min(ans[i], prev - i);
        }
        return ans;
    }
}
