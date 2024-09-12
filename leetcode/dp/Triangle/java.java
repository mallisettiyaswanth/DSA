
// memoization
class Solution {
    private int ss(List<List<Integer>> triangle, int i, int j, int m, List<List<Integer>> dp) {
        if(i == m - 1) return triangle.get(i).get(j);
        if(dp.get(i).get(j) != -1) return dp.get(i).get(j);
        int down = triangle.get(i).get(j) + ss(triangle, i + 1, j, m, dp);
        int right = triangle.get(i).get(j) + ss(triangle, i + 1, j + 1, m, dp);
        int result = Math.min(down, right);
        dp.get(i).set(j, result);
        return result;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                row.add(-1);
            }
            dp.add(row);
        }
        return ss(triangle, 0, 0, triangle.size(), dp);
    }
}
