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
    public boolean isValidBST(TreeNode root) {
        if(root == null){       //如果为空就直接返回true
            return true;
        }else{
            //如果左子树存在且左子树最大值不小于当前值，就返回false
            if(root.left != null && forMax(root.left) >= root.val){
                return false;
            }
            //如果右子树存在且右子树最小值不大于当前值，就返回false
            if(root.right != null && forMin(root.right) <= root.val){
                return false;
            }
            //最后递归判断左子树和右子树是不是有效二叉树
            return isValidBST(root.left) && isValidBST(root.right);
        }  
    }
    public int forMax(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
    public int forMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
}
