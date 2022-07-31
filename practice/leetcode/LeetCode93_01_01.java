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
        if (k == 1 && startIndex < s.length()) {
            if (s.charAt(startIndex) - '0' == 0 && startIndex < s.length() - 1 ||
                    s.length() - startIndex > 3 ||
                    Integer.valueOf(s.substring(startIndex)) > 255
            ) {
                // 当值以 0 开头多位数或值大于255 直接返回
                return;
            } else {
                stringBuilder.append(s.substring(startIndex));
                ret.add(stringBuilder.toString());
                stringBuilder.delete(stringBuilder.length() - (s.length() - startIndex), stringBuilder.length());
                return;
            }
        } else if (startIndex >= s.length()) {
            return;
        }

        for (int i = 1; i < 4 && i <= s.length() - startIndex; i++) {
            if (s.charAt(startIndex) - '0' == 0) {
                stringBuilder.append("0.");
                backTracking(s, startIndex + 1, k - 1);
                stringBuilder.delete(stringBuilder.length() - i - 1, stringBuilder.length());
//                System.out.println(stringBuilder);
                break;
            } else if (Integer.valueOf(s.substring(startIndex, startIndex + i)) <= 255) {
                stringBuilder.append(s.substring(startIndex, startIndex + i)).append(".");
                backTracking(s, startIndex + i, k - 1);
                stringBuilder.delete(stringBuilder.length() - i - 1, stringBuilder.length());
//                System.out.println(stringBuilder);
            }
        }
    }

    @Test
    public void test() {
        String s = "0279245587303";
        System.out.println(this.restoreIpAddresses(s));
    }
}
