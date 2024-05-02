class Solution {
    public int[] buildArray(int[] nums) {
        
        int n = nums.length;

        int[] res = new int[n];

        for(int i=0; i<nums.length; i++) {
            
            res[i] = nums[nums[i]];
        }

      return res;  
    }
}