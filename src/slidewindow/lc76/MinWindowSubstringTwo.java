package slidewindow.lc76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouke <zhouke1998301@sjtu.edu.cn>
 * Created on 2022-11-09
 * 引入一个need非负整数变量，用于记录当前还未匹配到的字符个数；need的变化需要借助辅助map，用于记录模式串当前的每个字符个数满足情况；
 * 时间：O(n), 2*n;
 * 空间：O(c), c为模式串的字符种类个数
 */
public class MinWindowSubstringTwo {
    Map<Character, Integer> map;
    public String minWindow(String s, String t) {
        map = new HashMap<>();
        int n = s.length(), m = t.length();
        for (int i = 0; i < m; ++i) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, ansL = -1, ansR = -1;
        int len = n + 1, need = m;
        while (right < n) {
            char c = s.charAt(right);
            if (!map.containsKey(c)) {
                ++right;
                continue;
            }
            if (map.get(c) > 0) {
                need--;
            }
            map.put(c, map.get(c) - 1);

            while (need == 0 && left <= right) {
                if (right - left + 1 < len) {
                    ansL = left;
                    ansR = right;
                    len = right - left + 1;
                }
                if (!map.containsKey(s.charAt(left))) {
                    left++;
                    continue;
                }
                if (map.get(s.charAt(left)) == 0) {
                    need++;
                }
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                left++;
            }
            right++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }
}
