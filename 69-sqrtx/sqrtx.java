class Solution {
    /**
        Given -> A number x
        To find -> sqrt(x)
        Base case -> if x is 0, return 0
        Edge case -> In case of max val -> mid == x/mid to avoid overflow
        Soln -> use binary search approach
     */
    public int mySqrt(int x) {
        
        int l=0, r=x;

        if(x == 0) {
            return 0;
        } 

        if(x == 1) {
            return 1;
        }

        while(l <= r) {

            int mid = (l+r)/2;

            if(mid == (x/mid)) {
                return mid;
            } else if(mid > (x/mid)) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
      return r;  
    }
}