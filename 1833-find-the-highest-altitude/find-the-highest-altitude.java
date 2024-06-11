class Solution {
    public int largestAltitude(int[] gain) {
        
        
        int g=0, netgain=gain[0];
        int res = Math.max(0, netgain);

        for(int i=1; i<gain.length; i++) {

            g = netgain+gain[i];
            netgain = g;
            res = Math.max(res, netgain);

        }
      return res;  
    }
}