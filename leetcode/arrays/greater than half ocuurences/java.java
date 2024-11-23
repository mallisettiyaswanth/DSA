import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Hashtable<Integer, Integer> hs = new Hashtable<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            hs.put(nums[i], hs.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < nums.length; i++) {
            if(hs.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;

    }
}