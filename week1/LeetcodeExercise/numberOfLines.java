class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1, width = 0;
        for(int i = 0; i < s.length(); i++){
            //计算每一个字母对应的宽度
            int w = widths[s.charAt(i) - 'a'];
            width += w;     //加到width上
            //判断是否需要换行
            if (width > 100) {
                lines++;
                width = w;
            }
        }
        return new int[]{lines, width};
    }
}
