// memoization
class Solution {
    public int rc(int[] nums, int n, int[] dp) {
        if(n == 0) return nums[0];
        if(n == 1) return Math.max(nums[0], nums[1]);
        if(dp[n] != -1) return dp[n];
        int take = nums[n] + rc(nums, n - 2, dp);
        int notTake = rc(nums, n - 1, dp);
        dp[n] = Math.max(take, notTake);
        return dp[n];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] a1 = new int[n - 1];
        int[] a2 = new int[n - 1];
        int j = 0;
        int k = 0;
        for(int i = 0; i < n; i++) {
            if(i != 0) a1[j++] = nums[i];
            if(i != n - 1) a2[k++] = nums[i];
        }
        int[] dp1 = new int[a1.length];
        int[] dp2 = new int[a2.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(rc(a1, a1.length -1, dp1), rc(a2, a2.length - 1, dp2));
    }
}
