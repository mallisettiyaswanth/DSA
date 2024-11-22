class Solution {
    public int singleNumber(int[] nums) {
        int dif = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dif = dif ^ nums[i];
        }
        return dif;
    }
}