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

import java.util.LinkedList;
import java.util.Queue;

public class Solution209_02 {
    public int minSubArrayLen(int target, int[] nums) {
        // 使用双指针，左闭右闭
        int rightPtr = 0;
        int leftPtr = 0;

        // sum 用于统计两个指针间元素的总值
        int sum = 0;
        int minSize = Integer.MAX_VALUE;

        for (rightPtr = 0; rightPtr < nums.length; rightPtr++) {
            sum += nums[rightPtr];
            while (sum >= target) {
                minSize = Math.min(minSize, rightPtr - leftPtr + 1);
                sum -= nums[leftPtr];
                leftPtr++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
