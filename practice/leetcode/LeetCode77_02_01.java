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

/**
 * 使用回溯法
 */

public class LeetCode77_02_01 {

    // 定义返回的结果集
    public List<List<Integer>> ret = new ArrayList<>();
    // 定义每次循环的结果集
    public List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, 0, k);

        return ret;
    }

    /**
     * 使用回溯法，递归获取结果集
     *
     * @param n 范围长度
     * @param startIndex 遍历的起始索引位置
     * @param k 遍历的层级
     */
    public void backTracking(int n, int startIndex, int k) {
        // 定义递归结束的条件
        if (k == 0) {
            // tempList 是引用类型，需要再创建一个新的集合，再赋值
            ret.add(new ArrayList<>(tempList));
            return;
        }
        // n - k + 1当剩余的范围长度小于所需的长度时，停止遍历
        for (int i = startIndex; i < n - k + 1; i++) {
            // 数据进行处理
            tempList.add(i + 1);
            // 进入递归
            backTracking(n, i + 1, k - 1);
            // 从递归中出来时，需要删除在递归中添加的数据
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 1 <= n <= 20
     * 1 <= k <= n
     */
    @Test
    public void test() {
        int n[] = new int[]{4, 1, 20};
        int k[] = new int[]{2, 1, 20};

        for (int i = 0; i < Math.min(n.length, k.length); i++) {
            LeetCode77_02_01 test = new LeetCode77_02_01();
            System.out.println(test.combine(n[i], k[i]));
        }
    }
}
