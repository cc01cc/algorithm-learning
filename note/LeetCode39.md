# LeetCode 39

## 1. 题目

> - 题目链接：39. 组合总和 - 力扣（LeetCode）: <https://leetcode.cn/problems/combination-sum/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给你一个 **无重复元素** 的整数数组 `candidates` 和一个目标整数 `target` ，找出 `candidates` 中可以使数字和为目标数 `target` 的 **所有** 不同组合 ，并以列表形式返回。你可以按 **任意顺序** 返回这些组合。

`candidates` 中的 **同一个** 数字可以无限制 **重复被选取** 。如果至少一个数字的被选数量不同，则两种组合是不同的。

对于给定的输入，保证和为 `target` 的不同组合数少于 `150` 个。

```txt
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都 互不相同
1 <= target <= 500
```

```txt
示例1

输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。

示例2

输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]

示例3

输入: candidates = [2], target = 1
输出: []
```

## 2. 题解参考

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39_02_01 {
    // 定义返回的结果集
    public List<List<Integer>> ret = new ArrayList<>();
    // 临时存储单个结果（即组合）
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 对数组进行排序方便后续的剪枝操作
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return ret;
    }

    /**
     * 回溯递归函数
     * @param candidates 提供数字的数组
     * @param target 当前递归剩余需要的目标整数
     * @param startIndex 当前递归开始遍历的索引位置
     */
    public void backTracking(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            ret.add(new ArrayList(tempList));
            return;
        } else if (target < 0 || startIndex == candidates.length) {
            return;
        }

        // candidates[i] <= target 剪枝操作，由于之前进行了排序，所以当值大于 target 时
        // 后续的元素就不需要遍历了
        for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            tempList.add(candidates[i]);
            // startIndex 取 i 表示可以重复取当前的值，以及之后的值
            backTracking(candidates, target - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
```

## 3. 解题思路

- 感觉是一道相对平常的回溯题，整体思路可以参考我之前在 `LeetCode 77` 中的思路图。
- 一个小变化，就是这道题可以重复取值，所以 `startIndex` 不需要 `i+1`

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode39_02_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode39_02_01.java>
2. （备用，非同步）城通网盘 algorithm-learning/LeetCode39_02_01.java: <https://url57.ctfile.com/f/37032957-629196308-2fcb27?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年7月30日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
  - jgraph/drawio: Source to app.diagrams.net: <https://github.com/jgraph/drawio>
