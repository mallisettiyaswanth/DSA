// better solution
class Solution {
    public int subarraySum(int[] nums, int k) {
        int arr = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) arr++;
            }
        }

        return arr;
    }
}

// optimal solution
import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        Hashtable<Integer, Integer> hs = new Hashtable<Integer, Integer>();
        hs.put(0, 1);
        int sum = 0;
        int arr = 0;
        for (int num : nums) {
            sum += num;
            if (hs.containsKey(sum - k)) {
                arr += hs.get(sum - k);
            }
            hs.put(sum, hs.getOrDefault(sum, 0) + 1);
        }
        return arr;
    }
}