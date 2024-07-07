class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;

        double[] max = new double[n];
        double[] min = new double[n];
        

        max[0] = nums[0];
        min[0] = nums[0];

        double res = Math.max(max[0], min[0]);

        for(int i=1; i<n; i++) {

            max[i] = Math.max(nums[i], Math.max(nums[i] * max[i-1], nums[i] * min[i-1]));
            min[i] = Math.min(nums[i], Math.min(nums[i] * max[i-1], nums[i] * min[i-1]));
            
            res =  Math.max(res, Math.max(max[i], min[i]));
        }

      return (int)res;  
    }
}