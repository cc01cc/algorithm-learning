# LeetCode 145

## 1. 题目

> - 题目链接：145. 二叉树的后序遍历 - 力扣（LeetCode）: <https://leetcode.cn/problems/binary-tree-postorder-traversal/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给你二叉树的根节点 `root` ，返回它节点值的 **后序** 遍历。

- `树中节点数目在范围 [0, 100] 内`
- `-100 <= Node.val <= 100`

```java
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
}
```

## 2. 题解参考

### 2.1. 递归实现

```java

import java.util.ArrayList;
import java.util.List;

public class LeetCode145_01_01 {
    public List<Integer> binaryTreeList = new ArrayList<>();


    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return binaryTreeList;
        }

        // 前序遍历
//        binaryTreeList.add(root.val);
        postorderTraversal(root.left);
        // 中序遍历
//        binaryTreeList.add(root.val);
        postorderTraversal(root.right);
        // 后序遍历
        binaryTreeList.add(root.val);
        return binaryTreeList;
    }
}
```

### 2.2. 非递归实现

```java
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

}
```

## 3. 解题思路

- 二叉树的后序遍历磨了好久，为了测试，还专门写了二叉树的序列化和反序列化。
- `cur = null;` 就是这行代码，让我苦思了两天。。。

整体思路是

1. 使用堆栈存放节点；
2. 弹出节点时，记录节点；
3. 只有但左右孩子都弹出后，才会弹出节点；
   1. 使用一个变量标记上一个弹出的节点，
   2. 如果是右孩子，或者右孩子为空，则弹出这个节点

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode145_01_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode145_01_01.java>
2. **Github** algorithm-learning/LeetCode145_01_02.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode145_01_02.java>
3. （备用，非同步）城通网盘 algorithm-learning/LeetCode145_01_01.java: <https://url57.ctfile.com/f/37032957-633799680-90e1d5?p=9427> (访问密码: 9427)
4. （备用，非同步）城通网盘 algorithm-learning/LeetCode145_01_02.java: <https://url57.ctfile.com/f/37032957-633799681-faaac6?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建：2022年8月4日
- 完成于：2022年8月8日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
