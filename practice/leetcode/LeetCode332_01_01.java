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

public class LeetCode332_01_01 {

    public List<String> ret = new ArrayList<>();

    // 使用过的行程需要排除
    public List<String> findItinerary(List<List<String>> tickets) {
        boolean[] ticketBeUsed = new boolean[tickets.size()];
        return null;
    }

    //    // from 表示启程的位置
//    public void backTracking(List<List<String>> tickets, boolean[] ticketBeUsed, String from) {
//        if (ret.size() == tickets.size()) {
//            return;
//        }
//
//        for (int i = 0; i < tickets.size(); i++) {
//            tickets.get(i).get(0).equals(from);
//        }
//    }    
    // from 表示启程的位置
    // minTo 表示目的地的字典排序必须大于 minTo
    // 用过的票直接舍弃，ticketBeUsed 每次循环都需要全部遍历，太慢了
    public void backTracking(List<List<String>> tickets, String from, String minTo) {
        if (ret.size() == tickets.size()) {
            return;
        }

        // 记录索引
        int tempIndex = 0;
        // 记录目的地
        String tempTo = null;
        // 确定符合 from 需求，并且字典排序最小的值
        for (int i = 0; i < tickets.size(); i++) {
            String to = null;
            if (tickets.get(i).get(0).equals(from)) {
                tempTo = tickets.get(i).get(1);
                // 第一个出现，或者字典排序小则设置为目的地，并记录索引号
                if (to == null || to.compareTo(tempTo) > 0) {
                    to = tempTo;
                    tempIndex = i;
                }
            }


        }
        // 如果无法组成路径
        if (tempTo == null) {
            return;
        }

            // 是否存在一种，不是字典排序最小，但是唯一可行的路线
//            backTracking();
    }

}
