class Solution {
    public int nthUglyNumber(int n) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        pq.add(1L);
        set.add(1L);

        int ans = 1;

        for (int i = 0; i < n; i++) {

            long curr = pq.poll();
            ans = (int) curr;

            long a = curr * 2;
            long b = curr * 3;
            long c = curr * 5;

            if (set.add(a)) pq.add(a);
            if (set.add(b)) pq.add(b);
            if (set.add(c)) pq.add(c);
        }

        return ans;
    }
}