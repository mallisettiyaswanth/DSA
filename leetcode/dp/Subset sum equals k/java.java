class Solution{

    private Boolean ss(int[] arr,  int target, int index, int[][] dp) {
        if(target == 0) return true;
        if(index == 0) return arr[0] == target;
        if (dp[index][target] != -1) return dp[index][target] == 1;
        boolean notTake = ss(arr, target, index - 1, dp);
        boolean take = false;
        if(target >= arr[index]) take = ss(arr, target - arr[index], index - 1, dp);
        dp[index][target] = (take || notTake) ? 1 : 0;
        return dp[index][target] == 1;
    }


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp = new int[N][sum+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        Solution sol = new Solution();
        return sol.ss(arr, sum, N - 1, dp);

    }
}
