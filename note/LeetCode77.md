# LeetCode 77

## 1. 题目

> 原题链接：77. 组合 - 力扣（LeetCode）: <https://leetcode.cn/problems/combinations/>

给定两个整数 `n` 和 `k`，返回范围 `[1, n]` 中所有可能的 `k` 个数的组合。（可以按 任何顺序 返回答案）

```txt
示例

输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

## 2. 参考题解

```Java
// https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode77_02_01.java
import java.util.ArrayList;
import java.util.List;

/**
 * 使用回溯法
 */

public class LeetCode77_02_01 {

    // 定义返回的结果集
    public List<List<Integer>> ret = new ArrayList<>();
    // 定义每次循环的结果集
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, 0, k);

        return ret;
    }

    /**
     * 使用回溯法，递归获取结果集
     *
     * @param n 范围长度
     * @param startIndex 遍历的起始索引位置
     * @param k 遍历的层级
     */
    public void backTracking(int n, int startIndex, int k) {
        // 定义递归结束的条件
        if (k == 0) {
            // tempList 是引用类型，需要再创建一个新的集合，再赋值
            ret.add(new ArrayList<>(tempList));
            return;
        }
        // n - k + 1当剩余的范围长度小于所需的长度时，停止遍历
        for (int i = startIndex; i < n - k + 1; i++) {
            // 数据进行处理
            tempList.add(i + 1);
            // 进入递归
            backTracking(n, i + 1, k - 1);
            // 从递归中出来时，需要删除在递归中添加的数据
            tempList.remove(tempList.size() - 1);
        }
    }
}
```

## 3. 解题思路

> 参考：代码随想录 - BiliBili : <https://www.bilibili.com/video/BV1cy4y167mM>

在使用回溯算法时大致的思路：

![回溯算法的设计思路](https://raw.githubusercontent.com/cc01cc/zeorep/main/pic/202207282116427.jpg)

> 图片使用 jgraph/drawio: Source to app.diagrams.net: <https://github.com/jgraph/drawio> 创建并生成

## 4. 代码下载

> GitHub 更新会及时些

1. Github LeetCode77_02_01.java: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode77_02_01.java>
2. （备用）城通网盘 LeetCode77_02_01.java: <https://url57.ctfile.com/f/37032957-627676689-07eff3?p=9427> (访问密码: 9427)

---

- 本文系个人学习总结，
- 若代码逻辑等存在不严谨的地方，欢迎讨论，建议与私信
- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年7月28日
- 最新的代码可以参考 cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢 youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
- 关于转载
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载请私信，非商业转载和我说一下，我也会很开心的！
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可
  - 本文题目著作权归属领扣网络（上海）有限公司

回看，我的第一篇博文就是算法（CSDN 上），两年前了，那时还是大一，踌躇满志的想要参加 acm，但一开始做题怀疑人生，一道题一两个小时，一直摸不着门路，之后就慢慢放弃了。

中途我也考虑过把他拾起来，但是，每次都徘徊在门槛前，像最开始我用的是 C/C++，在编译器的挑选上 Dev C，Block::Code...MSYS2, GCC 等等纠结许久，后边又考虑 Rust，但是入了 Rust 构建操作系统这个坑，就又跑偏了。

这次的一方面是有种压力，另一方面也是自身的需求，抛开那些细节，主要从算法的核心入手，不能总是本末倒置，算法我希望可以和平常背英语之类的成为一种日常，也希望可以早日克服对算法的畏惧。

本来今天想要更两篇的，但是，排版啊，作图，引用这些，都重新熟悉起来，所以多费了些时间。然后呢，我也是个算法小白，在思路和题解上可能都有这样或那样的不严谨性，如果小伙伴发现了问题欢迎私信。
