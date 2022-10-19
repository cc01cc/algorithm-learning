#! https://zhuanlan.zhihu.com/p/575315107
# LeetCode 349 两个数组的交集 - Java 实现

## 1. 题目

> 原题链接：349. 两个数组的交集 - 力扣（LeetCode）: <https://leetcode.cn/problems/intersection-of-two-arrays/>

给定两个数组 `nums1` 和 `nums2` ，返回 **它们的交集** 。输出结果中的每个元素一定是 **唯一** 的。我们可以 **不考虑输出结果的顺序** 。

- `1 <= nums1.length, nums2.length <= 1000`
- `0 <= nums1[i], nums2[i] <= 1000`

```txt
示例1

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例2

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的
```

## 2. 参考题解

```Java
// https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode349_01_01.java
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LeetCode349_01_01 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        return resSet.stream().mapToInt(x -> x).toArray();
    }

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] res = new LeetCode349_01_01().intersection(nums1, nums2);
        for (int i : res) {
            System.out.print(i + "\t");
        }
    }
}
```

## 3. 解题思路

- 本题主要利用了 HashSet 元素不重复的性质
- 首先使用一个 集合 set1 记录 nums1 中出现的所有元素
- 之后遍历 nums2，使用另一个集合 setRes 存储交集的元素
- 最后将 set 使用 stream 流 转换成数组

## 4. 代码下载

1. Github cc01cc/algorithm-learning/LeetCode349_01_01.java : <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode349_01_01.java>

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年10月19日
- 欢迎大家转载分享，本作品采用[署名-非商业性使用-禁止演绎 4.0 国际](https://creativecommons.org/licenses/by-nc-nd/4.0/)进行许可，转载请标明源地址，切莫破坏或修改原文结构，谢谢
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
- TAG: 哈希 Java LeetCode 算法 algorithm
