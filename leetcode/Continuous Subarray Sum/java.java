import java.util.*;
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Hashtable<Integer, Integer> hs  = new Hashtable<Integer, Integer>();
        hs.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = k == 0 ? sum : sum % k;
            if(hs.containsKey(remainder)) {
                if(i - hs.get(remainder) > 1) {
                    return true;
                } 
            } else {
                hs.put(remainder, i);
            }
        }
        return false;
    }
}