class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>((a,b) -> score[b] - score[a]);

        for(int i=0; i<score.length; i++) {
            pq.add(i);
        }

        String[] res = new String[score.length];
        
        if(!pq.isEmpty()) {
            res[pq.poll()] = "Gold Medal";
        }
        if(!pq.isEmpty()) {
            res[pq.poll()] = "Silver Medal";
        }
        if(!pq.isEmpty()) {
            res[pq.poll()] = "Bronze Medal";
        }

        int place=4;

        while(!pq.isEmpty()) {
            res[pq.poll()] = place + "";
            place++;
        }

      return res;  
    }
}