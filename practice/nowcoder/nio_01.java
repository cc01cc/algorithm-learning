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

import java.util.Scanner;

public class nio_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long a[] = new Long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        sc.close();
        // 每个数字只能和前一个数字相加
        // 所以加上之后的值与不加的值进行比较即可
        if (n == 1) {
            System.out.println(a[0]);
        }

        // 存储最大值
        Long max = a[0];

        // 不再新建数组（从空间上考虑）
        // 从规范性上应该需要再建一条数组
        for (int i = 1; i < n; i++) {
            a[i] = Math.max(a[i-1]+a[i], a[i]);
            max = Math.max(max, a[i]);
        }
        System.out.println(max);
    }
}
