class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            //先把单词中的字母排序
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);     //得到一个固定的值key，若得出的key一样就说明需要放一块儿
            //根据key，在map中得到现有的list
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);      //然后把现在这个str加进去
            map.put(key, list);     //再重新放进去
        }
        return new ArrayList<List<String>>(map.values());
    }
}
