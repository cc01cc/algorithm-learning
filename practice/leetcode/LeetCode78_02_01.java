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

public class LeetCode78_02_01 {
    public List<List<Integer>> ret = new ArrayList<>();
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 这儿的 i 表示组成单个结果的元素个数
        // 不是表示索引，所以需要在 nums.length 后 +1
        // 从零开始包含空集
        for (int i = 0; i < nums.length + 1; i++) {
            backTracking(nums, 0, i);
        }
        return ret;
    }

    public void backTracking(int[] nums, int startIndex, int k) {
        if (k == 0) {
            ret.add(new ArrayList(tempList));
            return;
        }

        // k - 1 表示除了本层之外（即 - 1）仍需要的元素个数
        // i 至多遍历到 nums.length - (k - 1) 即可，之后的元素留给下一层递归
        for (int i = startIndex; i < nums.length - (k - 1); i++) {
            tempList.add(nums[i]);
            backTracking(nums, i + 1, k - 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
