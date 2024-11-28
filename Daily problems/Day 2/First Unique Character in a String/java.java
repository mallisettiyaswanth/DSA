class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        for(char ch: s.toCharArray()) {
            hs.put(ch, hs.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            if(hs.get(s.charAt(i)) == 1) return i;
        }
        return -1;
        
    }
}