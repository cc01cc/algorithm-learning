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

public class LeetCode216_01_01 {
    // 定义结果集
    public List<List<Integer>> ret = new ArrayList<>();
    // 定义临时集合，存放每个组合
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1);
        return ret;
    }

    /**
     *
     * @param n 表示剩余需要的和
     * @param k 表示剩余可以添加的个数
     * @param startNum 表示起始的数字（因为数字不能重复）
     */
    public void backTracking(int n, int k, int startNum) {
        // 定义递归结束条件
        if (k == 0) {
            if (n == 0) ret.add(new ArrayList(tempList));
            return;
        } else if (n > k * 9) {
            // 当剩余数字全部取最大值 9 时都无法满足，则结束递归
            return;
        } else if (n < 0) {
            // 当n已经小于0时，结束递归
            return;
        }

        for (int i = startNum; i < 10; i++) {
            tempList.add(i);
            backTracking(n - i, k - 1, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
