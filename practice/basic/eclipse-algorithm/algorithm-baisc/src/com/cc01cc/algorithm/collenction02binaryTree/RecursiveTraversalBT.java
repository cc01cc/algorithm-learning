/**  
 *   Copyright 2022 cc01cc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

/**
*   @Title: RecursiveTraversalBT.java
*   @Description: TODO
*   @author cc01cc
*   @date 2022-03-16 
*/

package com.cc01cc.algorithm.collenction02binaryTree;

/**
 * @author       cc01cc
 * @date         2022-03-16
 * @Description: TODO
 * 
 */
public class RecursiveTraversalBT {

    public static class Node {
        public int  value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    /**
     * @Title:              main
     * @Description:        TODO
     * @param        @param args
     * @return              void
     * @throws
     */
    public static void main(String[] args) {
        int testTime = 500;
        int maxDeep = 20;
        int maxValue = 20;
        Node head = generateRandomBT(maxDeep, maxValue);
        recursiveTriversalBT (head);
    }

    public static void recursiveTriversalBT(Node head) {
        if (head == null) {
            return;
        }

        // 先序遍历
        System.out.println(head.value);

        recursiveTriversalBT(head.left);

        // 中序遍历
        System.out.println(head.value);

        recursiveTriversalBT(head.right);
        // 后序遍历
        System.out.println(head.value);
    }
    
    public static Node generateRandomBT (int maxDeep, int maxValue) {
        Node head = new Node((int)((maxValue+1)*Math.random()));
        return head;
    }
}
