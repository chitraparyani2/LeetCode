class Solution {
    public int reverse(int x) {
        
        int rev=0, rem=0, prev=0;
        
        while(x != 0) {
            
            rem = x%10;
            rev = rev*10+rem;
            
            if((rev-rem)/10 != prev) {
                return 0;
            }
            
            prev=rev;
            x = x/10;
        }
       return rev; 
    }
}