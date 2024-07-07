class Solution {
    public String reverseWords(String s) {
        
        StringBuilder res = new StringBuilder();
        int n = s.length();

        while(n > 0) {

            StringBuilder sb = new StringBuilder();

            while(n > 0 && s.charAt(n-1) == ' ' && sb.length() == 0) {
                n--;
            }

            while(n > 0 && s.charAt(n-1) != ' ') {
                sb.append(s.charAt(n-1));
                n--;
            }
            
            if(sb.length() > 0) {
                res.append(sb.reverse() + " ");
            }
        }
        
        res.deleteCharAt(res.length()-1);
        
        return res.toString();
    }
}