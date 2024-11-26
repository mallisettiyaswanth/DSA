class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<Integer>();
        int n = nums.length;
        if(n == 0) return 0;
        int maxCount = 1;
        for(int num: nums) {
            hs.add(num);
        }

        for(int num: nums) {
            if(!hs.contains(num - 1)) {
                int temp = num;
                int count = 1;
                while(hs.contains(temp + 1)) {
                    count++;
                    temp = temp + 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}