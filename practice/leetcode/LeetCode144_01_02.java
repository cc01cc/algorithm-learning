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

public class LeetCode144_01_02 {


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> binaryTreeList = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();

        TreeNode cur = root;

        while (cur != null || !treeNodeStack.isEmpty()) {

            if (cur != null) {
                // 把当前节点放入到结果集与栈中
                treeNodeStack.push(cur);
                binaryTreeList.add(cur.val);

                // 循环遍历左孩子
                while (cur.left != null) {
                    // 将左孩子放入到结果集和栈中
                    treeNodeStack.push(cur.left);
                    binaryTreeList.add(cur.left.val);
                    cur = cur.left;
                }
            }
            // 此处存在两种情况：
            // cur 为 null，栈没有空
            // cur 目前位于是一个左孩子，并且位于末梢
            cur = treeNodeStack.pop();

            // 这儿 cur 从栈中取出并且栈不为空
            // 所以 cur 一定有值 --> cur.right 存在
            // 且不需要，也不可以判断 cur.right 是否为 null
            // 避免陷入死循环
            cur = cur.right;
        }
        return binaryTreeList;
    }
}
