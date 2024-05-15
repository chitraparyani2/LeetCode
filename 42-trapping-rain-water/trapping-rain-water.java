class Solution {
    public int trap(int[] height) {
        
        int left=0, right=height.length-1, n=height.length;

        int leftMax=height[0], rightMax=height[n-1], ans=0;

        while(left <= right) {

            if(leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
                right--;
            }
          
        }
      return ans;  
    }
}