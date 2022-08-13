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

public class LeetCode47_01_01 {

    public List<List<Integer>> ret = new LinkedList<>();
    public LinkedList<Integer> tempList = new LinkedList<>();


    public List<List<Integer>> permuteUnique(int[] nums) {
        // 因为 boolean 的默认值是 false，为了保持语义的一致
        // numBeUsed 数组记录指定位置的值是否被使用
        boolean[] numBeUsed = new boolean[nums.length];

        // 对数据进行排序
        // 元素处理时，遇到和后一个元素相同的元素则不处理
        Arrays.sort(nums);
        backTracking(nums, numBeUsed);

        return ret;
    }

    public void backTracking(int[] nums, boolean[] numBeUsed) {
        // 当 tempList 的长度和 nums 长度一致时，说明所有元素已被添加
        if (tempList.size() == nums.length) {
            ret.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 这一层是否使用过相同的值
            // 如何记录这一层使用过的值，不被同层使用
            // 当前值使用后，跳转到与当前值不一致的下一个索引
            // 特殊情况，位于末尾
            // 同时下层需要可以使用相同值但是不同索引的值

            // 添加当前值到 tempList 的情况：
            // 当前值可用，且为第一个值；
            // 当前值可用，且前一个值和当前值不一致；
            // 当前值可用，且前一个值和当前值相同但不可用；

            // 不添加的情况：
            // 当前值不可用(即被使用);
            // 当前值可用，但该层已经使用过相同的值
            // (每次使用后，都跳转到下一个不同的值，所以判断时不需要考虑)


            if (numBeUsed[i] == true) {
                continue;
            }

            tempList.add(nums[i]);
            numBeUsed[i] = true;
            // i 在后续的 while 循环中，值会发生变化
            // 使用 temp 进行记录，以便递归结束时回复索引为 i 的值的状态
            int temp = i;


            // 循环结束后，i 位于和当前值一致的最后一位索引
            // 之后 for 循环 i++ 时，刚好跳到和当前值不一致的第一位索引
            // 同时避免了尾部指针的溢出
            // 假设 i 为 1, nums 为 [1,2,2,2]
            // while 循环结束后，i 为 3
            // 此轮 for 循环结束后，i 为 4，结束遍历
            while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                i++;
            }

            backTracking(nums, numBeUsed);
            tempList.removeLast();
            numBeUsed[temp] = false;
        }
    }

    @Test
    public void test() {
        int[] nums = {1,1,2,2};
        System.out.println(permuteUnique(nums));
    }
}
