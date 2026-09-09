class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        if (target <= startFuel) return 0;

        if (stations.length == 0) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int fuel = startFuel;
        int stops = 0; 
        int i = 0;

        while (fuel < target){

            while(i<stations.length && fuel >= stations[i][0] ){
                pq.add(stations[i][1]);
                i++;
            }
            if (pq.isEmpty()) return -1;

            fuel += pq.poll();
            stops++;
        }
        return stops;
    }
}