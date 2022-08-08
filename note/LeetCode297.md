# LeetCode 297

## 1. 题目

> - 题目链接：297. 二叉树的序列化与反序列化 - 力扣（LeetCode）: <https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

- `树中结点数在范围 [0, 104] 内`
- `1000 <= Node.val <= 1000`

```txt
示例1

输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]

示例2

输入：root = []
输出：[]
```

## 2. 题解参考

```java
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树序列化的结构：
// 使用 null 将二叉树填充成完全二叉树后，按层遍历输出
public class LeetCode297_01_02 {

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
```

## 3. 解题思路

序列化后的大致结构是：

1. 使用 `null` 将二叉树填充成完全二叉树，按层遍历输出
2. （最开始我是将他填充成满二叉树，结果提交时发现和 leetcode 的测试用例不一致，再改成完全二叉树）

序列化时遇到的主要困难是，输出时如何不输出最后一层的 `null`

考虑了两种方法：

1. 标记层数；如果此层全为 `null` 则序列化结束
2. 全部序列化完成后，成对删除末尾的 `null`

在具体是实现时：

1. 我使用了两个队列，分别表示当前层的节点和下一层的节点；
2. 遍历当前层节点的同时，填充输出列表以及下一层的节点；
3. 并设计一个标记 `queueAllNull` 默认 `true` ，在填入下一层的节点时遇到不为 `null` 的值则 `queueAllNull` 转为 `false`

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode297_01_02.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode297_01_02.java>
2. （备用，非同步）城通网盘 algorithm-learning/LeetCode297_01_02.java: <https://url57.ctfile.com/f/37032957-633796126-2a442e?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建于：2022年8月6日
- 完成于：2022年8月8日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
