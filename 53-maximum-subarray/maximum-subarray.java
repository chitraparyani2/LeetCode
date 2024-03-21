class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
       // int[] dp = new int[n];
        int sum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<nums.length; i++) {

            maxSum = Math.max(nums[i], nums[i] + maxSum);

            if(maxSum > sum) {
                sum = maxSum;
            }
        }
       return sum; 
    }
}