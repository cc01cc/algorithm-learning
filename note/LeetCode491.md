# LeetCode 491

## 1. 题目

> - 题目链接：491. 递增子序列 - 力扣（LeetCode）: <https://leetcode.cn/problems/increasing-subsequences/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给你一个整数数组 `nums` ，找出并返回所有该数组中不同的递增子序列，递增子序列中 **至少有两个元素** 。你可以按 **任意顺序** 返回答案。

数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。

- `1 <= nums.length <= 15`
- `100 <= nums[i] <= 100`

```txt
示例1

输入：nums = [4,6,7,7]
输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

示例2

输入：nums = [4,4,3,2,1]
输出：[[4,4]]
```

## 2. 题解参考

```java
import java.util.ArrayList;
import java.util.List;

public class LeetCode491_01_01 {
    public List<List<Integer>> ret = new ArrayList<>();
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return ret;
    }

    public void backTracking(int[] nums, int startIndex) {
        // 结束条件：
        // 1. startIndex 遍历到最后一个值返回
        // 2. 或者不符合要求返回
        // 这包括在后续的元素处理上，所以就不单独写了

        // 记录这一层使用过的元素
        List<Integer> usedNum = new ArrayList<>();
        for (int i = startIndex; i < nums.length; i++) {

            // 如果该层已经使用过包含相同值的元素，则直接跳过，避免重复
            if (usedNum.contains(nums[i])) {
                continue;
            }

            // 当 tempList 不为空的时候，
            // 若当前 i 所指的数小于 tempList 的最后一个数（即添加后就非递增）
            if (!tempList.isEmpty() && nums[i] < tempList.get(tempList.size() - 1)) {
                // 直接进入下一轮循环
                continue;
            }

            tempList.add(nums[i]);
            usedNum.add(nums[i]);

            // 子序列至少有两个元素
            if (tempList.size() > 1) {
                ret.add(new ArrayList<>(tempList));
            }

            backTracking(nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
```

## 3. 解题思路

这题的主要考虑了两点：

1. 如何避免结果的重复
2. 结果长度不一如何进行遍历处理

针对**重复的避免**，使用了 `usedNum` 存储在该层使用过的值，如果后续的元素与用过的值重复，则不再使用

对于**不同长度的结果**，我一开始是考虑，先统计子序列长度为 2 的所有结果，再统计长度为 3 的所有结果，依次类推；但是发现如 `[4, 6] [4, 6, 7]` 这个结果，使用这种方法需要遍历两次，正常而言找到 `[4, 6]` 之后继续找到 `[4, 6, 7]` 即可，即遍历一次。

所以我将结果集的更新 `ret.add(new ArrayList<>(tempList));` 放入到了元素处理的过程中，每次添加一个元素，则更新结果集；同时将结果集的正确性判断（即是否递增）放入到了每次添加元素之前，确保结果始终符合要求，便于结果集的更新。

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode491_01_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode491_01_01.java>
2. （备用，非同步）城通网盘 algorithm-learning/LeetCode491_01_01.java: <https://url57.ctfile.com/f/37032957-647603763-976b8a?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年8月11日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
