import java.util.Arrays;
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        int j = 0;
        for(int i = n - k; i < n; i++) {
            nums[j++] = temp[i];
        }
        for(int i = 0; i < n - k; i++) {
            nums[j++] = temp[i];
        }
    }
}