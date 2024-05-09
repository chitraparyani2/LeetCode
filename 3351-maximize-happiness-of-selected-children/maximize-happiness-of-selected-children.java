class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b-a);

        for(int i=0; i<happiness.length; i++) {
            pq.add(happiness[i]);
        }

        Integer sub =0;
        Long sum = 0L;

        while(!pq.isEmpty()) {

            if(k > 0 && pq.peek() - sub > 0) {
                sum += pq.poll() - sub;
                k--;
                sub++;
            } else {
                break;
            }
        }

      return sum;  
    }
}