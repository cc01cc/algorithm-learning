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

public class LeetCode144_01_01 {
    public List<Integer> binaryTreeList = new ArrayList<>();


    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return binaryTreeList;
        }

        // 前序遍历
        binaryTreeList.add(root.val);
        preorderTraversal(root.left);
        // 中序遍历
//        binaryTreeList.add(root.val);
        preorderTraversal(root.right);
        // 后序遍历
//        binaryTreeList.add(root.val);
        return binaryTreeList;
    }
}
