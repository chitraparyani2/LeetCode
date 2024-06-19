class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap();
        int st=0, n=s.length(), res=0;

        // if(s.length() == 1) {
        //     return 1;
        // }
        for(int i=0; i<n; i++) {

            char ch = s.charAt(i);

            if(map.containsKey(ch) && st <= map.get(ch)) {
                st = map.get(ch)+1;
            }
                map.put(ch, i);
                res = Math.max(res, i-st+1);
        }
      return res;  
    }
}