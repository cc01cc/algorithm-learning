

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

/**
 * 对比 03 递归，使用了记忆搜索
 * 大幅降低了时间复杂度
 */

public class Solution70_04 {
    // 这儿也可以改为集合
    public static int[] s = new int[100];
    public int climbStairs(int n) {
        if (s[n] != 0) return s[n];
        if (n == 1) return 1;
        if (n == 2) return 2;
        s[n] = climbStairs(n-1) + climbStairs(n-2);
        return s[n];
    }
}
