class Solution {

    /**
        [1, 1, 2, 6]

        [24,12,4, 1]

        [1, 2, 3, 4]

        [24, 12, 8, 6]
       
     */

    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;

        int[] l = new int[n];
       // int[] r = new int[n];

        int right = 1;
        int[] res = new int[n];

        l[0] = 1;
       // r[n-1] = 1;

        for(int i=1; i<n; i++) {
            
            l[i] = nums[i-1] * l[i-1];
        }

        // for(int i=n-2; i>=0; i--) {
        //     r[i] = nums[i+1] * r[i+1];
        // }

        for(int i=n-2; i>=0; i--) {
           // res[i] = l[i] * r[i];
           right = right * nums[i+1];
           l[i] = l[i] * right;
        }

      return l;  
    }
}