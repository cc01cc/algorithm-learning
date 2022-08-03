/*
 *    Copyright (c) 2022. cc01cc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode94_02_02 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> binaryTreeList = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();

        // 当二叉树为空时
        if (root == null) {
            return binaryTreeList;
        }

        // 二叉树当前节点
        TreeNode cur = root;
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 当节点或栈不为空时
        // 当栈为空，节点不为空，除了插入根节点，可能还有右孩子
        while (cur != null || !treeNodeStack.isEmpty()) {
            // do {
            // 根节点为 null 的话，前边判断了直接返回
            // 此处 cur 为 null，表示没有右孩子
            // 所以不需要增加新的左孩子
            if (cur != null) {
                // 第一次执行时添加根节点
                // 之后此处都是添加右孩子
                treeNodeStack.push(cur);
                while (cur.left != null) {
                    treeNodeStack.push(cur.left);
                    cur = cur.left;
                }
            }
            cur = treeNodeStack.pop();
            binaryTreeList.add(cur.val);
            cur = cur.right;
        }
        return binaryTreeList;
    }

}
