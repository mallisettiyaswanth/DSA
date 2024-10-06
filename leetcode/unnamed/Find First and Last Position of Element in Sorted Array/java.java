class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = binarySearch(nums, target, true);
        ret[1] = binarySearch(nums, target, false);
        Arrays.sort(ret);
        return ret;
    }

    public int binarySearch(int[] nums, int target, boolean leftOne) {
        int l = 0, r = nums.length - 1;
        int ind = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > target) r = mid - 1;
            else if(nums[mid] < target) l = mid + 1;
            else {
                ind = mid;
                if(leftOne) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return ind;
    }