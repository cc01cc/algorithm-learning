

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

/**
 * 动态规划
 * 为什么从 3 开始呢，主要是从规律上看，这更容易理解
 * 虽然把 a1 设置成1，可以将 i 初始值提前，但是浅浅任性一下（欸嘿）
 *
 * n    0   1   2   3   4
 * i    0   1   2   3   4
 * res  0   1   2   3   5
 */

public class Solution70_02 {
    public int climbStairs(int n) {
        if (n < 3) return n;

        int a1 = 1;
        int a2 = 2;
        int temp = 0;

        for (int i = 3; i < n; i++) {
            temp = a2;
            a2 = a1 + a2;
            a1 = temp;
        }
        return a1 + a2;
    }
}
