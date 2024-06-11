class Solution {
    public int pivotIndex(int[] nums) {
        
        int ls=0, rs=0, res=0;

        for(int num : nums) {
            rs += num;
        }

        for(int i=0; i<nums.length; i++) {

            rs-= nums[i];
            if(rs == ls) return i;
            ls += nums[i];
        }
       return -1; 
    }
}