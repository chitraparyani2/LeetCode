class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] subRes = new int[n];
        int res=1;

        Arrays.fill(subRes, 1);

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {

                if(nums[j] > nums[i]) {
                    subRes[j] = Math.max(subRes[j], subRes[i]+1);
                    res = Math.max(res, subRes[j]);
                }
            }
        }

      return res;  
    }
}