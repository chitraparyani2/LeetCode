class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int i=0, j=0, n=nums.length, res=0, count=0;

        while(j < n) {

            if(nums[j] == 1) {
                count++;
                j++;
            } else if(nums[j] == 0 && k > 0) {
                k--;
                count++;
                j++;
            } else {

                if(nums[i] == 0) {
                    k++;
                }
                count--;
                i++;
            }

            res = Math.max(res, count);
        }
      return res;  
    }
}