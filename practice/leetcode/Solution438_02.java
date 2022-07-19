import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution438_02 {
    public List<Integer> findAnagrams(String s, String p) {
        // 定义一个滑动窗口，从左往右滑动
        // 滑动窗口内始终是符合要求的值
        /**
         * 左指针右移：
         * 一、长度超过 p.length
         * 二、右指针遇到异常值
         */
        int left = 0;
        // 右指针也是引导者
        int right = 0;
        List<Integer> res = new ArrayList<>();
        // 定义一个集合（链表），每次找到符合值都会将值抛弃
        List<Character> list = new LinkedList<>();

        for (char c : p.toCharArray()) {
            list.add(c);
        }
        while (right < s.length()) {

            /**
             * 集合填充：
             * 一、左指针右移，添加左指针对应的值
             */
            if (left == right && !list.contains(s.charAt(right))) {
                left++;
                right++;
            } else if (left == right && list.contains(s.charAt(right))) {
                list.remove(Character.valueOf(s.charAt(right)));
                right++;
            } else if (left < right && list.isEmpty()) {
                res.add(left);
                list.add(s.charAt(left));
                left++;
            } else {
                while (left < right && !list.isEmpty() && right < s.length()) {
                    if (list.contains(s.charAt(right))) {
                        list.remove(Character.valueOf(s.charAt(right)));
                        right++;
//                        break;
                    } else {
                        list.add(s.charAt(left));
                        left++;
                    }
                }
            }
        }
        if (list.isEmpty() && left < right) res.add(left);
        return res;
    }
}
