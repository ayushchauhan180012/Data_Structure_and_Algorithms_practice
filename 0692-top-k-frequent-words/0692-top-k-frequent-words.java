class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap <String, Integer> map = new HashMap<>();

        PriorityQueue<String> pq = new PriorityQueue<>(
            (a,b) -> {
                if (map.get(a).equals(map.get(b))) {
                    return b.compareTo(a);
                }       
                return map.get(a) - map.get(b);
            }
        );
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);

        }
        for (String n:map.keySet()){
            pq.add(n);

            if (pq.size() > k){
                pq.poll();
            }
        }

        String[] ans = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll();
        }

        return Arrays.asList(ans);
    }
}