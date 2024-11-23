import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> hs = new Hashtable<Integer, Integer>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            hs.put(nums[i], i);
        }
        int[] ret = new int[2];
        for(int i = 0; i < n; i++) {
            if(hs.containsKey(target - nums[i]) && hs.get(target - nums[i]) != i) {
                ret[0] = hs.get(target - nums[i]);
                ret[1] = i;
            } else {
                hs.remove(nums[i]);
            }
        }
        return ret;
    }
}