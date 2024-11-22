
class Solution {
    public int getSecondLargest(int[] arr) {
    int firstLargest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    
    for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < firstLargest) {
                secondLargest = arr[i];
            }
        }
    return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}