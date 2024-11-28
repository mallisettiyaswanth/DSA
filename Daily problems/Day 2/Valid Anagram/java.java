import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            if (!charCount.containsKey(ch)) {
                return false; 
            }
            charCount.put(ch, charCount.get(ch) - 1);
            if (charCount.get(ch) == 0) {
                charCount.remove(ch); 
            }
        }
        return charCount.isEmpty();
    }
}