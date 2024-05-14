
/**
    1. s1.length == 0 && s2 == length -> return true
    2. int m = s1.length-1; n = s2.length-1, p = s3.length-1;
    3. if(s1.charAt(m) == s3.charAt(p)) ->
        helper(m-1, n, p-1)
        if(s2.charAT(n) == s3.charAt(p)) { helper(m, n-1, p-1)}
    4. return false
    5. TC - n^n
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return helper(s1, s2, s3, s1.length()-1, s2.length()-1, s3.length()-1);
    }

    public boolean helper(String s1, String s2, String s3, int m, int n, int p) {

        if(m < 0 && n < 0 && p < 0) {
            return true;
        }

        if(m >=0  && s1.charAt(m) == s3.charAt(p)) {
            if(helper(s1, s2, s3, m-1, n, p-1)) {
                return true;
            }
        }

        if(n >= 0 && s2.charAt(n) == s3.charAt(p)) {
            if(helper(s1, s2, s3, m, n-1, p-1)) {
                return true;
            }
        }
      return false;  
    }
}