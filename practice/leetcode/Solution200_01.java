import java.util.*;

public class Solution200_01 {
    public int numIslands(char[][] grid) {
        int res = 0;
        // 遍历每一个格子
        // 遇到 1 进行广度遍历，修改为2
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    changeNum(grid, i, j);
                }
            }
        }
        return res;
        // TODO 通过 0 描线，计算划分的区域？
    }

    public void changeNum(char[][] grid, int col, int row) {
        // 将指定区域的1，更改为2
        grid[col][row] = '2';
        // 定义一个集合，存放需要修改的值
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[]{col, row});

        // 当集合有值时
        while (!list.isEmpty()) {
            int[] temp = list.poll();
            int c = temp[0];
            int r = temp[1];
            // 遍历上下左右；值没有超出边界，值为1时
            if (c > 0 && grid[c - 1][r] == '1') {
                grid[c - 1][r] = '2';
                list.offer(new int[]{c-1, r});
            }
            if (c < grid.length - 1 && grid[c + 1][r] == '1') {
                grid[c + 1][r] = '2';
                list.offer(new int[]{c+1, r});
            }
            if (r > 0 && grid[c][r - 1] == '1') {
                grid[c][r-1] = '2';
                list.offer(new int[]{c, r-1});
            }
            if (r < grid[0].length - 1 && grid[c][r+1] == '1') {
                grid[c][r+1] = '2';
                list.offer(new int[]{c, r+1});
            }
        }
    }
}
