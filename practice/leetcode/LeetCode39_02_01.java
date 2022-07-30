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

public class LeetCode39_02_01 {
    // 定义返回的结果集
    public List<List<Integer>> ret = new ArrayList<>();
    // 临时存储单个结果（即组合）
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 对数组进行排序方便后续的剪枝操作
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return ret;
    }

    /**
     * 回溯递归函数
     * @param candidates 提供数字的数组
     * @param target 当前递归剩余需要的目标整数
     * @param startIndex 当前递归开始遍历的索引位置
     */
    public void backTracking(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            ret.add(new ArrayList(tempList));
            return;
        } else if (target < 0 || startIndex == candidates.length) {
            return;
        }

        // candidates[i] <= target 剪枝操作，由于之前进行了排序，所以当值大于 target 时
        // 后续的元素就不需要遍历了
        for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            tempList.add(candidates[i]);
            // startIndex 取 i 表示可以重复取当前的值，以及之后的值
            backTracking(candidates, target - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
