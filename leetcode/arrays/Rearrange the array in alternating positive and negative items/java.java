class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int posInd = 0;
        int negInd = 0;
        for(int num: nums) {
            if(num > 0) pos[posInd++] = num;
            else neg[negInd++] = num;
        }

        int[] ret = new int[nums.length];
        int k = 0;
        for(int i = 0; i < nums.length; i+=2) {
            ret[i] = pos[k];
            ret[i+1] = neg[k++];
        }
        System.out.println(Arrays.toString(ret));
        return ret;
    }
}