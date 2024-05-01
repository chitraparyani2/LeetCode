class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {

            int ele = nums[i];

            while(ele <= nums.length && nums[ele-1] != ele) {
                int temp = nums[ele-1];
                nums[ele-1] = ele;
                ele = temp;
            }
        }

        for(int i=0; i<nums.length; i++) {

            if(nums[i] != i+1) {
                res.add(i+1);
            }
        }

      return res;  
    }
}