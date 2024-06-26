class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;

        int[] left = new int[n];
        //int[] right = new int[n];
       // int[] res = new int[n];
        
        left[0] = 1;
       // right[n-1] = 1;

       int right = 1;

        for(int i=1; i<n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        for(int j=n-2; j>=0; j--) {
            right = right * nums[j+1];
            left[j] = left[j] * right;
        }

    

      return left;  
    }
}