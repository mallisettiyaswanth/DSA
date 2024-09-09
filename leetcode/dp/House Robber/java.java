// recursion
class Solution {
    private int rec(int[] nums , int n) {
        if(n == 0) return nums[n];
        if(n == 1) return Math.max(nums[0], nums[1]);
        int pick = nums[n] + rec(nums, n - 2);
        int notPick = rec(nums, n - 1);
        return Math.max(pick, notPick);;
    }
    public int rob(int[] nums) {
        return rec(nums, nums.length - 1);
    }
}

// memoization
class Solution {
    private int rec(int[] nums , int n, int[] dp) {
        if(n == 0) return nums[n];
        if(n == 1) return Math.max(nums[0], nums[1]);
        if(dp[n] != -1) return dp[n];
        int pick = nums[n] + rec(nums, n - 2, dp);
        int notPick = rec(nums, n - 1, dp);
        dp[n] = Math.max(pick, notPick);
        return dp[n];
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rec(nums, nums.length - 1, dp);
    }
}

// tabulation
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            int take = nums[i] + dp[i - 2];
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[nums.length - 1];
    }
}

// space optimized
class Solution {
    public  int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int prev = Math.max(nums[0], nums[1]);
        int prev2 = nums[0];
        int cur = 0;
        for(int i = 2; i < nums.length; i++) {
            int take = nums[i] + prev2;
            int notTake = prev;
            cur = Math.max(take, notTake);
            prev2 = prev;
            prev = cur;
        }
        return cur;
    }
}
