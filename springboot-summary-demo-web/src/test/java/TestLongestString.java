import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 有一个字符串，找到这个字符串中不重复的最长子串
 * "abcabcbb"
 * "bbb"
 *
 * @author cheng.wang
 * @version Date：2026/6/4
 */
public class TestLongestString {

    public static int longestString(String s) {

        if (StringUtils.isEmpty(s)) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int maxLength = 0;

        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);

            // 当字符在set中，移动left，并且从set中移除左边界的字符
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // 当前字符加入到set中
            set.add(c);

            // 最大长度
            maxLength = Math.max(maxLength, right - left + 1);

            // 右指针右移
            right++;
        }

        return maxLength;
    }


}
