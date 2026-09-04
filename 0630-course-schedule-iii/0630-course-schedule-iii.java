class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (a,b) -> Integer.compare(a[1],b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b, a)
        );

        int Tdays = 0;
        for ( int[] arr : courses){
            pq.add(arr[0]);
            Tdays += arr[0];
            if (Tdays > arr[1] ){
                Tdays -= pq.poll();
            }
        }
        return pq.size();
    }
}