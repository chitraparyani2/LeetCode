class Solution {
    public String countAndSay(int n) {
        
        StringBuilder sb = new StringBuilder("1");

        if(n == 1) {
            return sb.toString();
        }

        int st = 1;

        while(st < n) {

            String s = sb.toString();

            char[] ch = s.toCharArray();
            
            int count = 1;

            StringBuilder r = new StringBuilder();
            
            for(int i=0; i<ch.length; i++) {

                if(i+1 < ch.length && ch[i] == ch[i+1]) {
                    count++;
                } else {
                    r.append(count);
                    r.append(ch[i]);
                    count=1;
                }
            }
                sb.setLength(0);
                sb.append(r.toString());
                st++;
        }

        return sb.toString();
    }
}