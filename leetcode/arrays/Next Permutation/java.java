class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            swapIndex(nums, 0, n - 1);
            return;
        }
        for(int i = n - 1; i >= index; i--) {
            if(nums[i] > nums[index]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }  
        int peak = index + 1;
        int last = n - 1;
        swapIndex(nums, peak, last);
    }

    private void swapIndex(int[] nums, int peak, int last) {
        while(peak < last) {
            int temp = nums[peak];
            nums[peak] = nums[last];
            nums[last] = temp;
            peak++;
            last--;
        }
    }
}