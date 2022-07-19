import java.util.HashMap;
import java.util.Map;

public class Solution1_01 {
    public int[] twoSum(int[] nums, int target) {
        // 遍历数组，存入 HashMap 数组值为键，索引为值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果 target - nums[i] 在 map 中有值
            // 返回 i 和 map的值
            // 否则 将值和索引添加到map中
            int temp = target - nums[i];

            if (map.containsKey(temp)) return new int[]{map.get(temp), i};

            map.put(nums[i], i);
        }
        return null;
    }
}
