# LeetCode 17

## 1. 题目

> - 题目链接：电话号码的字母组合 - 电话号码的字母组合 - 力扣（LeetCode）: <https://leetcode.cn/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/>
> - 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给定一个仅包含数字 `2-9` 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 `0, 1` 不对应任何字母。

```txt
// 可以前往题目链接查看查看电话按键图片
2: abc;     3: def;     4: ghi;     5: jkl;
6: mno;     7: pqrs;    8: tuv;     9: wxyz;
```

```txt
示例1

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

示例2

输入：digits = ""
输出：[]
```

## 2. 题解参考

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LeetCode17_01_02 {

    // 定义结果集
    public List<String> ret = new ArrayList<>();
    // 定义每次遍历时的临时结果，考虑到字符串拼接，并且没有并发需求，就使用 StringBuilder
    public StringBuilder stringBuilder = new StringBuilder();


    public List<String> letterCombinations(String digits) {
        // idea 中调试的时候发现 [""] 也会显示成 []
        // TODO 暂不清楚是什么原因
        if (digits == null || digits.length() == 0) {
            return ret;
        }

        // 因为 leetcode中 使用类静态变量总是会冲突，所以就这儿作为局部变量申明了
        // 我觉得更好的方式是初始化类的时候就初始化 NumToLetter
        List[] numToLetter = this.getNumToLetter();

        backTracking(numToLetter, digits, 0);
        return ret;
    }

    /**
     * 获取一个数字到字母的映射表
     *
     * @return List[]
     */
    public List[] getNumToLetter() {
        // 定义一个数组索引为数字，每个索引存放一个链表的地址，链表中存放数字对应的字母集合
        // 数组长度定义为 10，索引对应数字
        List[] numToLetter = new List[10];
        // 定义一个链表临时存放每个数字对应的字母集合
        List<Character> tempCharList = new LinkedList<>();
        // 定义一个变量，专门记录字母的索引
        int charIndex = 0;

        // 不太想手敲 abcd，总感觉不灵活，所以就使用循环添加
        for (int i = 2; i < 10; i++) {
            // 每个数字对应三个字母
            for (int j = 0; j < 3; j++) {
                tempCharList.add((char) ('a' + charIndex));
                charIndex++;
            }
            // 7 和 9 对应四个字母，需要单独考虑
            if (i == 7 || i == 9) {
                tempCharList.add((char) ('a' + charIndex));
                charIndex++;
            }
            numToLetter[i] = new ArrayList<>(tempCharList);
            tempCharList.clear();
        }
        return numToLetter;
    }

    /**
     * @param numToLetter 数字到字母的映射表
     * @param number      表示需要组合的数字
     * @param index       表示此轮递归需要遍历的数字的索引
     */
    public void backTracking(List[] numToLetter, String number, int index) {
        // 当字符串中的数字都读取完后，返回
        if (index == number.length()) {
            ret.add(stringBuilder.toString());
            return;
        }

        // '0' 不等于 0 务必相减
        // 否则 java.lang.ArrayIndexOutOfBoundsException: Index 50 out of bounds for length 10
        int num = number.charAt(index) - '0';
        for (int i = 0; i < numToLetter[num].size(); i++) {
            stringBuilder.append(numToLetter[num].get(i));
            backTracking(numToLetter, number, index + 1);
            stringBuilder = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
```

## 3. 解题思路

![Leetcode17解题思路](https://raw.githubusercontent.com/cc01cc/zeorep/main/pic/202207292138566.jpg)

## 4. 代码下载

1. **Github** algorithm-learning/LeetCode17_01_02.java at master · cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning/blob/master/practice/leetcode/LeetCode17_01_02.java>
2. （备用，非同步）城通网盘 algorithm-learning/LeetCode17_01_02.java: <https://url57.ctfile.com/f/37032957-628657087-10aa46?p=9427> (访问密码: 9427)

---

- 署名：cc01cc: <https://github.com/cc01cc>
- 创建并完成于：2022年7月29日
- 关于**转载**
  - 欢迎大家转载分享，转载请标明源地址，切莫破坏或修改原文结构，谢谢
  - 商业转载务必私信通知，非商业转载欢迎私信
  - 在遵守前置规则的条件下，本作品采用[知识共享署名-相同方式共享 4.0 国际许可协议](https://creativecommons.org/licenses/by-sa/4.0/legalcode.zh-Hans)进行许可

---

- 本文系个人学习总结，
- 若代码逻辑等存在不严谨的地方，
- 若文字表述存在不易理解的地方，欢迎讨论，建议；
- 关于解题思路，我想尽可能直观的描述，所以选择了图的方式，
- 希望可以对大家理解提供些许帮助；
- 代码笔记等存放并更新自
  - cc01cc/algorithm-learning: <https://github.com/cc01cc/algorithm-learning>
- 感谢
  - 代码随想录给我提供了许多解题的思路和指导
  - youngyangyang04/leetcode-master: 《代码随想录》LeetCode 刷题攻略: <https://github.com/youngyangyang04/leetcode-master>
  - 作图使用的是 drawio，一款挺不错的流程图，UML 图绘制软件（开源，并且支持浏览器作图哦！）
  - jgraph/drawio: Source to app.diagrams.net: <https://github.com/jgraph/drawio>
