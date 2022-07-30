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
