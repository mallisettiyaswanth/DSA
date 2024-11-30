import java.util.*;
class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        int rem = 0;
        while(rem < n - 1) {
            Arrays.sort(stones);
            stones[n - 1] = Math.abs(stones[n - 1] - stones[n - 2]);
            stones[n - 2] = Integer.MIN_VALUE;
            rem++;
        }
        return stones[n - 1];
    }
}