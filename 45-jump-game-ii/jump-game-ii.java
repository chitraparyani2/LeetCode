class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int[] maxJumps = new int[n];

        Arrays.fill(maxJumps, Integer.MAX_VALUE);

        maxJumps[0] = 0;
        int good = 0;

        for(int i=0; i<n; i++) {

             good = Math.max(good, i+nums[i]);

             for(int j=i+1; j<Math.min(good+1, n); j++) {

                maxJumps[j] = Math.min(maxJumps[j], maxJumps[i]+1);
             }
        }

      return maxJumps[n-1];  
    }
}