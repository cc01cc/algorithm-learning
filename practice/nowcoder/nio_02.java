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
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 每个节点记录左子树和右子树的最大路径
 * 节点自己的最大路径 = 左子树最大路径 + 右子树最大路径
 */
class BinaryTree {
    public BinaryTree father;
    public BinaryTree left;
    public BinaryTree right;

    // TODO 先不封装了
    public int val;

    public int maxChild;
}


public class nio_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];

        ArrayList<BinaryTree> tree = new ArrayList<>();
        

        for (int i = 0; i < n; i++) {
            BinaryTree tempTree = new BinaryTree();
            tempTree.val = 
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();



    }
}
