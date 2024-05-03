class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int s1=0, s2=0, e1=v1.length, e2=v2.length;

        int c1=0, c2=0;

        while(s1 < e1 || s2 < e2) {

           c1=0; c2=0;

           if(s1 < e1) {
            c1 = Integer.parseInt(v1[s1]);
            s1++;
           }

           if(s2 < e2) {
            c2 = Integer.parseInt(v2[s2]);
            s2++;
           }

           if(c1 > c2) {
            return 1;
           }

           if(c1 < c2) {
            return -1;
           }
        }

      return 0;  
    }
}