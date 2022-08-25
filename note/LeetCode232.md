# LeetCode 232

## 1. 题目

> 原题链接：232. 用栈实现队列 - 力扣（LeetCode）: <https://leetcode.cn/problems/implement-queue-using-stacks/>

请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

实现 `MyQueue` 类：

- `void push(int x)` 将元素 x 推到队列的末尾
- `int pop()` 从队列的开头移除并返回元素
- `int peek()` 返回队列开头的元素
- `boolean empty()` 如果队列为空，返回 `true` ；否则，返回 `false`

说明：

你 **只能** 使用标准的栈操作 —— 也就是只有 `push to top`, `peek/pop from top`, `size`, 和 `is empty` 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 `list` 或者 `deque`（双端队列）来模拟一个栈，只要是标准的栈操作即可。

- 1 <= x <= 9
- 最多调用 100 次 push、pop、peek 和 empty
- 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）

```txt
示例

输入：
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 1, 1, false]

解释：
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/implement-queue-using-stacks
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

## 2. 参考题解

```Java
// https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode232_01_01.java
import java.util.Stack;

public class LeetCode232_01_01 {

//  public MyQueue() {}

    // 定义两个栈，一个用于存入一个用于取出
    public Stack<Integer> input = new Stack<>();
    public Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        // 当 output 的元素为空时，从 input 中调用元素
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    public int peek() {
        // 直接调用 pop(), 之后再将弹出的元素放入即可
        int temp = this.pop();
        output.push(temp);
        return temp;
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
```

## 3. 解题思路

大致的思路是定义两个栈，一个栈用于存入元素 `input`, 另一个栈用于取出元素 `output`;

这题主要的思考的是关于两个栈内元素切换的时机：

在思考后，为了确保元素顺序的一致，当 `output` 栈内的元素取完时，再向 `input` 栈获取元素。

## 4. 代码下载

1. Github cc01cc/algorithm-learning/LeetCode232_01_01.java at master: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode232_01_01.java>
2. （备用，非同步）城通网盘 LeetCode232_01_01.java: <https://url57.ctfile.com/f/37032957-656586276-b77741?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年8月25日
- 欢迎大家转载分享，本作品采用[署名-非商业性使用-禁止演绎 4.0 国际](https://creativecommons.org/licenses/by-nc-nd/4.0/)进行许可，转载请标明源地址，切莫破坏或修改原文结构，谢谢
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
- TAG: 栈 队列 Java LeetCode 算法 algorithm
