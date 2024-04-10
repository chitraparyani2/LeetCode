class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int s=0, e=nums.length-1;

        int se=-1, ee=-1;

        while(s <= e) {

            int mid = (s+e)/2;

            if(nums[mid] == target) {

                se=mid; ee=mid;

                while(se > 0 && nums[se-1] == target) {
                    se--;
                } 

                while(ee < nums.length-1 && nums[ee+1] == target) {
                    ee++;
                }

                return new int[] {se, ee};

            } else if(nums[mid] > target) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }

        return new int[]{se, ee};
    }
}