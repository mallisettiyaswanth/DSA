class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int m = a.length;
        int n = b.length;
        while(i < m && j < n) {
            if(a[i] < b[j]) {
                if(arr.isEmpty() || arr.get(arr.size() - 1) != a[i]) arr.add(a[i]);
                i++;
            } else {
                if(arr.isEmpty() || arr.get(arr.size() - 1) != b[j]) arr.add(b[j]);
                j++;
                
            }
        }
        while(i < m) {
            if(arr.get(arr.size() - 1) != a[i]) arr.add(a[i]);
            i++;
        }
        while(j < n) {
            if(arr.get(arr.size() - 1) != b[j]) arr.add(b[j]);
            j++;
        }
        
        return arr;
    }
}