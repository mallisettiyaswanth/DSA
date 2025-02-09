class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        long sumN = (long) n * (n + 1) / 2;  // Expected sum of first N numbers
        long sumN2 = (long) n * (n + 1) * (2 * n + 1) / 6;  // Expected sum of squares
        
        long actualSum = 0, actualSum2 = 0;
        for (int num : arr) {
            actualSum += num;
            actualSum2 += (long) num * num;
        }
        
        long diff = sumN - actualSum;  // Y - X
        long sumDiff = sumN2 - actualSum2; // Y^2 - X^2
        
        long sumXY = sumDiff / diff;  // (Y + X)
        
        int missing = (int) ((sumXY + diff) / 2);
        int repeating = (int) (missing - diff);
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
        
    }
}