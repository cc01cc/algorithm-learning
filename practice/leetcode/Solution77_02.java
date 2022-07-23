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
// 相比 01 添加了剪枝的操作
public class Solution77_02 {
    public static List<List<Integer>> ret = new ArrayList<>();
    public static List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        backTracking(0, n, k);
        return ret;
    }

    /**
     * 使用回溯法
     * @param start 此层开始遍历的位置
     * @param n 总个数
     * @param k 仍需要添加的元素个数
     */
    public static void backTracking(int start, int n, int k) {
        if (k == 0) {
            ret.add(new ArrayList<>(tempList));
            return;
        }
        // 添加了剪枝的操作
        for (int i = start; i < n - k + 1; i++) {
            tempList.add(i + 1);
            backTracking(i + 1, n, k - 1);
            tempList.remove(tempList.size()-1);
        }
    }
}
