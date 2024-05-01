class Solution {
    public int pivotIndex(int[] nums) {
        
        int n = nums.length;

        int[] lt = new int[n];
        int[] rt = new int[n];

        lt[0] = nums[0];
        rt[n-1] = nums[n-1];

        for(int i=1; i<n; i++) {
            lt[i] = nums[i] + lt[i-1];
        }

        for(int i=n-2; i>=0; i--) {
            rt[i] = nums[i] + rt[i+1];
        }

        for(int i=0; i<n; i++) {
            if(lt[i] == rt[i]) {
                return i;
            }
        }

      return -1;  
    }
}