# LeetCode 78

## 1. 题目

> - 题目链接：93. 复原 IP 地址 - 力扣（LeetCode）: <https://leetcode.cn/problems/restore-ip-addresses/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给你一个整数数组 `nums` ，数组中的元素 **互不相同** 。返回该数组所有可能的子集（幂集）。

解集 **不能** 包含重复的子集。你可以按 **任意顺序** 返回解集。

- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`
- `nums 中的所有元素 互不相同`

```txt
示例1

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

示例2

输入：nums = [0]
输出：[[],[0]]
```

## 2. 题解参考

```java
import java.util.ArrayList;
import java.util.List;

public class LeetCode78_02_01 {
    public List<List<Integer>> ret = new ArrayList<>();
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 这儿的 i 表示组成单个结果的元素个数
        // 不是表示索引，所以需要在 nums.length 后 +1
        // 从零开始包含空集
        for (int i = 0; i < nums.length + 1; i++) {
            backTracking(nums, 0, i);
        }
        return ret;
    }

    public void backTracking(int[] nums, int startIndex, int k) {
        if (k == 0) {
            ret.add(new ArrayList(tempList));
            return;
        }

        // k - 1 表示除了本层之外（即 - 1）仍需要的元素个数
        // i 至多遍历到 nums.length - (k - 1) 即可，之后的元素留给下一层递归
        for (int i = startIndex; i < nums.length - (k - 1); i++) {
            tempList.add(nums[i]);
            backTracking(nums, i + 1, k - 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
```

## 3. 解题思路

这题和其他的组合的主要区别在于，结果集中的每个结果长度不一致

主要思路：通过在主函数 `subsets(int[] nums)` 中控制结果的长度，回溯函数每次返回特定长度的结果集。

其他的细节上，主要是我注释的两点

1. i 作为长度而非索引使用
2. 以及 `k` 需要 `-1`

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode78_02_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode78_02_01.java>
2. （备用，非同步）城通网盘 algorithm-learning/LeetCode78_02_01.java: <https://url57.ctfile.com/f/37032957-630543574-3c5a84?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年8月1日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
