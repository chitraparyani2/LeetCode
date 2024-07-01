class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        
        int n = arr.length;
        boolean[] dp = new boolean[n];

        int count = 0;

        for(int i=0; i<n; i++) {

            if(i==0 && arr[i]%2 != 0) {
                dp[i]=true;
                count++;
            } else if(arr[i]%2 != 0) {
                dp[i] = dp[i-1];
                count++;
                if(count == 3) {
                    return true;
                }
            } else {
                count=0;
            }
        }
        return false;
    }
}