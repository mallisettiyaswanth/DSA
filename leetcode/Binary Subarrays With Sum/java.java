class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return getSum(nums, goal) - getSum(nums, goal - 1);        
    }

    public int getSum(int[] nums, int goal) {
        int l = 0;
        int r = 0;
        int len = nums.length;
        int sum = 0;
        int count = 0;
        if(goal < 0) return 0;
        while(l < len) {
            sum += nums[l];
            while(sum > goal) {
                sum -= nums[r];
                r++;
            }
            count += l - r + 1;
            l++;
        }
        return count;
    }
}