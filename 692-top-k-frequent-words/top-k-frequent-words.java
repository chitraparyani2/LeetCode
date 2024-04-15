class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> res = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        for(String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b) ->
                    (b.getValue() - a.getValue() == 0) ? a.getKey().compareTo(b.getKey()) :
                    b.getValue() - a.getValue());

        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            pq.offer(entry);
        }
        
        while(!pq.isEmpty()) {
            if(k > 0) {
                res.add(pq.poll().getKey());
                k--;
            } else {
                break;
            }
        }

      return res;
    }
}