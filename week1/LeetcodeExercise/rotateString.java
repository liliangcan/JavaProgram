class Solution {
    public boolean rotateString(String s, String goal) {
        //当s和goal长度相等且s+s包含goal
        if(s.length() == goal.length() && (s+s).contains(goal)){
            return true;
        }
        return false;
    }
}
