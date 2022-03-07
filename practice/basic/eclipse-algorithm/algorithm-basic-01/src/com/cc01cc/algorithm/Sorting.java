/**  
 *   Copyright 2022 cc01cc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

/**
*   @Title: Sorting.java
*   @Description: TODO
*   @author cc01cc
*   @date 2022-02-24 
*/

package com.cc01cc.algorithm;

import java.util.Arrays;

/**
 * @author cc01cc
 * @date 2022-02-24
 * @Description: TODO
 * 
 */
public class Sorting {

    /**
     * @Title: main
     * @Description: TODO
     * @param @param args
     * @return void
     * @throws
     */
    public static void main(String[] args) {
        int numOfRepeated = 500;
        int maxSize = 1000;
        int maxValue = 200;
        boolean isCorrect = true;
        for (int i = 0; i < numOfRepeated; i++) {
            int[] arrayCompared = generateRandomArray(maxSize, maxValue);
            int[] arrayBySelection = copyArray(arrayCompared);

//            TODO: 函数的命名使用动词or名词or形容词
            arrayCompared = comparation(arrayCompared);
            arrayBySelection = selectionSort(arrayBySelection);

            if (!arrayCompared.isEqual(arrayBySelection)) {
                isCorrect = false;
                break;
            }
        }

        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("False!");
        }
    }

    /**
     * @Description: 生成随机数组
     * @Param maxSize: 指定随机数组的最大长度
     * @Param maxValue: 指定随机数组中的最大值
     * @Returen: 随机数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
//        生成随机长度
        int[] array = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < array.length; i++) {
//            生成随机正负值
//            TODO: 正数和负数的取值是否分布均匀？
            array[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return array;
    }

    /**
     * @Description: 复制数组的值，生成含有相同值的数组
     * @Param array: 需要被复制到数组
     * @Return: 生成的含有相同值的数组
     */
    public static int[] copyArray(int[] array) {
        int[] newArray = new int[array.length];
//        验证数组不为空
        if(array == null) return null;
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * @Title: comparation
     * @Description: 排序的对照组方法，调用系统排序
     */
}
