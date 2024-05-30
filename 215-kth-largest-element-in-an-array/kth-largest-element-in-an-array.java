class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // 5,4,3,2,1 -> 2
        // 1, 2, 3, 4, 5 -> 4
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums) {

            pq.offer(num);

            if(pq.size() > k) {
                pq.poll();
            }

        }

      return pq.peek();  
    }
}