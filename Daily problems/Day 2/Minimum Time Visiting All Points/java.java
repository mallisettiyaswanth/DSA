class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int steps = 0;
        for(int i = 1; i < points.length; i++) {
            int xcor = points[i][0];
            int ycor = points[i][1];
            int xprevcor = points[i - 1][0];
            int yprevcor = points[i - 1][1];
            steps += Math.max(Math.abs(xcor - xprevcor), Math.abs(ycor - yprevcor));
        }
        return steps;
    }
}