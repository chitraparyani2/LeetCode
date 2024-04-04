class Solution {
    public int maxDepth(String s) {
        
        int open = 0, res=0;

        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(ch == '(') {
                open++;

                res = Math.max(res, open);
            } else if(ch == ')') {
                open--;
            }
        }
        
      return res;  
    }
}