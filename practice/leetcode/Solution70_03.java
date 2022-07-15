

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

/**
 * 对比 01 递归，优化了递归的思路
 * 时间复杂度为 2^n 次（狗头，应该时间复杂度是这个吧，有空好好算算）
 */

public class Solution70_03 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
