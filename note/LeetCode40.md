# LeetCode 40

## 1. 题目

> - 题目链接：40. 组合总和 II - 力扣（LeetCode）: <https://leetcode.cn/problems/combination-sum-ii/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给定一个候选人编号的集合 `candidates` 和一个目标数 `target` ，找出 `candidates` 中所有可以使数字和为 `target` 的组合。

`candidates` 中的每个数字在每个组合中只能使用 **一次** 。

注意：解集不能包含重复的组合。

```txt
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
```

```txt
示例1

输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[[1,1,6],[1,2,5],[1,7],[2,6]]

示例2

输入: candidates = [2,5,2,1,2], target = 5,
输出:
[[1,2,2],[5]]
```

## 2. 题解参考

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40_01_01 {
    public List<List<Integer>> ret = new ArrayList<>();
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return ret;
    }

    public void backTracking(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            ret.add(new ArrayList(tempList));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            tempList.add(candidates[i]);
            // 因为不能重复，所以下一轮就从 i + 1 开始
            backTracking(candidates, target - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1);
            // 因为此层已经使用过 candidates[i] 所以同层，和它相同的数字都跳过
            while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) {
                i++;
            }
        }
    }
}
```

## 3. 解题思路

相比于 LeetCode 39 这题主要的麻烦在于重复

1. 首先题目中不允许有重复的解，但提供的集合存在重复的值
   1. 如示例1 `[1,2,5]`和`[2,1,5]`是分别取前一个`1`和后一个`1`的结果，但这属于重复的解，需要舍弃
2. 其次，题目中不允许重复使用，但是提供的集合存在重复的值
   1. 如示例1 `[1,1,6]` 两个`1`虽然重复，但分别对应集合中不同的索引

针对以上两个重复问题，我的思路主要是：

1. 对提供的集合进行升序排序
2. 跳过同一层级中使用过的值
3. 因为要保持同一层级，所以需要把判断语句放到了递归语句之后

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode40_01_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode40_01_01.java>
2. （备用，非同步）城通网盘 algorithm-learning/LeetCode40_01_01.java: <https://url57.ctfile.com/f/37032957-629196310-e94f6a?p=9427> (访问密码: 9427)

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
