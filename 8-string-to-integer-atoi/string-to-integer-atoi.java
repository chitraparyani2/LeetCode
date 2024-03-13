class Solution {
    public int myAtoi(String s) {
        
        int i=0, n=s.length();
        boolean flag = false;
        StringBuilder res = new StringBuilder();
        double d = 0;
        
        
        while(i<n && s.charAt(i) == ' ') {
                i++;
            }
        
        if(i < n && s.charAt(i) == '+') {
            i++;
        } else if(i < n && s.charAt(i) == '-') {
            flag=true;
            i++;
        }
        
        while(i < n) {
            
            if(Character.isDigit(s.charAt(i))) {
                res.append(s.charAt(i));
                i++;
            } else {
                break;
            }
        }
        
        if(res.length() != 0)
             d = Double.valueOf(res.toString());
        
         
        if(flag) {
            d = -1 * d;
        }
        
        if(d > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(d < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
       
        return (int) d;
    }
}