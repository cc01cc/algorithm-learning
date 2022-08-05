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

public class LeetCode509_02_01 {
    public int fib(int n) {
        // 定义 dp[] 数组; dp[i]: 存放第 i 位的斐波那契数
        int[] dp = new int[n];

        // 考虑特殊情况
        if (n < 2) {
            return n;
        }

        // 设置初始值
        dp[0] = 1;
        dp[1] = 1;

        // 从左往右遍历
        for (int i = 2; i < n; i++) {
            // 递推公式
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
