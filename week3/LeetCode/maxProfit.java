class Solution {
    public int maxProfit(int[] prices) {
        int pre = 0, maxPro = 0;
        int diff;
        for(int i = 1; i < prices.length; i++){
            diff = prices[i] - prices[i-1];             //保存当天与前一天的差值
            if(pre <= 0){       //若之前的小于零，则直接用diff取代pre
                pre = diff;
            }else{
                pre += diff;    //否则就pre加上diff
            }
            maxPro = Math.max(maxPro, pre);
        }
        return maxPro;
    }
}
