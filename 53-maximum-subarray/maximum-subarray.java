class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int sum = nums[0];
        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++) {

            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);

            if(dp[i] > sum) {
                sum = dp[i];
            }
        }
       return sum; 
    }
}