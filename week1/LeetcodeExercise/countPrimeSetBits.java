class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int x = left; x <= right; x++){
            //若该数的二进制形式中1的个数是质数
            if (isSmallPrime(Integer.bitCount(x))){
                ans++;
            }
        }
        return ans;
    }
    public boolean isSmallPrime(int x) {
        //因为二进制数的位数最多不超过20
        return (x == 2 || x == 3 || x == 5 || x == 7 || x == 11 || x == 13 || x == 17 || x == 19);
    }
}
