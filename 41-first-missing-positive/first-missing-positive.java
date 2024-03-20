class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int i=0, n=nums.length, ans=1;

        while(i < n) {

            if(nums[i] == i+1) {
                i++;
            } else if(nums[i] <= 0 || nums[i] > n) {
                i++;
            } else if(nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }   
        }

        for(int j=0; j<n; j++) {
            if(nums[j] == j+1) {
                ans++;
            } else {
                break;
            }
        }

      return ans;  
    }

    public void swap(int[] nums, int s, int e) {

        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp; 
    }
}