class Solution {
    public String reorganizeString(String s) {
        
        Map<Character, Integer> map = new HashMap<>();

        char maxch='-';
        int max=0;
        int n=s.length();

        char[] res = new char[n];

        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);

            if(map.get(ch) > max) {
                max = map.get(ch);
                maxch = ch;
            }
        }

        if(max > (n+1)/2) {
            return "";
        }

        int index=0;

        for(int i=0; i<max; i++) {
            res[index] = maxch;
            index+=2;
        }

        map.remove(maxch);

        for(int i=0; i<s.length(); i++) {

            char c = s.charAt(i);

            if(index >= n) {
                index=1;
            }

            int val=map.getOrDefault(c,0);

            for(int j=0; j<val; j++) {
                if(index >= n) {
                    index=1;
                }
                res[index] = c;
                index+=2;
            }
            map.remove(c);
        }

      return new String(res);  
    }
}