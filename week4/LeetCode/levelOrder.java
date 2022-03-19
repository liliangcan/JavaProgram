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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {         //若为空树则直接返回
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);          //先将根节点入队
        while (!queue.isEmpty()) {      //queue不为空时循环（也即当层节点没遍历完）
            List<Integer> level = new ArrayList<Integer>(); //保存当层的所有节点
            int currentLevelSize = queue.size();
            while(currentLevelSize > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                currentLevelSize--;
            }
            ans.add(level);         //将当层的结果加进ans中
        }
        return ans;
    }
}
