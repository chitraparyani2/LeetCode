class Solution {
    public int longestSubarray(int[] nums) {
        
        int i=0, j=0, k=1, count=0, res=0;

        while(j < nums.length) {

            if(nums[j] == 0) {
                k--;
            }
            j++;
            while(k < 0) {
                if(nums[i] == 0) 
                    k++;
                i++;
            }

            res = Math.max(res, j-i-1);
        }

      return res;  
    }
}