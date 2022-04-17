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
    int length;
    public int diameterOfBinaryTree(TreeNode root) {
        length = 1;
        depth(root);
        return length - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; //空节点了返回0
        }
        int L = depth(node.left); //左儿子为根的子树的深度
        int R = depth(node.right); //右儿子为根的子树的深度
        //更新length
        length = Math.max(length, L+R+1);
        return Math.max(L, R) + 1; //返回该节点为根的子树的深度
    
    }
}
