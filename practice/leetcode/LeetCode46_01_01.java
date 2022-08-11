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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode46_01_01 {

    // 考虑了一下，结果集 ret 临时结果 tempList
    // 几乎只有尾部的增删操作，感觉链表会比较合适
    List<List<Integer>> ret = new LinkedList<>();
    LinkedList<Integer> tempList = new LinkedList<>();
    // numRemain 用于存储当前序列剩余需要处理的元素
    List<Integer> numRemain = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {
        // 参考：int []数组与List互相转换_PitBXu的博客-CSDN博客_int[]转list:
        // <https://blog.csdn.net/PitBXu/article/details/97672145>
        numRemain = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backTracking(numRemain);
        return ret;
    }

    public void backTracking(List<Integer> numRemain) {
        // 当元素清空后，
        // 即所有 numRemain 中的元素都添加到 tempList 中，
        // 添加至结果集 ret
        if (numRemain.isEmpty()) {
            // 后续没有修改的操作了
            // 所以这儿使用 ArrayList
            ret.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < numRemain.size(); i++) {
            int tempNum = numRemain.get(i);
            tempList.add(tempNum);
            numRemain.remove(i);
            backTracking(numRemain);
            // 因为元素是按顺序遍历的，所以插入回去的时候需要确保顺序一致
            // 所以需要指定索引 i
            numRemain.add(i, tempNum);
            tempList.removeLast();
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}


