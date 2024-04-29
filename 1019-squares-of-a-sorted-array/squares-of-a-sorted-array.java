class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int st=0;
        int ed = nums.length-1;
        int index=nums.length-1;
        int[] res = new int[index+1];

        while(st <= ed) {

            if(Math.abs(nums[st]) >= Math.abs(nums[ed])) {

                res[index] = nums[st] * nums[st];
                st++;
            } else {
                res[index] = nums[ed] * nums[ed];
                ed--;
            }
            index--;
        }

      return res;  
    }
}