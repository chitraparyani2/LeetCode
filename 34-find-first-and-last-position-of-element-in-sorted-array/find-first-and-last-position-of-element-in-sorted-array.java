class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int s=0, e=nums.length-1;
        int n = nums.length-1;

        int l=-1, r=-1;

        while(s <= e) {

            int mid = (s+e)/2;

            if(nums[mid] == target) {

                l=mid;
                r=mid;
                while(l >0 && nums[mid] == nums[l-1]) {
                    l--;
                }

                while(r < n && nums[mid] == nums[r+1]) {
                    r++;
                }
                return new int[]{l,r};
            } else if(nums[mid] > target) {
                e=mid-1;
            } else {
                s=mid+1;
            }

        }

       return new int[]{-1,-1}; 
    }
}