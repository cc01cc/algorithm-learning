# LeetCode 46 全排列 - Java 实现

## 1. 题目

> - 题目链接：46. 全排列 - 力扣（LeetCode）: <https://leetcode.cn/problems/permutations/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给定一个不含重复数字的数组 `nums` ，返回其 **所有可能的全排列** 。你可以 **按任意顺序** 返回答案。

- `1 <= nums.length <= 6`
- `10 <= nums[i] <= 10`
- `nums 中的所有整数 互不相同`

```txt
示例1

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

示例2

输入：nums = [0,1]
输出：[[0,1],[1,0]]

示例3
输入：nums = [1]
输出：[[1]]
```

## 2. 题解参考

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode46_01_02 {

    List<List<Integer>> ret = new LinkedList<>();
    LinkedList<Integer> tempList = new LinkedList<>();


    public List<List<Integer>> permute(int[] nums) {
        // 定义一个与 nums 等长的数组，用于记录当前的值是否被使用
        // true 表示已被使用
        // false 表示未被使用
        boolean[] numState = new boolean[nums.length];
        backTracking(nums, numState);
        return ret;
    }

    public void backTracking(int[] nums, boolean[] numState) {
        // tempList 和 nums 长度相等表名所有元素都已经添加
        if (tempList.size() == nums.length) {
            ret.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果元素已经被使用过，则直接进入下一轮循环
            if (numState[i]) {
                continue;
            }
            tempList.add(nums[i]);
            numState[i] = true;

            backTracking(nums, numState);

            numState[i] = false;
            tempList.removeLast();
        }
    }
}
```

## 3. 解题思路

这题的我主要考虑的难点是：

- 如何判断这个元素是否使用过

最开始我使用的是列表存储没有被使用过的元素 [LeetCode40_01_01](https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode40_01_01.java) ，但是发现速度比较慢，之后替换成本文中使用数组记录每个元素使用状态的方法。

## 4. 代码下载

1. **Github** （使用数组）algorithm-learning/LeetCode46_01_02.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode46_01_02.java>
2. **Github** （使用列表）algorithm-learning/LeetCode40_01_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode40_01_01.java>
3. （备用，非同步）城通网盘 algorithm-learning/LeetCode46_01_02.java: <https://url57.ctfile.com/f/37032957-647606214-c731fa?p=9427> (访问密码: 9427)
4. （备用，非同步）城通网盘 algorithm-learning/LeetCode46_01_01.java: <https://url57.ctfile.com/f/37032957-647606212-33ecfa?p=9427> (访问密码: 9427)

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
- TAG: 回溯 Java LeetCode 算法 algorithm
