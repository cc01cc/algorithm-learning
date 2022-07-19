import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testSolution62_01() {
        int res = new Solution62_01().uniquePaths(7, 3);
        System.out.println(res);
    }
    @Test
    public void testSolution438_01() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = new Solution438_01().findAnagrams(s, p);
        System.out.println(res);
    }
    @Test
    public void testSolution438_02() {
//        String s = "cbaebabacd";
//        String p = "abc";
        String s = "abab";
        String p = "ab";
        List<Integer> res = new Solution438_02().findAnagrams(s, p);
        System.out.println(res);
    }

    @Test
    public void testSolution200_01() {
        char[][] c = new char[][]{{'1','1','1'},{'0','1','0'},{'0','1','0'}};
        int res = new Solution200_01().numIslands(c);
        System.out.println(res);
    }
}
