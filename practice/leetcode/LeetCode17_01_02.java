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

    @Test
    public void test() {
        String digits = "23";
        System.out.println(this.letterCombinations(digits));
    }

    // stringBuilder = stringBuilder.delete(0, stringBuilder.length() - 1);
    // 输出 [ad, de, ef, fbd, de, ef, fcd, de, ef]
    // delete 是删除不是截取
}
