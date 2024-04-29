class Solution {
    public void moveZeroes(int[] nums) {
        
        int st=0, ed=0;

        while(ed < nums.length) {

            if(nums[ed] != 0) {
                int temp = nums[st];
                nums[st] = nums[ed];
                nums[ed] = temp;
                st++;
            }
            ed++;
        }  
    }
}