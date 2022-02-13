class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> vowel = new HashSet();
        for (char c: new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}){
            vowel.add(c);
        }
        int count = 1;
        StringBuilder ans = new StringBuilder();
        for (String s: sentence.split(" ")) {
            //在每一个单词后面加上空格间隔开
            if(ans.length() != 0){
                ans.append(" ");
            }
            char first = s.charAt(0);
            //若首字母包含在vowel内
            if (vowel.contains(first)) {
                ans.append(s);
            } else {
                //否则就将第一位转到最后一位
                ans.append(s.substring(1));
                ans.append(first);
            }
            ans.append("ma");   //末尾加上ma
            for (int i = 0; i < count; i++){
                ans.append("a");
            }
            count++;
        }
        return ans.toString();
    }
}
