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
import java.util.LinkedList;
import java.util.List;

public class LeetCode46_01_02 {

    List<List<Integer>> ret = new LinkedList<>();
    LinkedList<Integer> tempList = new LinkedList<>();


    public List<List<Integer>> permute(int[] nums) {
        boolean[] numState = new boolean[nums.length];
        backTracking(nums, numState);
        return ret;
    }

    public void backTracking(int[] nums, boolean[] numState) {
        // tempList 和 nums 长度相等表名所有元素都已经添加
        if (tempList.size() == nums.length) {
            ret.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果元素已经被使用过，则直接进入下一轮循环
            if (numState[i]) {
                continue;
            }
            tempList.add(nums[i]);
            numState[i] = true;

            backTracking(nums, numState);

            numState[i] = false;
            tempList.removeLast();
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}


