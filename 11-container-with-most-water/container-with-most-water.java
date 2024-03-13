class Solution {
    public int maxArea(int[] height) {
        
        int l=0, r=height.length-1, res=0;
        
        while(l < r) {
            
            int hgt = Math.min(height[r], height[l]) * (r-l);
            res = Math.max(res, hgt);
            
            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }   
        }
        
        return res;
    }
}