# LeetCode 144

## 1. 题目

> - 题目链接：144. 二叉树的前序遍历 - 力扣（LeetCode）: <https://leetcode.cn/problems/binary-tree-preorder-traversal/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给你二叉树的根节点 `root` ，返回它节点值的 **前序** 遍历。

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
```

### 2.2. 非递归实现

```java
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
```

## 3. 解题思路

二叉树的前序遍历和中序遍历的非递归实现大体一致，主要是调整了输出位置。

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode144_01_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode144_01_01.java>
2. **Github** algorithm-learning/LeetCode144_01_02.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode144_01_02.java>
3. （备用，非同步）城通网盘 algorithm-learning/LeetCode144_01_01.java: <https://url57.ctfile.com/f/37032957-632830772-a1086f?p=9427> (访问密码: 9427)
4. （备用，非同步）城通网盘 algorithm-learning/LeetCode144_01_02.java: <https://url57.ctfile.com/f/37032957-632830773-f8975f?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建：2022年8月4日
- 完成于：2022年8月5日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>

附：前序遍历是昨天做的，昨天被后序遍历的非递归实现卡了两个多小时，所以就拖到了今天。
