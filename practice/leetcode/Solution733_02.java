import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先
 */

public class Solution733_02 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originColor = image[sr][sc];

        // 定义顺时针上下左右
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();

        // 临时记录需要存放到队列中的值，记录位置
        int[] temp = new int[2];
        do{
//            temp[0] = sr;
//            temp[1] = sc;
//            queue.offer(temp);

            for (int i = 0; i < 4; i++) {
                // sr 为行，sc 为列
                temp[0] = sr + dy[i];
                temp[1] = sc + dx[i];
                if (temp[0] < 0 || temp[0] >= image.length || temp[1] < 0 || temp[1] >= image[0].length) continue;
                if (image[temp[0]][temp[1]] == originColor) {
                    image[temp[0]][temp[1]] = color;
                    queue.offer(temp);
                }
            }
            // 这儿 temp 临时存储下一个需要遍历的节点
            // temp 一个变量多用，设计上不太合适，但这儿也就不细究吧
            queue.poll();
            if (queue.isEmpty()) break;
            temp = queue.peek();
            sr = temp[0];
            sc = temp[1];
        } while (!queue.isEmpty());


        return image;

    }
}
