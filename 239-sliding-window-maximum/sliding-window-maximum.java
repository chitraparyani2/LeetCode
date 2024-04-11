class Solution {
    /*
1,3,-1,-3,5,3,6,7

 5, 3, 6 -> decreasing montonic queue


        85

 97,85


[1,3,1,2,0,5]

1, 2, 3
3, 1, 2
3, 3

 7
    */
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new LinkedList<>();

        int []result = new int[nums.length - k + 1];

        int j =0;

        for(int i=0; i<nums.length; i++){

            // maintaining the window of size k
            while(!dq.isEmpty() && i - dq.getFirst() >= k){
                dq.removeFirst();
            }

            // maintaining decreasing monotonic queue
            // if larger no is coming I am removing all lesser numbers
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }

            dq.addLast(i);
            if(i >= k -1)
                result[j++] = nums[dq.getFirst()];

        }
        return result;
        
    }
}