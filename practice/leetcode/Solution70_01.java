

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

public class Solution70_01 {
    public static int methodCount = 0;
    public int climbStairs(int n) {
        if (n > 1) {
            climbStairs(n - 2);
            climbStairs(n - 1);
            // methodCount += 2;
        } else {
            methodCount += 1;
        }
        return methodCount;
    }
}
