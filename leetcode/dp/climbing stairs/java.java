// recursice
class Solution {
    private int climb(int n) {
        if (n <= 1) return 1;
        return climb(n - 1) + climb(n - 2);
    }
    public int climbStairs(int n) {
        return climb(n);
    }
}

// memoization
class Solution {
    private int climb(int n, int[] vis) {
        if (n <= 1) return 1;
        if(vis[n] != -1) {
            return vis[n];
        }
        vis[n] = climb(n - 1, vis) + climb(n - 2, vis);
        return vis[n];
    }
    public int climbStairs(int n) {
        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);
        return climb(n, vis);
    }
}

// tabular
class Solution {
    public int climbStairs(int n) {
        int[] vis = new int[n + 1];
        vis[0] = 1;
        vis[1] = 1;
        for(int i = 2; i <= n; i++) {
            vis[i] = vis[i - 1] + vis[i - 2];
        }
        return vis[n];
    }
}

// space optimized
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int prev2 = 1;
        int prev = 1;
        int cur = 0;
        for(int i = 2; i <= n; i++) {
            cur = prev2 + prev;
            prev2 = prev;
            prev = cur;
        }
        return cur;
    }
}
