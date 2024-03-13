class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1 || numRows == s.length()) {
            return s;
        }
        Map<Integer, StringBuilder> map = new HashMap<>();
        
        for(int i=0; i<numRows; i++) {
            map.put(i, new StringBuilder());
        }
        
        int count=0, st=0, n=s.length();
        
        while(st < n) {
            
            while(st < n && count < numRows) {
                map.get(count).append(s.charAt(st));
                count++;
                st++;
            }
            
            count-=2;
            
            while(st < n && count >= 0) {
                map.get(count).append(s.charAt(st));
                count--;
                st++;
            }
            
            count+=2;
            
        }
        
        StringBuilder res = new StringBuilder();
        
        for(int i=0; i<numRows; i++) {
            res.append(map.get(i));
        }
        
        return res.toString();
    }
}