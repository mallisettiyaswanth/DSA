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