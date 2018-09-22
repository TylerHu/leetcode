package hashtable;

/**
 * LeetCode438. Find All Anagrams in a String(https://leetcode.com/problems/find-all-anagrams-in-a-string/description/)
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 *
 * Solution: The basic idea is the same with LeetCode76, use a hashmap to store all the characters in string p, and use
 * two pointers begin, end to keep track of the substring. If the character at end pointer is contained in string p,
 * decrease counter, if the character at begin pointer is contained in string p, increase counter. If counter is zero,
 * and being-end = p.length,means we find a substring(start, end) that contains all the characters in string p,
 * and that is one of the anagram of string p, so add the begin pointer to the result list.
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            //store all the characters in string p
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int begin = 0, end = 0;
        int counter = map.size();
        while (end < s.length()) {
            char c0 = s.charAt(end);
            if (map.containsKey(c0)) {
                //character at end pointer is also in string p
                map.put(c0, map.get(c0) - 1);
                if (map.get(c0) == 0) {
                    counter--;
                }
            }
            end++;

            while (counter == 0) {
                //all the characters in string p are met
                char c1 = s.charAt(begin);
                if (map.containsKey(c1)) {
                    //character at start pointer is also in string p
                    map.put(c1, map.get(c1) + 1);
                    if (map.get(c1) > 0) {
                        counter++;
                    }
                }
                if (end - begin == p.length()) {
                    //substring(begin, end) is anagram of string p
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }
}