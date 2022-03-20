class Solution {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();
    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {    //遍历一遍t，得到ori的map，键值对是键和对应值的个数
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = -1;   //设置初始窗口左边界和右边界
        // Queue<Integer> hasT = new LinkedList<Integer>();    /////
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (right < sLen) {
            right++;
            if (right < sLen && ori.containsKey(s.charAt(right))) {
                // if(right != 0){
                //     hasT.offer(right);                      /////
                // }
                cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                //若此时窗口内包含t，则更新len、ansL、ansR，左边界右移
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if (ori.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
                // if(!hasT.isEmpty()){
                //     left = hasT.poll();                         /////
                // }
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }
    public boolean check() {
        Iterator iter = ori.entrySet().iterator(); 
        while (iter.hasNext()) { 
            Map.Entry entry = (Map.Entry) iter.next(); 
            Character key = (Character) entry.getKey(); 
            Integer val = (Integer) entry.getValue(); 
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        } 
        return true;
    }
}
