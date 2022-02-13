/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int last;
    int ans;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        last = -1;  //设置前一个数初值为-1
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root) {    //中序遍历寻找最小差值
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (last == -1) {   //若last为-1，则将树中最小的值赋给last
            last = root.val;
        } else {
            //求得每一个当前数减last的值，以及更新ans和last
            ans = Math.min(ans, root.val - last);
            last = root.val;
        }
        dfs(root.right);
    }
}
