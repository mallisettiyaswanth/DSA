class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0 
        for i in range(32):
            temp = n & 1
            res = (res << 1) | temp
            n = n >> 1
        return res