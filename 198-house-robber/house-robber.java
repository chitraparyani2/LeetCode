class Solution {
    public int rob(int[] nums) {
        
        // 2,1,1,2
        int n = nums.length;

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = nums[0];

        for(int i=1; i<n; i++) {

            dp[i+1] = Math.max(nums[i]+dp[i-1], dp[i]);
        }

        return dp[n];
    }
}