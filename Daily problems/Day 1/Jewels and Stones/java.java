import java.util.*;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Hashtable<Character, Integer> hs = new Hashtable<Character, Integer>();
        for(char stone: stones.toCharArray()) {
            hs.put(stone, hs.getOrDefault(stone, 0) + 1);
        }
        System.out.println(hs);
        int count = 0;
        for(char jewel: jewels.toCharArray()) {
            if(hs.containsKey(jewel)) count += hs.get(jewel);
        }
        return count;
    }
}