import org.junit.Test;

import java.util.Arrays;

public class TestLab {

    @Test
    public void testSolution70_01(){
        Solution70_01 solution70_01 = new Solution70_01();
        System.out.println(solution70_01.climbStairs(45));
    }

    @Test
    public void testSolution733_01() {
        int[][] image = {{0, 0, 0},{0, 0, 0}};
        int sr = 0, sc = 0, newColor = 2;
        // public int[][] floodFill(int[][] image, int sr, int sc, int color)
        int[][] res = new Solution733_01().floodFill(image, sr, sc, newColor);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
    @Test
    public void testSolution733_02() {
        int[][] image = {{0, 0, 0},{0, 0, 0}};
        int sr = 0, sc = 0, newColor = 2;
        // public int[][] floodFill(int[][] image, int sr, int sc, int color)
        int[][] res = new Solution733_02().floodFill(image, sr, sc, newColor);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
