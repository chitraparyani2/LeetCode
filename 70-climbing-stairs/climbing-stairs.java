class Solution {
    /**
        Given -> n steps
        To find -> Climb 1 or 2 steps
        Base case -> n == 0 -> 0 || n == 1 -> 1 || n == 2 -> 2
        Edge case -> 
        Soln -> 

     */
    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];

        if(n == 0) {
            return 0;
        }

        dp[0] = 1;
        dp[1] = 2;

        for(int i=2; i<n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

      return dp[n-1];  
    }
}