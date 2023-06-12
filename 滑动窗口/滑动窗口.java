package 滑动窗口;

import java.util.*;

public class 滑动窗口 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left = 0, maxLen = 0, i;
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!hs.add(c))
                hs.remove(s.charAt(left++));

            maxLen = Math.max(i - left + 1, maxLen);
        }
        return maxLen;
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();
        for (char c : t.toCharArray()) {
            ht.put(c, ht.getOrDefault(c, 0) + 1);
        }
        String res = "";
        // cnt 指滑动窗口子串中的有效字符数量
        int left = 0, minLen = s.length() + 1, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hs.put(c, hs.getOrDefault(c, 0) + 1);
            // 有效字符加 1
            if (ht.containsKey(c) && ht.get(c) >= hs.get(c))
                cnt++;
            // while (left < i) {
            // char lc = s.charAt(left);
            // if (!ht.containsKey(lc) || hs.get(lc) > ht.get(lc)) {
            // hs.put(lc, hs.get(lc) - 1);
            // left++;
            // } else {
            // break;
            // }
            // }
            // // 收缩左边界
            char lc = s.charAt(left);
            while (left < i && (!ht.containsKey(lc) || hs.get(lc) > ht.get(lc))) {
                hs.put(lc, hs.get(lc) - 1);
                lc = s.charAt(++left);
            }

            if (cnt == t.length()) {
                if (i - left + 1 < minLen) {
                    minLen = i - left + 1;
                    res = s.substring(left, i + 1);
                }
            }
        }
        return res;
    }
}
