class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        int n = arr.length - 1;
        int greater = arr[n];
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(greater);
        int i = n - 1;
        while(i >= 0) {
            if(arr[i] >= greater) {
                greater = arr[i];
                stk.push(greater);
            }
            i--;
        }
        ArrayList<Integer> newarr = new ArrayList<Integer>();
        while(!stk.isEmpty()) {
            newarr.add(stk.pop());
        }
        return newarr;
    }
}