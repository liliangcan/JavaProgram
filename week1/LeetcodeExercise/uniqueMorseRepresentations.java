class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};

        Set<String> ans = new HashSet();       //因为取不重复的数量，所以使用set
        for (String word: words) {
            //因为需要更新code，所以使用stringbuilder
            StringBuilder code = new StringBuilder();
            for (char c: word.toCharArray()){
                //拼接下一段密码
                code.append(MORSE[c - 'a']);
            }
            ans.add(code.toString());//转换为string常量并加入ans
        }
        return ans.size();
    }
}
