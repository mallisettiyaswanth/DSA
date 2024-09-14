class Solution {
    private boolean ss(int[] nums, int n, int target, int[][] dp) {
        if(target == 0) return true;
        if(n == 0) return nums[0] == target;
        if(dp[n][target] != -1) return dp[n][target] == 1;
        boolean notTake = ss(nums, n - 1, target, dp);
        boolean take = false;
        if(target >= nums[n]) take = ss(nums, n - 1, target - nums[n], dp);
        dp[n][target] = (take || notTake) ? 1 : 0;
        return dp[n][target] == 1;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int[][] dp = new int[n][(sum / 2) + 1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return ss(nums, n - 1, sum / 2, dp);
    }
}
