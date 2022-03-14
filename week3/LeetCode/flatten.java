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
    public void flatten(TreeNode root) {
        if(root != null){
            flatten(root.left);     //把左子树flatten
            flatten(root.right);    //把右子树flatten
            if(root.left != null){  
                //然后若左子树不为空，则需要把右子树插到左子树中，在把左子树换到右子树这边，最后置空
                myInsert(root);
            }
        }
    }
    public void myInsert(TreeNode root){
        TreeNode tmp = root.left;
        while(tmp.right != null){
            tmp = tmp.right;
        }
        tmp.right = root.right;     //把右子树插到左子树的最右边
        root.right = root.left;     //把左子树变成右子树
        root.left = null;           //把左子树置空
    }
}
