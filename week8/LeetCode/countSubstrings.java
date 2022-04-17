class Solution {
    public int countSubstrings(String s) {
        // int n = s.length();
        // int ans = 0;
        // //中心拓展算法，也就是2*n-1次遍历找到所有的回文子串
        // for (int i = 0; i < 2 * n - 1; ++i) {
        //     int l = i / 2, r = i / 2 + i % 2;
        //     while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
        //         --l;
        //         ++r;
        //         ++ans;
        //     }
        // }
        // return ans;

        //Manacher算法
        int n = s.length();
        //为了保证一个明确不对称的界限
        //让之后的中心扩展那一步不出界
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            //初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            //中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            //更新 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            //统计, 当前回文子串贡献(f[i]-1)/2 
            ans += f[i] / 2;
        }

        return ans;
    }
}
