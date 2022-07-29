# LeetCode 17

## 1. 题目

> - 题目链接：216. 组合总和 III - 力扣（LeetCode）: <https://leetcode.cn/problems/combination-sum-iii/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

找出所有相加之和为 `n` 的 `k` 个数的组合，且满足下列条件：

- 只使用数字1到9
- 每个数字 最多使用一次

返回所有可能的有效组合的列表。该列表不能包含相同的组合两次，组合可以以任何顺序返回。

```txt
示例1

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
解释:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9

示例2

输入: k = 4, n = 1
输出: []
解释: 不存在有效的组合。

在[1,9]范围内使用4个不同的数字，
我们可以得到的最小和是1+2+3+4 = 10，
因为10 > 1，没有有效的组合。
```

## 2. 题解参考

```java
import java.util.ArrayList;
import java.util.List;

public class LeetCode216_01_01 {
    // 定义结果集
    public List<List<Integer>> ret = new ArrayList<>();
    // 定义临时集合，存放每个组合
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1);
        return ret;
    }

    /**
     *
     * @param n 表示剩余需要的和
     * @param k 表示剩余可以添加的个数
     * @param startNum 表示起始的数字（因为数字不能重复）
     */
    public void backTracking(int n, int k, int startNum) {
        // 定义递归结束条件
        if (k == 0) {
            if (n == 0) ret.add(new ArrayList(tempList));
            return;
        } else if (n > k * 9) {
            // 当剩余数字全部取最大值 9 时都无法满足，则结束递归
            return;
        } else if (n < 0) {
            // 当n已经小于0时，结束递归
            return;
        }

        for (int i = startNum; i < 10; i++) {
            tempList.add(i);
            backTracking(n - i, k - 1, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
```

## 3. 代码下载

1. **Github** algorithm-learning/LeetCode216_01_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode216_01_01.java>
2. （备用，非同步）城通网盘 algorithm-learning/LeetCode216_01_01.java: <https://url57.ctfile.com/f/37032957-628657088-0833dd?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年7月29日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可

---

- 本文系个人学习总结，
- 若代码逻辑等存在不严谨的地方，
- 若文字表述存在不易理解的地方，欢迎讨论，建议；
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - 代码随想录给我提供了许多解题的思路和指导
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
  - 作图使用的是 drawio，一款挺不错的流程图，UML 图绘制软件（开源，并且支持浏览器作图哦！）
  - jgraph/drawio: Source to app.diagrams.net: <https://github.com/jgraph/drawio>
