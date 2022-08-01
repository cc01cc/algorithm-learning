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

public class LeetCode78_01_01 {
    public List<Integer> tempList = new ArrayList<>();
    public List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {

            backTracking(nums, 0, i);
        }
        return ret;
    }

    // 添加包含 k 个元素的子集的集合
    public void backTracking(int[] nums, int startIndex, int k) {
        if (k == 0) {
            ret.add(new ArrayList(tempList));
            return;
        }

        for (int i = startIndex; i < nums.length - k + 1; i++) {
            tempList.add(nums[i]);
            backTracking(nums, i + 1, k - 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
