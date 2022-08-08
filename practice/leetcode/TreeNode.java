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

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
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

    /**
     * 将二叉树序列化
     *
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
        Queue<TreeNode> queueTreeCur = new LinkedList<>();
        Queue<TreeNode> queueTreeNext = new LinkedList<>();
        // 用于标记队列是否全部为 null
        Boolean queueAllNull = false;

        queueTreeCur.offer(root);

        // 当队列全为空的时候停止循环
        while (!queueAllNull) {
            queueAllNull = true;

            // 每次循环抛出当前层的节点，填充下一层的节点
            // 如果当前层节点遍历完了，退出循环
            while (!queueTreeCur.isEmpty()) {
                TreeNode tempNode = queueTreeCur.poll();

                // 如果节点为 null 则在输出列表中添加 null
                if (tempNode == null) {
                    listTree.add(null);
                    continue;
                }

                // 如果节点不是 null 则将值添加到输出列表 listTree 中
                listTree.add(String.valueOf(tempNode.val));

                if (tempNode.left != null || tempNode.right != null) {
                    queueAllNull = false;
                }
                queueTreeNext.offer(tempNode.left);
                queueTreeNext.offer(tempNode.right);

            }
            queueTreeCur = queueTreeNext;
            queueTreeNext = new LinkedList<>();
        }


        return listTree.toString();
    }

    /**
     * 二叉树反序列化
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        // 字符串为空；字符串所代表的二叉树为空；二叉树的根节点为空
        if (data == null || data.equals("[]") || data.startsWith("[null")) {
            return null;
        }

        // 存放二叉树的每一个节点的值
        String[] strTree = data.substring(1, data.length() - 1).split(",");
        // 存放所有二叉树节点，先进先出
        Queue<TreeNode> queueTree = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(strTree[0].trim()));

        queueTree.offer(root);

        for (int i = 1; i < strTree.length; i += 2) {
            TreeNode tempNode = queueTree.poll();
            String strLeftNode = strTree[i].trim();
            String strRightNode = strTree[i + 1].trim();

            // 将弹出节点的左孩子和右孩子若存在则放入队列中
            if (strLeftNode.equals("null")) {
                tempNode.left = null;
            } else {
                tempNode.left = new TreeNode(Integer.valueOf(strLeftNode));
                queueTree.offer(tempNode.left);
            }

            if (strRightNode.equals("null")) {
                tempNode.right = null;
            } else {
                tempNode.right = new TreeNode(Integer.valueOf(strRightNode));
                queueTree.offer(tempNode.right);
            }

        }
        return root;
    }
}