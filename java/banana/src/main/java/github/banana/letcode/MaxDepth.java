package github.banana.letcode;

import github.banana.common.TreeNode;

/**
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
 * 说明: 叶子节点是指没有子节点的节点
 *
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * 最大深度为3
 */
public class MaxDepth {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            // 递归的层次在增加, 这里在做计算, 这里递归不是很好理解了
            return Math.max(left, right) + 1;
        }
    }
}
