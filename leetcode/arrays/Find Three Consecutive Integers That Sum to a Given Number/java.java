class Solution {
    public long[] sumOfThree(long num) {
        long x=num/3;
        long ans[]=new long[3];
        if(num%3!=0)
        {
            return new long[]{};
        }
        ans[0]=x-1;
        ans[1]=x;
        ans[2]=x+1;
        return ans;
    }
}