class Solution {
    public int longestPalindrome(String s) {
        
        Set<Character> set = new HashSet<>();
        int res = 0;
        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(!set.contains(ch)) {
                set.add(ch);
            } else {
                res += 2;
                set.remove(ch);
            }
        }

        if(set.size() > 0) {
            res += 1;
        }
        
      return res;  
    }
}