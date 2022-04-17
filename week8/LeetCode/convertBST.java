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
    int sum = 0;
    //反序中序遍历，很有新意
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            //先走右枝
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            //然后走左枝，目的是为了按照从大到小的顺序走遍每个节点
            convertBST(root.left);
        }
        return root;
    }
}
