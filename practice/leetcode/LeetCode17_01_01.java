/*
 *    Copyright (c) 2022. cc01cc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 使用 String 版本，尚有 TODO 未解决
 */
public class LeetCode17_01_01 {

    public List<String> ret = new ArrayList<>();
    // 需要添加 new String();
    // 否则默认初始化为 null
    // 会返回 [nullad, nullae, nullaf, nullbd, nullbe, nullbf, nullcd, nullce, nullcf]
     public String tempString = new String();
    // TODO 尚不明白，为什么不添加 new String() 会打印 null

//    public StringBuilder sringBuilder = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        // 定义一个链表临时存放每个数字对应的字母集合
        List<Character> tempCharList = new LinkedList<>();
        // 定义一个数组索引为数字，每个索引存放一个链表的地址，链表中存放数字对应的字母集合
        // 数组长度定义为 10，索引对应数字
        List[] numToLetter = new List[10];

        // 定义一个变量，专门记录字母的索引
        int charIndex = 0;

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
//        System.out.println(numToLetter[2].size());
        backTracking(numToLetter, digits, 0);
        return ret;
    }

    // numToLetter 为数字到字母的映射表
    // number 表示需要组合的数字
    // index 表示此轮递归需要遍历的数字的索引
    public void backTracking(List[] numToLetter, String number, int index){
        // 当字符串中的数字都读取完后，返回
        if (index == number.length()) {
            ret.add(tempString);
            return;
        }

        // '0' 不等于 0 务必相减
        // 否则 java.lang.ArrayIndexOutOfBoundsException: Index 50 out of bounds for length 10
        int num = number.charAt(index) - '0';
        for (int i = 0; i < numToLetter[num].size(); i++) {
            tempString += numToLetter[num].get(i);
//            System.out.println(tempString);
            backTracking(numToLetter, number, index + 1);
            tempString = tempString.substring(0, tempString.length() - 1);
        }
    }

    @Test
    public void test() {
        String digits = "23";
        System.out.println(this.letterCombinations(digits));
    }
}
