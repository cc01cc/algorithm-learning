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
import java.util.List;

public class LeetCode131_02_01 {
    public List<List<String>> ret = new ArrayList<>();
    public List<String> tempList = new ArrayList<>();


    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return ret;
    }

    // 处理每一个结果
    public void backTracking(String s, int startIndex) {
        // 最后一个字串可能不是回文
        if (startIndex == s.length()) {
            ret.add(new ArrayList(tempList));
            return;
        }

        // 用于临时存储每个字串
        StringBuilder stringBuilder = new StringBuilder();
        // 处理每一个字串
        for (int i = startIndex; i < s.length(); i++) {
            // 当不是回文串的时候持续添加，
            // 直到成为回文串，或字符串终止
            stringBuilder.append(s.charAt(i));
            // 如果是回文串，则添加到结果，并递归
            if (checkPalindrome(stringBuilder.toString())) {
                tempList.add(stringBuilder.toString());
                backTracking(s, i + 1);
                tempList.remove(tempList.size() - 1);
            }

        }
    }

    public boolean checkPalindrome(String s) {
        int len = s.length();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "aab";
        System.out.println(this.partition(s));
    }
}
