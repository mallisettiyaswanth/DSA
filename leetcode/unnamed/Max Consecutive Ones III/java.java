class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        int max = 0;
        int zeros = 0;
        while(i < len) {
            if(nums[i] == 0) zeros++;
            while(zeros > k) {
                if(nums[j] == 0) zeros--;
                j++;
            }
            if(zeros <= k) max = Math.max(max, i - j + 1);
            i++;
        }

        return max;
    }
}