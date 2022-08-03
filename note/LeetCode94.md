# LeetCode 94

## 1. 题目

> - 题目链接：94. 二叉树的中序遍历 - 力扣（LeetCode）: <https://leetcode.cn/problems/binary-tree-inorder-traversal/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给定一个二叉树的根节点 `root` ，返回 它的 **中序** 遍历 。

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

public class LeetCode94_02_01 {
    public List<Integer> binaryTreeList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归结束条件
        // 虽然可以整个包裹在 if-else 里
        // 但考虑这样逻辑清晰些，就单独提前了
        if (root == null) {
            return binaryTreeList;
        }

        // 前序遍历
        binaryTreeList.add(root.val);
        inorderTraversal(root.left);
        // 中序遍历
        binaryTreeList.add(root.val);
        inorderTraversal(root.right);
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

public class LeetCode94_02_02 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> binaryTreeList = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();

        // 当二叉树为空时
        if (root == null) {
            return binaryTreeList;
        }

        // 二叉树当前节点
        TreeNode cur = root;
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 当节点或栈不为空时
        // 当栈为空，节点不为空，除了插入根节点，可能还有右孩子
        while (cur != null || !treeNodeStack.isEmpty()) {
            // do {
            // 根节点为 null 的话，前边判断了直接返回
            // 此处 cur 为 null，表示没有右孩子
            // 所以不需要增加新的左孩子
            if (cur != null) {
                // 第一次执行时添加根节点
                // 之后此处都是添加右孩子
                treeNodeStack.push(cur);
                while (cur.left != null) {
                    treeNodeStack.push(cur.left);
                    cur = cur.left;
                }
            }
            cur = treeNodeStack.pop();
            binaryTreeList.add(cur.val);
            cur = cur.right;
        }
        return binaryTreeList;
    }

}
```

## 3. 解题思路

二叉树的中序遍历，递归的方法不算复杂，左孩子递归到底，开始插入节点，每插入一个节点进入右孩子的递归。

参考这个思路，通过堆栈实现非递归的方法

1. 遍历左孩子，将他们逐个 push 到堆栈中
2. 然后每取出一个看看节点有没有右孩子
3. 有右孩子的话，就再遍历右孩子的左孩子
4. 如此循环

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode94_02_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode94_02_01.java>
2. **Github** algorithm-learning/LeetCode94_02_02.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode94_02_02.java>
3. （备用，非同步）城通网盘 algorithm-learning/LeetCode94_02_01.java: <https://url57.ctfile.com/f/37032957-631879050-c9a393?p=9427> (访问密码: 9427)
4. （备用，非同步）城通网盘 algorithm-learning/LeetCode94_02_02.java: <https://url57.ctfile.com/f/37032957-631879052-f495ed?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年8月3日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>

附：昨天数学题做得魔怔了，然后晚上又有些意难平，摸鱼了一天，抱歉 `<( _ _ )>`
