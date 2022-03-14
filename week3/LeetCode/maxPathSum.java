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
    /*所有的树，都想成一颗只有根、左节点、右节点的小树。然后一颗颗小树构成整棵大树，所以只需要考虑这颗小树即可。
    接下来分情况， 按照题意：一颗三个节点的小树的结果只可能有如下6种情况：
    根 + 左 + 右
    根 + 左
    根 + 右
    根
    左
    右
    分析上述6种情况， 只有 2,3,4 可以向上累加，而1,5,6不可以累加
    （情况1向上累加的话，必然出现分叉，情况5和6直接就跟上面的树枝断开的，没法累加）,
    所以我们找一个全局变量存储 1,5,6这三种不可累加的最大值， 另一方面咱们用遍历树的方法求2,3,4这三种可以累加的情况。 
    最后把两类情况得到的最大值再取一个最大值即可。
    */
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //递归计算左右子节点的最大贡献值,只有在最大贡献值大于0时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        //通过该节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewpath);    //更新答案
        return node.val + Math.max(leftGain, rightGain);    //返回节点的最大贡献值
    }
}
