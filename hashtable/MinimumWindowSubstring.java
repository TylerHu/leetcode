package hashtable;

/**
 * LeetCode76. Minimum Window Substring(https://leetcode.com/problems/minimum-window-substring/description/)
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Solution: Use hashmap to store the characters in the target string. Define two pointers start and end to keep track of
 * the substring. When the end character is in the map, decrease it's value by 1, and when it's value equasl to 0, means character 'end'
 * already match requirement, decrease the counter, and move end pointer forward. When counter is 0, means all the character of string T
 * are in substring (begin, end), now we need to find the minimum window in substring (begin, end). If begin charcter is in
 * the map, increase it's value by 1, if it's value is greater than 0, increase counter. And update the minimum length
 * of the substring, and the head of the substring.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //store how many distinct characters in target string
        int counter = map.size();
        //minimum length of the substring
        int len = Integer.MAX_VALUE;
        //head of the minimum window string
        int head = 0;
        //begin and end pointer of substring
        int begin = 0, end = 0;
        while (end < s.length()) {
            char c0 = s.charAt(end);
            if (map.containsKey(c0)) {
                map.put(c0, map.get(c0) - 1);
                if (map.get(c0) == 0) {
                    counter--;
                }
            }
            //move end pointer forward
            end++;

            while (counter == 0) {
                //substring(start, end) contains all the characters in target string
                //move begin pointer to find the shortest substring
                char c1 = s.charAt(begin);
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) + 1);
                    if (map.get(c1) > 0) {
                        counter++;
                    }
                }

                if (end - begin < len) {
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }
        }
        if (len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(head, head+len);
    }
}