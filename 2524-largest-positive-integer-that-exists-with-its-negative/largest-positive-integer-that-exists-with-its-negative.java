class Solution {
    public int findMaxK(int[] nums) {
        
        Arrays.sort(nums);

        int max = 0;

        int i=0, j=nums.length-1;

        while(i < j) {

            if(nums[i] + nums[j] == 0) {
                max = Math.max(max, Math.abs(nums[i]));
                i++; j--;
            } else if(Math.abs(nums[i]) > Math.abs(nums[j])) {  
                i++;
            } else {
                j--;
            }
        }

      return max == 0 ? -1 : max;  
    }
}