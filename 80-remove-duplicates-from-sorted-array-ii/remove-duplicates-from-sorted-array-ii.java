class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i=0, j=1, count=1;

        while(j < nums.length) {

            if(nums[i] == nums[j]) {

                count++;

                if(count <= 2) {

                    nums[++i] = nums[j];
                }

            } else {

                nums[++i] = nums[j];
                count=1;
            }

            j++;
        }
      return i+1;  
    }
}