/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        // List<Integer> list = new List<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        in(root, list);
        return list;
    }

    public void in(TreeNode root, List<Integer> list)
    {
        if (root == null)
        {
            return;
        }
        in(root.left, list);
        list.add(root.val);
        in(root.right, list);
    }
}
// @lc code=end

