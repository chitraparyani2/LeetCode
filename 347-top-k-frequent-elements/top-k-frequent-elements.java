class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
                new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        System.out.println(Arrays.asList(pq));

        int[] res = new int[k];
        int index=0;

        while(!pq.isEmpty()) {

            if(k > 0) {
                res[index++] = pq.poll().getKey();
                k--;
            } else {
                break;
            }
        }

      return res; 
    }
}