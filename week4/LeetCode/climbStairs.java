class Solution {
    public int climbStairs(int n) {
        int first = 1, second = 2;
        if(n == 1){         //若一阶台阶返回1
            return first;
        }else if(n == 2){   //若两阶台阶返回2
            return second;
        }else{
            int ans = second;
            //否则就是前一阶和前两阶的和
            for(int i = 3; i <= n; i++){
                ans = first + second;
                first = second;
                second = ans;
            }
            return ans;
        }
    }
}
