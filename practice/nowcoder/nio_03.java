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

public class nio_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int[n][m];
        int sum[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        // 初始化左上角
        sum[0][0] = a[0][0];
        // 初始化首列
        for (int i = 1; i < n; i++) {
            sum[i][0] = sum[i-1][0] + a[i][0];
        }
        // 初始化首行
        for (int i = 1; i < m; i++) {
            sum[0][i] = sum[0][i-1] + a[0][i];
        }

        // 从左往右，从上往下遍历
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] = a[i][j] + Math.min(sum[i-1][j], sum[i][j-1]);
            }
        }

        System.out.println(sum[n-1][m-1]);
    }
}
