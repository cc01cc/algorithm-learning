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

public class Solution209_01 {
    public int minSubArrayLen(int target, int[] nums) {
        // 定义一个队列

        Queue<Integer> queue = new LinkedList<Integer>();

        // sum 用于统计当前队列的总值
        int sum = 0;
        int minSize = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            sum += nums[i];
            while (sum >= target) {
                if (minSize > queue.size()) {
                    minSize = queue.size();
                }
                sum -= queue.poll();
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
