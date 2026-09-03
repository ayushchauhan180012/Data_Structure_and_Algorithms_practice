class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = capital[i];
            pairs[i][1] = profits[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        while(k-- > 0){
            while(idx < n && pairs[idx][0] <= w){
                pq.add(pairs[idx][1]);
                idx++;
            }
            if (pq.isEmpty()){
                return w;
            }
            w += pq.poll();
        }
        return w;
    }
}