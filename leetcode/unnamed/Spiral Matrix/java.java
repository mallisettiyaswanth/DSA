class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = 0;
        int col = -1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int direction = 1;
        List<Integer> ls = new ArrayList<Integer>();

        while(rows > 0 && cols > 0) {

            for(int i = 0; i < cols; i++) {
                col += direction;
                ls.add(matrix[row][col]);
            }
            rows--;

            for(int i = 0; i < rows; i++) {
                row += direction;
                ls.add(matrix[row][col]);
            }
            cols--;

            direction *= -1;
        }

        return ls;
    }
}