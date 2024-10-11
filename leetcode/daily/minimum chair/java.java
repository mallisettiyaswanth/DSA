class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        List<int[]> arrivals = new ArrayList<>();
        int i = 0;
        for(int[] time: times) {
            arrivals.add(new int[]{time[0], i});
            i++;
        }
        arrivals.sort((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for(int j = 0; j < n; j++) {
            availableChairs.add(j);
        }
        PriorityQueue<int[]> leavingChairs = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        for(int[] arrival: arrivals) {
            int arrivalTime = arrival[0];
            int index = arrival[1];
            while(!leavingChairs.isEmpty() && leavingChairs.peek()[0] <= arrivalTime) {
                availableChairs.add(leavingChairs.poll()[1]);
            }
            if(index == targetFriend) return availableChairs.poll();
            leavingChairs.add(new int[]{times[index][1], availableChairs.poll()});
        }
        return -1;
    }
}
