/**
    1   0   2
    1   0   0
    1   2   2
 */
class Solution {
    public int trap(int[] height) {
        
        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        right[n-1] = height[n-1];

        for(int i=1; i<n; i++) {
            left[i] = Math.max(height[i], left[i-1]);
        }

        for(int j=n-2; j>=0; j--) {
            right[j] = Math.max(height[j], right[j+1]);
        }

        int ans = 0;

        for(int k=0; k<n; k++) {
            ans += (Math.min(left[k], right[k]) - height[k]);
        }

       return ans; 
    }
}