#! https://zhuanlan.zhihu.com/p/573614781
# LeetCode 242 有效的字母异位词 C++ 实现

## 1. 题目

> 原题链接：242. 有效的字母异位词 - 力扣（LeetCode）: <https://leetcode.cn/problems/valid-anagram/>

给定两个字符串 `s` 和 `t` ，编写一个函数来判断 `t` 是否是 `s` 的字母异位词。

注意：若 `s` 和 `t` 中每个字符出现的次数都相同，则称 `s` 和 `t` 互为字母异位词。

- `1 <= s.length, t.length <= 5 * 104`
- `s` 和 `t` 仅包含小写字母

```txt
示例1

输入: s = "anagram", t = "nagaram"
输出: true

示例2

输入: s = "rat", t = "car"
输出: false
```

## 2. 参考题解

```C++
// https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode242_01_01.cpp
#include <iostream>
using namespace std;
class Solution
{
public:
    bool isAnagram(string s, string t)
    {
        int alphabetArray[26] = {0};
        for (int i = 0; i < s.size(); i++)
        {
            alphabetArray[s[i] - 'a']++;
        }
        for (int i = 0; i < t.size(); i++)
        {
            alphabetArray[t[i] - 'a']--;
        }

        for (int i = 0; i < sizeof(alphabetArray) / sizeof(alphabetArray[0]); i++)
        {
            if (alphabetArray[i] != 0)
                return false;
        }
        return true;
    }
};

int main()
{
    Solution solution;
    bool res = solution.isAnagram("anagram", "nagaram");
    cout << res << endl;
}

```

## 3. 解题思路

**核心思想**：若两个字符串为有效的字母异位词，则每个字母出现的次数应该相同，所以统计每个字符串中每个字母出现的次数即可

1. 定义一个长度为 26 的数组，按顺序表示 26 个字母
2. 读取第一个字符串 `s` ，统计每个字母出现的次数，例如 `a` 出现一次，`alphabetArray[s[i] - 'a']++`
3. 读取第二个字符串 `t` ，每出现一个字母，则减去一次，例如 `a` 出现一次，`alphabetArray[s[i] - 'a']--`
4. 若为字母异位词，则经过加减后所有字母的次数应该为 0；
5. 遍历数组，若存在不为 0 的值，则返回 false 否则返回 true


## 4. 代码下载

1. Github algorithm-learning/LeetCode242_01_01.cpp at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode242_01_01.cpp>

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年10月14日
- 欢迎大家转载分享，本作品采用[署名-非商业性使用-禁止演绎 4.0 国际](https://creativecommons.org/licenses/by-nc-nd/4.0/)进行许可，转载请标明源地址，切莫破坏或修改原文结构，谢谢
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
- TAG: C++ 哈希 LeetCode 算法 algorithm
