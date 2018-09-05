package string;

/**
 * LeetCode49. Group Anagrams(https://leetcode.com/problems/group-anagrams/description/)
 *
 * Given an array of strings, group anagrams together.
 *
 * Solution: Use hashmap to store each string's anagrams, use sorted string as key, and it's anagrams list as values.
 * At the end use map.values() to build a new array list and return it.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            //sort the character array as key in the map
            Arrays.sort(cs);
            String key = new String(cs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            //store the anagram list in the map
            map.get(key).add(str);
        }
        //use map's values to build a new array list
        return new ArrayList<>(map.values());
    }
}