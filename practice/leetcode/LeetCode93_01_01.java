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

    @Test
    public void test() {
        String s = "101023";
        System.out.println(this.restoreIpAddresses(s));
    }
}
