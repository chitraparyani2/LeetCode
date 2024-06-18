class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);

            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        int st=0, ed=0, count=0, lt=0, rt=0, res=Integer.MAX_VALUE;

        while(ed < s.length()) {

            char ch = s.charAt(ed);

            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0) {
                    count++;
                }
            }

            while(st <= ed && count == map.size()) {

                int len = ed-st+1;

                if(res > len) {
                    res = len;
                    rt = ed;
                    lt = st;
                }

                char ch1 = s.charAt(st);

                if(map.containsKey(ch1)) {

                    map.put(ch1, map.get(ch1)+1);

                    if(map.get(ch1) == 1) {
                        count--;
                    }
                }
                st++;
            }

          ed++;  
        }

      return res == Integer.MAX_VALUE ? "" : s.substring(lt, rt+1);  
    }
}