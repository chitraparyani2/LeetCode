class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->
        nums[b] - nums[a]);

        int size = nums.length-k+1;
        int index=0;
        int[] res = new int[size];

        for(int i=0; i<k; i++) {
            pq.add(i);
        }

        res[index++] = nums[pq.peek()];

        for(int i=k; i<nums.length; i++) {
            while(!pq.isEmpty() && i-pq.peek() >= k) {
                pq.poll();
            }
                pq.offer(i);
                res[index++] = nums[pq.peek()];
        }
      return res;  
    }
}