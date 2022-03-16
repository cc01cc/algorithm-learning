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
*   @Title: UnRecursiveTraversalBT.java
*   @Description: TODO
*   @author cc01cc
*   @date 2022-03-16 
*/

package com.cc01cc.algorithm.collenction02binaryTree;

import java.util.Stack;

/**
 * @author       cc01cc
 * @date         2022-03-16
 * @Description: TODO
 * 
 */
public class UnRecursiveTraversalBT {

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
        // TODO Auto-generated method stub

    }

    // 先序遍历
    public static void pre(Node head) {
        System.out.print("pre-order: ");
        Stack<Node> stack = new Stack<Node>();
        stack.add(head);

        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        System.out.println();
    }

    // 中序遍历 （左子树到底）
    public static void in(Node head) {
        System.out.print("in-order: ");

        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    // 后序遍历

    public static void posUseDoubleStack(Node head) {
        System.out.print("pos-order-use-double-stack: ");
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            
            s1.add(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.add(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
                while (!s2.isEmpty()) {
                    System.out.print(s2.pop().value + " ");
                }
            }
        }
        System.out.println();
    }

    public static void pos(Node head) {
        System.out.print("pos-order: ");
        
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right) {
                    stack.push(c.left);
                    
                }else if (c.right != null && head != c.right) {
                    stack.push(c.right);
                }else {
                    System.out.print(stack.pop().value + " ");
                    head = c;
                }
            }
            System.out.println();
        }
    }
}
