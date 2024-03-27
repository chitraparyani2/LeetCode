class Solution {
    public int lengthOfLastWord(String s) {
        
        int n = s.length()-1;
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            if(s.charAt(n) == ' ') {
                n--;
            } else {
                break;
            }
        }

        for(int i=n; i>=0; i--) {

            if(s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                break;
            }
        }
       return sb.length(); 
    }
}