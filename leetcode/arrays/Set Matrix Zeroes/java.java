class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer> col = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i = 0; i < row.size(); i++) {
            int rowNumber = row.get(i);
            for(int j = 0; j < n; j++) {
                matrix[rowNumber][j] = 0;
            }
        }
        for(int i = 0; i < col.size(); i++) {
            int colNumber = col.get(i);
            for(int j = 0; j < m; j++) {
                matrix[j][colNumber] = 0;
            }
        }

    }
}