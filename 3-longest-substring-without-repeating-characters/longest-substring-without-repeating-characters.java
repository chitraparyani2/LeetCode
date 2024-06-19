class Solution {
    public int lengthOfLongestSubstring(String s) {

        int i=0, j=0, res=0, n=s.length();
        Set<Character> set = new HashSet();

        while(j < n) {

            char ch = s.charAt(j);

            if(!set.contains(ch)) {
                set.add(ch);

                res = Math.max(res, j-i+1);
                j++;

            } else {
                
                set.remove(s.charAt(i));
                i++;
            }
        }

        return res;
    }
}