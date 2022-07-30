# LeetCode 131

## 1. 题目

> - 题目链接：131. 分割回文串 - 力扣（LeetCode）: <https://leetcode.cn/problems/palindrome-partitioning/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给你一个字符串 `s`，请你将 `s` 分割成一些子串，使每个子串都是 **回文串** 。返回 `s` 所有可能的分割方案。

**回文串** 是正着读和反着读都一样的字符串。

```txt
1 <= s.length <= 16
s 仅由小写英文字母组成
```

```txt
示例1

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]

示例2

输入：s = "a"
输出：[["a"]]
```

## 2. 题解参考

```java
import java.util.ArrayList;
import java.util.List;

public class LeetCode131_01_01 {

    public List<List<String>> ret = new ArrayList<>();
    public List<String> tempList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return ret;
    }

    public void backTracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            ret.add(new ArrayList<>(tempList));
            return;
        }

        // i 负责控制截取子串的长度
        // startIndex + i 的最大值需要等于 s.length()
        // 所以 i <= s.length - startIndex
        for (int i = 1; i <= s.length() - startIndex; i++) {
            String tempStr = s.substring(startIndex, startIndex + i);

            if (judgePalindrome(tempStr)) {
                tempList.add(tempStr);
            } else {
                continue;
            }
            // 截取时，左闭右开，所以下一轮从 startIndex + 1 开始
            backTracking(s, startIndex + i);
            tempList.remove(tempList.size() - 1);
        }
    }

    // 判断是否为回文串
    public boolean judgePalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
```

## 3. 解题思路

略有些惭愧，发现还是第一次做这题的时候，思路清晰。

下图，我提取了回溯函数部分的大致思路；

我觉得最主要的还是关于回文串的判断，

1. 是回文串则进入递归，
2. 不是回文串则继续添加字符，直到成为回文串或字符串终止

![LeetCode131回溯函数思路](https://raw.githubusercontent.com/cc01cc/zeorep/main/pic/202207301705620.jpg)

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode131_01_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode131_01_01.java>
2. （备用，非同步）城通网盘 algorithm-learning/LeetCode131_01_01.java: <https://url57.ctfile.com/f/37032957-629204274-c67628?p=9427> (访问密码: 9427)

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
