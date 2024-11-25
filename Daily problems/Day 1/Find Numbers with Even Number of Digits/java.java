class Solution {
    public int countDigits(int digit) {
        int count = 0;
        while(digit > 0)  {
            count++;
            digit /= 10;
        }
        return count;
    }
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num: nums)  {
            if(countDigits(num) % 2 == 0) count++;
        }
        return count;
    }
}