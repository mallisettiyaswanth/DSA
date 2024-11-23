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

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int ele = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                ele = nums[i];
            }
            if(ele == nums[i]) count++;
            else count--;
        }
        return ele;
    }
}