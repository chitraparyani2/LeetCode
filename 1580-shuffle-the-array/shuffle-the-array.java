class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int len = nums.length;

        int[] res = new int[len];

        int s=0, index=0;

        while(s < n && n < len) {

            res[index++] = nums[s];
            res[index++] = nums[n];

            s++;
            n++;
        }

      return res;  
    }
}