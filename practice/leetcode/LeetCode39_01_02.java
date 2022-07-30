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

// 相比 01 添加剪枝操作
public class LeetCode39_01_02 {

    public List<Integer> tempList = new ArrayList<>();
    public List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 对数组从小到大排序
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return ret;
    }

    // sum 表示已经累加的总数
    // start 表示开始的位置
    public void backTracking(int[] candidates, int target, int start, int sum) {
        if (sum == target) {
            ret.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length && sum < target; i++) {
            tempList.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, i, sum);
            sum -= candidates[i];
            tempList.remove(tempList.size() - 1);
//            backTracking(candidates, target, start+1, sum);

        }
    }
}
