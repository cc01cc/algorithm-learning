# LeetCode 47 全排列 II - Java 实现

## 1. 题目

> - 题目链接：47. 全排列 II - 力扣（LeetCode）: <https://leetcode.cn/problems/permutations-ii/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给定一个可包含 **重复** 数字的序列 `nums` ，**按任意顺序** 返回所有不重复的全排列。

- `1 <= nums.length <= 8`
- `10 <= nums[i] <= 10`

```txt
示例1

输入：nums = [1,1,2]
输出：
[[1,1,2],[1,2,1],[2,1,1]]

示例2

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

## 2. 题解参考

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode47_01_01 {

    public List<List<Integer>> ret = new LinkedList<>();
    public LinkedList<Integer> tempList = new LinkedList<>();


    public List<List<Integer>> permuteUnique(int[] nums) {
        // 因为 boolean 的默认值是 false，为了保持语义的一致
        // numBeUsed 数组记录指定位置的值是否被使用
        boolean[] numBeUsed = new boolean[nums.length];

        // 对数据进行排序
        // 元素处理时，遇到和后一个元素相同的元素则不处理
        Arrays.sort(nums);
        backTracking(nums, numBeUsed);

        return ret;
    }

    public void backTracking(int[] nums, boolean[] numBeUsed) {
        // 当 tempList 的长度和 nums 长度一致时，说明所有元素已被添加
        if (tempList.size() == nums.length) {
            ret.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 添加当前值到 tempList 的情况：
            // 当前值可用，且为第一个值；
            // 当前值可用，且前一个值和当前值不一致；
            // 当前值可用，且前一个值和当前值相同但不可用；

            // 不添加的情况：
            // 当前值不可用(即被使用);
            // 当前值可用，但该层已经使用过相同的值
            // (每次使用后，都跳转到下一个不同的值，所以判断时不需要考虑)
            
            if (numBeUsed[i] == true) {
                continue;
            }

            tempList.add(nums[i]);
            numBeUsed[i] = true;
            // i 在后续的 while 循环中，值会发生变化
            // 使用 temp 进行记录，以便递归结束时回复索引为 i 的值的状态
            int temp = i;


            // 循环结束后，i 位于和当前值一致的最后一位索引
            // 之后 for 循环 i++ 时，刚好跳到和当前值不一致的第一位索引
            // 同时避免了尾部指针的溢出
            // 假设 i 为 1, nums 为 [1,2,2,2]
            // while 循环结束后，i 为 3
            // 此轮 for 循环结束后，i 为 4，结束遍历
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }

            backTracking(nums, numBeUsed);
            tempList.removeLast();
            numBeUsed[temp] = false;
        }
    }
}
```

## 3. 解题思路

做这题遇到的障碍主要是重复数字的问题：

1. 这一层是否使用过相同数字
2. 如何记录这一层使用过数字，不再被同层使用
3. 同时下层会使用到处于不同位置的相同的数字

方法：

1. 使用 `numBeUsed` 标记数字是否被使用，从而避免**下一层**的重复使用
2. 对数组进行升序排序
3. 当前数字使用后，跳转到与当前数字不同的数字，避免**同层**的重复使用

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode47_01_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode47_01_01.java>
2. （备用，非同步）城通网盘 algorithm-learning/LeetCode47_01_01.java: <https://url57.ctfile.com/f/37032957-648734225-b5ed90?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年8月13日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
- TAG: 回溯 Java LeetCode 算法 algorithm
