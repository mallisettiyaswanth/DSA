class Solution {
    public int[] replaceElements(int[] arr) {
        int greatestElement = -1;

        for(int i = arr.length - 1; i >= 0; i--) {
            int ele = arr[i];
            arr[i] = greatestElement;
            greatestElement = Math.max(greatestElement, ele);
        }
        return arr;
    }
}