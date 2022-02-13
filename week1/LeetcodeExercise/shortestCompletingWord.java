class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] plateArr = new int[26];
        for (int i = 0; i < licensePlate.length(); ++i) {
            char ch = licensePlate.charAt(i);
            if (Character.isLetter(ch)) {   //若该位置是字母
                //将出现过的字母对应的位置加一，统计出现次数
                ++plateArr[Character.toLowerCase(ch) - 'a'];
            }
        }
        int index = -1;
        for (int i = 0; i < words.length; ++i) {
            int[] wordArr = new int[26];
            for (int j = 0; j < words[i].length(); ++j) {
                //将当前单词中出现过的字母对应的位置加一，统计出现的次数
                char ch = words[i].charAt(j);
                ++wordArr[ch - 'a'];
            }
            boolean flag = true;
            for (int j = 0; j < 26; ++j) {
                //若当前的单词不包含licensePlate里所有的字母，则break
                if (wordArr[j] < plateArr[j]) {
                    //将标志flag置为false，这样直接跳过下面一段代码进入下一次大循环
                    flag = false;
                    break;
                }
            }
            //寻找符合条件最短的单词
            if (flag && (index < 0 || words[i].length() < words[index].length())) {
                index = i;
            }
        }
        return words[index];
    }
}
