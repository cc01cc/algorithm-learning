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

public class LeetCode491_01_01 {
    public List<List<Integer>> ret = new ArrayList<>();
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return ret;
    }

    public void backTracking(int[] nums, int startIndex) {
        // 结束条件：
        // 1. startIndex 遍历到最后一个值返回
        // 2. 或者不符合要求返回
        // 这包括在后续的元素处理上，所以就不单独写了

        // 记录这一层使用过的元素
        List<Integer> usedNum = new ArrayList<>();
        for (int i = startIndex; i < nums.length; i++) {

            // 如果该层已经使用过包含相同值的元素，则直接跳过，避免重复
            if (usedNum.contains(nums[i])) {
                continue;
            }

            // 当 tempList 不为空的时候，
            // 若当前 i 所指的数小于 tempList 的最后一个数（即添加后就非递增）
            if (!tempList.isEmpty() && nums[i] < tempList.get(tempList.size() - 1)) {
                // 直接进入下一轮循环
                continue;
            }

            tempList.add(nums[i]);
            usedNum.add(nums[i]);

            if (tempList.size() > 1) {
                ret.add(new ArrayList<>(tempList));
            }

            backTracking(nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }
}
