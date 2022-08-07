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
// LeetCode 序列化二叉树的格式 - 力扣（LeetCode） - 支持: <https://support.leetcode-cn.com/hc/kb/article/1567641/>
public class LeetCode297_01_01 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "[]";
        }
        ArrayList<String> arrayListTree = new ArrayList<>();
        // 定义两个队列，一个存放当前的节点，一个存放下一层的节点
        Queue<TreeNode> queueTreeCur = new LinkedList<>();
        // 前边时 Prev 忘记后边用什么词了，就暂时先用 Next 吧
        Queue<TreeNode> queueTreeNext = new LinkedList<>();

        // 作为遍历结束的条件，队列的值全为 null 时
        Boolean queueALLNull = false;

//        arrayListTree.add(String.valueOf(root.val));
        queueTreeCur.offer(root);

        while (queueALLNull == false) {
            queueALLNull = true;

            while (!queueTreeCur.isEmpty()) {
                TreeNode tempNode = queueTreeCur.poll();

                if (tempNode == null) {
                    queueTreeNext.offer(null);
                    queueTreeNext.offer(null);
                    arrayListTree.add(null);
                    continue;
                }

                if (tempNode.left != null || tempNode.right != null) {
                    queueALLNull = false;
                }

                queueTreeNext.offer(tempNode.left);
                queueTreeNext.offer(tempNode.right);

                arrayListTree.add(String.valueOf(tempNode.val));
            }

            queueTreeCur = queueTreeNext;
            queueTreeNext = new LinkedList<>();
        }


        return arrayListTree.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 字符串为空；字符串所代表的二叉树为空；二叉树的根节点为空
        if (data.isEmpty() || data.equals("[]") || data.startsWith("[null")) {
            return null;
        }
//        String s = "[1,2,3,null,null,4,5]";
        String[] strTree = data.substring(1, data.length() - 1).split(",");

        // 定义一个队列，存放上一层的节点
        Queue<TreeNode> queueTree = new LinkedList<>();
//        queueOfferFromStr(queueTree, strTree[0]);
        TreeNode root = new TreeNode(Integer.valueOf(strTree[0]));
        queueTree.offer(root);

        for (int i = 1; i < strTree.length; i += 2) {
            // 弹出一个节点
            TreeNode tempNode = queueTree.poll();
            if (tempNode == null) {
                // 相当于占了两个位置
                // 占两个格儿，就不写循环了
                queueTree.offer(null);
                queueTree.offer(null);
                // 直接进入下一轮循环
                // 就不用写 else 了，少个大括号看着舒服些
                continue;
            }
            // 往队列中传入节点
            if (strTree[i].equals("null")) {
                tempNode.left = null;
            } else {
                tempNode.left = new TreeNode(Integer.valueOf(strTree[i]));
            }

            if (strTree[i + 1].equals("null")) {
                tempNode.right = null;
            } else {
                tempNode.right = new TreeNode(Integer.valueOf(strTree[i + 1]));
            }

            queueTree.offer(tempNode.left);
            queueTree.offer(tempNode.right);

        }

//        queueTree.offer(new TreeNode(Integer.getInteger(strTree[0])));

        return root;
    }

    public void queueOfferFromStr(Queue<TreeNode> queue, String s) {
        if (s.equals("null")) {
            queue.offer(null);
        } else {
            queue.offer(new TreeNode(Integer.getInteger(s)));
        }
    }

    @Test
    public void test() {
        String s = "[1,2,3,null,null,4,5]";
        String[] strTree = s.substring(1, s.length() - 1).split(",");
//        System.out.println(deserialize(s).right.val);
//        System.out.println(deserialize(s).right.right.val);
        System.out.println(serialize(deserialize(s)));

//        System.out.println(Arrays.toString(strTree));
//        for (int i = 0; i < strTree.length; i++) {
//            System.out.println(Integer.valueOf(strTree[i]));
//
//        }
//        Queue<TreeNode> queueTree = new LinkedList<>();
//
//        queueTree.offer(null);
//        queueTree.offer(null);
//
//        System.out.println(queueTree.size());
//
//        Integer.getInteger("null");

    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));