import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Hashtable<Character, Integer> hs = new Hashtable<Character, Integer>();
        int len = s.length();
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < len) {
            char currentChar = s.charAt(i);
            if(hs.containsKey(currentChar)) {
                j = Math.max(hs.get(currentChar) + 1,  j);
            }
            hs.put(currentChar, i);
            max = Math.max(max, i - j + 1);
            i++;
        }
        return max;
    }
}
