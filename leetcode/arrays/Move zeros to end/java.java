class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        int j = 0;
        for(int i = 0; i < n; i++) {
            if(temp[i] != 0) 
                nums[j++] = temp[i];
        }
        for(int i = j; i < n; i++) {
            nums[i] = 0; 
        }
    }
}