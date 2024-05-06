class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int index=0, st=0;

        while(st < nums.length) {

            if(nums[st] % 2 == 0) {
                
                int temp = nums[st];
                nums[st] = nums[index];
                nums[index++] = temp;
            }
            st++;
        }
      return nums;  
    }
}