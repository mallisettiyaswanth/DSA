class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}


class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> ar = new ArrayList<Integer>();
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!ar.contains(nums[i])) {
                nums[j] = nums[i];
                ar.add(nums[i]);
                j++;
            }
        }
        return j;
    }
}