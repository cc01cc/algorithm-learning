/**
 * 递归
 * haha! StackOverflow Error
 */
public class Solution733_01 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int top = 0;
        int buttom = image.length - 1; // image.length >= 1
        int left = 0;
        int right = image[0].length - 1;

        // 如何保留最初的颜色
        int initialColor = image[sr][sc];
        floodFill(image, sr, sc, color, initialColor);

//        if (sr > top && image[sr - 1][sc] == initialColor) {
//            image[sr - 1][sc] = color;
//            floodFill(image, sr - 1, sc, color, initialColor);
//        }
//        if (sr < buttom && image[sr + 1][sc] == initialColor) {
//            image[sr + 1][sc] = color;
//            floodFill(image, sr + 1, sc, color, initialColor);
//        }
//        if (sc < right && image[sr][sc + 1] == initialColor) {
//            image[sr][sc + 1] = color;
//            floodFill(image, sr, sc + 1, color, initialColor);
//        }
//        if (sc > left && image[sr][sc - 1] == initialColor) {
//            image[sr][sc - 1] = color;
//            floodFill(image, sr, sc - 1, color, initialColor);
//        }

        return image;
    }

//    public traverseRound(int[][] image, )
    public void floodFill(int[][] image, int sr, int sc, int color, int initialColor) {
        int top = 0;
        int buttom = image.length - 1; // image.length >= 1
        int left = 0;
        int right = image[0].length - 1;

        if (sr > top && image[sr - 1][sc] == initialColor) {
            image[sr - 1][sc] = color;
            floodFill(image, sr - 1, sc, color, initialColor);
        }
        if (sr < buttom && image[sr + 1][sc] == initialColor) {
            image[sr + 1][sc] = color;
            floodFill(image, sr + 1, sc, color, initialColor);
        }
        if (sc < right && image[sr][sc + 1] == initialColor) {
            image[sr][sc + 1] = color;
            floodFill(image, sr, sc + 1, color, initialColor);
        }
        if (sc > left && image[sr][sc - 1] == initialColor) {
            image[sr][sc - 1] = color;
            floodFill(image, sr, sc - 1, color, initialColor);
        }
    }
}
