class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        rem = 0
        n = len(stones)

        while rem < n - 1:
            stones.sort();
            stones[-1] = abs(stones[-1] - stones[-2])
            stones[-2] = float('-inf')
            rem = rem + 1
        return stones[-1]
        