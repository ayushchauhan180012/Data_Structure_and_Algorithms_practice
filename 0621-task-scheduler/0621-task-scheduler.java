class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> free = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            free.put(ch, 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        for (char ch : map.keySet()) {
            pq.offer(ch);
        }

        int seat = 1;

        while (!pq.isEmpty()) {

            ArrayList<Character> temp = new ArrayList<>();
            Character task = null;

            while (!pq.isEmpty()) {
                char curr = pq.poll();

                if (free.get(curr) <= seat) {
                    task = curr;
                    break;
                }

                temp.add(curr);
            }

            for (char ch : temp) {
                pq.offer(ch);
            }

            if (task != null) {
                map.put(task, map.get(task) - 1);

                free.put(task, seat + n + 1);

                if (map.get(task) > 0) {
                    pq.offer(task);
                }
            }

            seat++;
        }

        return seat - 1;
    }
}