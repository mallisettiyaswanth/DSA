class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if len(nums) == 0:
            return []
        l = []
        ret = []
        l.append(nums[0])
        for i in range(1, len(nums)):
            if l[-1] + 1 != nums[i]:
                if len(l) == 1:
                    ret.append(f"{l[0]}")
                else:
                    ret.append(f"{l[0]}->{l[-1]}")
                l = [nums[i]]
            else:
                l.append(nums[i])
        if len(l) == 1:
            ret.append(f"{l[0]}")
        else:
            ret.append(f"{l[0]}->{l[-1]}")
        return ret
                