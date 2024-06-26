class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new LinkedList<>();

        int size = nums.length-k+1;
        int index=0;
        int[] res = new int[size];

        for(int i=0; i<nums.length; i++) {
            
            //maintain window size
            while(!dq.isEmpty() && i-dq.peek() >= k) {
                dq.removeFirst();
            }
            // maintain monotonic queue
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            } 
            //maintain result
            dq.offer(i);
            if(i >= k-1) {
                res[index++] = nums[dq.peek()];
            }
        }
      return res;  
    }   
}