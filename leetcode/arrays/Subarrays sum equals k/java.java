class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        hs.put(0, 1);
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            count += hs.getOrDefault(sum - k, 0);
            hs.put(sum, hs.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}