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
import java.util.Arrays;
import java.util.List;

public class LeetCode40_01_01 {
    public List<List<Integer>> ret = new ArrayList<>();
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return ret;
    }

    public void backTracking(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            ret.add(new ArrayList(tempList));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            tempList.add(candidates[i]);
            // 因为不能重复，所以下一轮就从 i + 1 开始
            backTracking(candidates, target - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1);
            // 因为此层已经使用过 candidates[i] 所以同层，和它相同的数字都跳过
            while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) {
                i++;
            }
        }
    }

    // [[1,2,5],[1,7],[1,6,1],[2,6],[2,1,5],[7,1]]
    // 虽然组合中的数字可以重复
    // 但是结果不能重复
}
