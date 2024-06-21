class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++) {

            for(int j=i+1; j<n; j++) {

                if(nums[i] < nums[j]) {
                    dp[j] = Math.max(dp[j],1 + dp[i]);
                    max = Math.max(max, dp[j]);
                }
            }
        }

      return max;  
    }
}