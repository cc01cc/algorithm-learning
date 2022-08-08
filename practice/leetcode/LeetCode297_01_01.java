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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// 二叉树序列化的结构：
// 使用 null 将二叉树填充成满二叉树后，按层遍历输出
public class LeetCode297_01_01 {

    /**
     * 将二叉树序列化
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {

        if (root == null) {
            return "[]";
        }

        // 定义一个链表用于存放二叉树
        // 考虑到二叉树长度未知，并且后边有大量添加操作就选择了链表
        List<String> listTree = new LinkedList<>();

        // 定义两个队列，一个存放当前的节点，一个存放下一层的节点
        // 一个队列也可以实现，但两个队列感觉逻辑会清晰些
        Queue<TreeNode> queueTreeCur = new LinkedList<>();
        Queue<TreeNode> queueTreeNext = new LinkedList<>();

        // 作为遍历结束的条件，队列的值全为 null 时
        Boolean queueALLNull = false;
        queueTreeCur.offer(root);

        // 当队列全为空的时候停止循环
        while (queueALLNull == false) {
            queueALLNull = true;

            // 每次循环抛出当前层的节点，填充下一层的节点
            // 如果当前层节点遍历完了，退出循环
            while (!queueTreeCur.isEmpty()) {
                TreeNode tempNode = queueTreeCur.poll();

                // 如果节点为空，则在下一层插入两个 null 表示左右节点为 null
                if (tempNode == null) {
                    // 两条重复，也就不写循环了
                    queueTreeNext.offer(null);
                    queueTreeNext.offer(null);
                    listTree.add(null);
                    // 直接进入下一轮循环
                    // 就不用写 else 了，少个大括号看着舒服些
                    continue;
                }

                // 用于判断下一层是否全部为 null
                if (tempNode.left != null || tempNode.right != null) {
                    queueALLNull = false;
                }

                queueTreeNext.offer(tempNode.left);
                queueTreeNext.offer(tempNode.right);

                listTree.add(String.valueOf(tempNode.val));
            }

            // 遍历进入下一层
            queueTreeCur = queueTreeNext;
            queueTreeNext = new LinkedList<>();
        }

        return listTree.toString();
    }

    /**
     * 二叉树反序列化
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        // 字符串为空；字符串所代表的二叉树为空；二叉树的根节点为空
        if (data.isEmpty() || data.equals("[]") || data.startsWith("[null")) {
            return null;
        }

        // 定义一个队列，存放上一层的节点
        Queue<TreeNode> queueTree = new LinkedList<>();
        // 存放二叉树的每一个节点的值
        String[] strTree = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strTree[0]));

        queueTree.offer(root);

        for (int i = 1; i < strTree.length; i += 2) {
            TreeNode tempNode = queueTree.poll();
            if (tempNode == null) {
                queueTree.offer(null);
                queueTree.offer(null);
                continue;
            }

            if (strTree[i].trim().equals("null")) {
                tempNode.left = null;
            } else {
                tempNode.left = new TreeNode(Integer.valueOf(strTree[i].trim()));
            }

            if (strTree[i + 1].trim().equals("null")) {
                tempNode.right = null;
            } else {
                tempNode.right = new TreeNode(Integer.valueOf(strTree[i + 1].trim()));
            }

            queueTree.offer(tempNode.left);
            queueTree.offer(tempNode.right);
        }

        return root;
    }

    @Test
    public void test() {
        String s = "[1,2,3,null,null,4,5]";
        String[] strTree = s.substring(1, s.length() - 1).split(",");
//        System.out.println(deserialize(s).right.val);
//        System.out.println(deserialize(s).right.right.val);
        System.out.println(serialize(deserialize(s)));
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));