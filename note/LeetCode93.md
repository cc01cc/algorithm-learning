# LeetCode 93

## 1. 题目

> - 题目链接：93. 复原 IP 地址 - 力扣（LeetCode）: <https://leetcode.cn/problems/restore-ip-addresses/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

**有效 IP 地址** 正好由四个整数（每个整数位于 `0` 到 `255` 之间组成，且不能含有前导 `0`），整数之间用 `'.'` 分隔。

- 例如：`"0.1.2.201"` 和 `"192.168.1.1"` 是 **有效 IP 地址**，但是 `"0.011.255.245"`、`"192.168.1.312"` 和 `"192.168@1.1"` 是 **无效** IP 地址。

给定一个只包含数字的字符串 `s` ，用以表示一个 IP 地址，返回所有可能的**有效 IP 地址**，这些地址可以通过在 `s` 中插入 `'.'` 来形成。你 **不能** 重新排序或删除 `s` 中的任何数字。你可以按 **任何** 顺序返回答案。

```txt
1 <= s.length <= 20
s 仅由数字组成
```

```txt
示例1

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]

示例2

输入：s = "0000"
输出：["0.0.0.0"]

示例3

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
```

## 2. 题解参考

```java
import java.util.ArrayList;
import java.util.List;

public class LeetCode93_01_01 {

    public List<String> ret = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0, 4);
        return ret;
    }

    // k 剩余需要填充的区块
    public void backTracking(String s, int startIndex, int k) {

        if (startIndex >= s.length()) {
            return;
        }
        // 当剩下最后一个区块时
        if (k == 1) {
            // 下一位是 0，并且是最后一位（即单独 0）
            // 下一位不是 0，且剩余的值小于 256
            // s.length() - startIndex 是考虑到数字过长 > Integer.MAX_VALUE 的情况
            if (s.charAt(startIndex) == '0' && startIndex == s.length() - 1 ||
                    s.charAt(startIndex) != '0' &&
                    s.length() - startIndex < 4 && Integer.valueOf(s.substring(startIndex)) < 256
            ) {
                // 直接拼接剩余的字符
                ret.add(stringBuilder.toString() + s.substring(startIndex));
                // 不使用 stringBuilder 是考虑到，这样可以省略后续的还原操作，方便理解
                // 并且进入到这一步骤的次数相对少些，直接字符串拼接对于性能的影响相对小些

                // 介意性能可以换用以下代码
//                stringBuilder.append(s.substring(startIndex));
//                ret.add(stringBuilder.toString());
//                // 添加到结果集后，务必将添加的字符删除
//                stringBuilder.delete(stringBuilder.length() - (s.length() - startIndex), stringBuilder.length());
            }
            return;
        }

        // for 循环中只处理前三个区块，所以末尾都是有 ‘.’
        for (int i = 1; i < 4 && i <= s.length() - startIndex; i++) {
            if (s.charAt(startIndex) == '0') {
                stringBuilder.append("0.");
                backTracking(s, startIndex + 1, k - 1);
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                // 0 之后不能再拼接其他数字了，所以直接跳出循环
                break;
            } else if (Integer.valueOf(s.substring(startIndex, startIndex + i)) < 256) {
                stringBuilder.append(s.substring(startIndex, startIndex + i)).append(".");
                backTracking(s, startIndex + i, k - 1);
                // stringBuilder.length() - i - 1 可以这么理解，增加了 i 个字符 + ‘.’
                // 那么就需要从当前长度减去 i + 1 个字符
                stringBuilder.delete(stringBuilder.length() - i - 1, stringBuilder.length());
            }
        }
    }
}

```

## 3. 解题思路

这题的主要考虑了以下几个方面

1. 0 不能在多个数字的开头（0要么单独成块，要么在其他数字之后）
2. 数字长度不超过 3，且大小不超过 255（先判断长度再判断大小，防止越界）
3. 前三个区块后有 `.`

从整体上

1. 我把最后一个区块（第四块）放在递归结束的语句中进行处理，刚好有别于前三个区块的处理流程
2. for 循环中，遇到 0 开头直接进入递归，从递归出来后就结束循环，返回上层

细节上

1. 许多教程判断零是使用 `s.charAt(i) - '0' == 0` 不太明白为什么不能直接使用 `s.charAt(i) == '0'`
2. 另外不太清楚 Java 中 `<` `<=` 性能上有没有区别，我后边调整的时候全部改成 `<256`（MySQL 的 SQL语句似乎推荐 `<=`）

测试主要考虑

1. 全为 0
2. 最后一个区块为 0
3. 中间区块为 0
4. 无法组成 IP 地址的情况
5. 长度超过 Integer.MAX_VALUE 的情况

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode93_01_01.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode93_01_01.java>
2. （备用，非同步）城通网盘 algorithm-learning/LeetCode93_01_01.java: <https://url57.ctfile.com/f/37032957-629588256-6a55e9?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年7月31日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
