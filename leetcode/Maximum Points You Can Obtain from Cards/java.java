class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int tempSum = 0;
        int i = 0;
        while(i < k) tempSum += cardPoints[i++];
        int maxSum = tempSum;
        int j = cardPoints.length - 1;
        while(i > 0) {
            i--;
            tempSum -= cardPoints[i];
            tempSum += cardPoints[j--];
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}