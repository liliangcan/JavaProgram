class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        //为了能进入else代码块中
        paragraph += " ";
        Set<String> banSet = new HashSet();
        for (String b: banned) {
            banSet.add(b);
        }
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansCount = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            //判断当前位置是否是字母
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalWord = word.toString();
                //判断是否在禁用单词列表中
                if (!banSet.contains(finalWord)) {
                    //getOrDefault(key，defaultValue) 当map中有key值则使用key值，否则使用defaultValue
                    count.put(finalWord, count.getOrDefault(finalWord, 0) + 1);
                    if (count.get(finalWord) > ansCount) {
                        //如果finalWord的出现次数已经超过的ansCount，则需要更新
                        ans = finalWord;
                        ansCount = count.get(finalWord);
                    }
                }
                //恢复word为空
                word = new StringBuilder();
            }
        }
        return ans;
    }
}
