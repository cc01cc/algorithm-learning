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

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode145_01_02 {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> binaryTreeList = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();

        // 当根节点为 null 时，直接返回
        if (root == null) return binaryTreeList;

        TreeNode cur = root;
        // prev 记录上一个弹出的节点
        TreeNode prev = null;

        // 第一遍把 root 节点放入
        do {
            if (cur != null) {
                treeNodeStack.push(cur);

                while (cur.left != null) {
                    treeNodeStack.push(cur.left);
                    cur = cur.left;
                }
            }

            cur = treeNodeStack.peek();

            // 不存在右孩子或者这个节点的右孩子已经遍历过了
            if (cur.right == null || cur.right == prev) {
                binaryTreeList.add(cur.val);
                // 记录弹出的节点
                prev = treeNodeStack.pop();
                System.out.println(prev.val);
                // cur 定义为 null 可以避免重复进入右孩子
                cur = null;
            } else {
                cur = cur.right;
            }

            // 因为存在右孩子时，会重新将节点压回栈中
            // 栈为空即遍历结束
        } while (!treeNodeStack.isEmpty());

        return binaryTreeList;
    }

    @Test
    public void test() {
        String data = "[3,1,null,null,2]";
        TreeNode root = new TreeNode().deserialize(data);
        System.out.println(new TreeNode().serialize(root));
        System.out.println(postorderTraversal(root));
    }
}
