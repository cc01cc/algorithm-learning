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
 *   @Title: BubbleSort.java
 *   @Description: TODO
 *   @author cc01cc
 *   @date 2022-03-15 
 */  

package com.cc01cc.algorithm.collection01sorting;

import java.util.Arrays;

/**
 * @author cc01cc
 * @date 2022-03-15 
 * @Description: TODO
 * 
 */
public class BubbleSort {

    /**
     * @Title: main
     * @Description: TODO
     * @param @param args
     * @return void
     * @throws
     */
    public static void main(String[] args) {
        int testTime = 5000;
        int maxSize = 1000;
        int maxValue = 100;
        boolean succeed = true;
        
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            
            bubbleSort(arr1);
            comparator(arr2);
            
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
            }
            
        }
        System.out.println(succeed ? "Nice" : "Trrible");
    }
    
//    算法实现核心函数
    
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }
    
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    
//    被调用的组件
    
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int [] arr = new int[(int)((maxSize + 1) * Math.random())];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)((maxValue + 1) * Math.random());
        }
        return arr;
    }
    
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }else if (arr1 == null && arr2 ==null) {
            return true;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void swap (int[]arr, int i, int j) {
        if (i == j) {
            return;
        }
        
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
    
    public static void printArray (int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
        
    }
}
