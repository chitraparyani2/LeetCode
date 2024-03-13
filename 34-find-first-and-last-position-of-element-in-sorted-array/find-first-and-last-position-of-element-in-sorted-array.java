class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int l=0, r=nums.length-1;

        int s=-1, e=-1;

        while(l <= r) {

            int mid = (l+r)/2;

            if(nums[mid] == target) {

                 s=mid; e=mid;

                while(s > 0 && target == nums[s-1]) {
                    s--;
                }

                while(e < nums.length-1 && target == nums[e+1]) {
                    e++;
                }

                return new int[]{s,e};

            } else if(nums[mid] < target) {
                l=mid+1;
            } else {
                r=mid-1;
            }
        }
        return new int[]{s,e};
    }
}