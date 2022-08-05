# LeetCode 509

## 1. 题目

> - 题目链接：509. 斐波那契数 - 力扣（LeetCode）: <https://leetcode.cn/problems/fibonacci-number/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

**斐波那契数** （通常用 `F(n)` 表示）形成的序列称为 斐**波那契数列** 。该数列由 `0` 和 `1` 开始，后面的每一项数字都是前面两项数字的和。也就是：

```txt
F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
```

给定 `n` ，请计算 `F(n)` 。

- `0 <= n <= 30`

```txt
示例1

输入：n = 2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1

示例2

输入：n = 3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2
```

## 2. 题解参考

### 2.1. 动态规划实现

```java
public class LeetCode509_02_01 {
    public int fib(int n) {
        // 定义 dp[] 数组; dp[i]: 存放第 i 位的斐波那契数
        int[] dp = new int[n];

        // 考虑特殊情况
        if (n < 2) {
            return n;
        }

        // 设置初始值
        dp[0] = 1;
        dp[1] = 1;

        // 从左往右遍历
        for (int i = 2; i < n; i++) {
            // 递推公式
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
```

### 2.2. 动态规划简化

```java
import java.util.ArrayList;
public class LeetCode509_02_02 {
    public int fib(int n) {

        // 考虑特殊情况
        if (n < 2) {
            return n;
        }

        // 设置初始值
        int dpA = 1;
        int dpB = 1;
        int temp = 0;

        // 从左往右遍历
        for (int i = 2; i < n; i++) {
            // 递推公式
            temp = dpB;
            dpB += dpA;
            dpA = temp;
        }

        return dpB;
    }
}
```

## 3. 解题思路

这道题主要是参考 [代码随想录 - 动态规划理论基础](https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.md#%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%9A%84%E8%A7%A3%E9%A2%98%E6%AD%A5%E9%AA%A4)
体验了一下动态规划的基本解题思路：

1. 确定 `dp[i]` 的含义
2. 设计递推公式
3. 初始化变量
4. 考虑遍历顺序
5. 打印 `dp[i]`

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode509_02_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode509_02_01.java>
2. **Github** algorithm-learning/LeetCode509_02_02.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode509_02_02.java>
3. （备用，非同步）城通网盘 algorithm-learning/LeetCode509_02_01.java: <https://url57.ctfile.com/f/37032957-632831533-47a82d?p=9427> (访问密码: 9427)
4. （备用，非同步）城通网盘 algorithm-learning/LeetCode509_02_02.java: <https://url57.ctfile.com/f/37032957-632831534-9a35d1?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年8月5日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>

附：明天会继续做回溯，今天如果数学英语等等学了还有时间，争取把昨天没解出来的后序遍历完成。
