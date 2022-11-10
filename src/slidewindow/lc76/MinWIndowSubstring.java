package slidewindow.lc76;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zhouke <zhouke1998301@sjtu.edu.cn>
 * Created on 2022-11-09
 * 滑动窗口：每次移动时都判断是否满足条件；
 * 时间复杂度：O(n * c), c为目标串的字符个数；
 * 空间复杂度: O(c), 来自HashMap；
 */
public class MinWIndowSubstring {
    Map<Character, Integer> map;

    public String minWindow(String s, String t) {
        map = new HashMap<>();
        int n = s.length(), m = t.length();
        for (int i = 0; i < m; ++i) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, ansL = -1, ansR = -1;
        int len = Integer.MAX_VALUE;
        while (right < n) {
            char c = s.charAt(right);
            if (!map.containsKey(c)) {
                ++right;
                continue;
            }

            map.put(c, map.get(c) - 1);
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    ansL = left;
                    ansR = right;
                    len = right - left + 1;
                }
                if (!map.containsKey(s.charAt(left))) {
                    left++;
                    continue;
                }
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                left++;
            }
            right++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    private boolean check() {
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue() > 0) {
                return false;
            }
        }
        return true;
    }


}
