class Solution {
    public int majorityElement(int[] nums) {
        
        int count=1;
        int maj = nums[0];

        int st = 1;

        while(st < nums.length) {

            if(count == 0) {
                maj = nums[st];
                count = 1;
            } else if(nums[st] != maj) {
                count--;
            } else if(nums[st] == maj) {
                count++;
            }
            st++;
        }
      return maj;  
    }
}