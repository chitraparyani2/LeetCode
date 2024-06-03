class Solution {
    public int appendCharacters(String s, String t) {
        
        int found=0, st=0;

        while(st < s.length() && found < t.length()) {

            if(s.charAt(st) == t.charAt(found)) {
                found++;
            }  
                st++;
        }

        return t.length()-found;
    }
}