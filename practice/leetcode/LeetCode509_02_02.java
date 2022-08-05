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

public class LeetCode509_02_02 {
    public int fib(int n) {

        // 考虑特殊情况
        if (n < 2) {
            return n;
        }

        // 设置初始值
        int dpA = 1;
        int dpB = 1;
        int temp = 0;

        // 从左往右遍历
        for (int i = 2; i < n; i++) {
            // 递推公式
            temp = dpB;
            dpB += dpA;
            dpA = temp;
        }

        return dpB;
    }
}