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

    @Test
    public void testSoluction77_01() {
//        int n = 4;
//        int k = 2;
        int n = 1;
        int k = 1;
        System.out.println(new Solution77_01().combine(n, k));
    }
    @Test
    public void testSoluction77_02() {
        int n = 4;
        int k = 2;
//        int n = 1;
//        int k = 1;
        System.out.println(new Solution77_02().combine(n, k));
    }

    @Test
    public void testSoluction39_01() {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        System.out.println(new Solution39_01().combinationSum(candidates, target));
    }

    @Test
    public void testSoluction39_02() {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        System.out.println(new Solution39_02().combinationSum(candidates, target));
    }

    @Test
    public void  testSolution131_01() {
        String s = "aab";
        System.out.println(new Solution131_01().partition(s));
    }

    @Test
    public void testSolution78_01() {
        int[] nums = new int[]{1, 2, 3};

        System.out.println(new Solution78_01().subsets(nums));
    }

    @Test
    public void testLab() {
        System.out.println("abc".substring(0, 3));
    }
}
