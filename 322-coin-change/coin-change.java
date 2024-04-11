class Solution {
    /*
        coins -> 1, 2, 5
        amount -> 11
        --
        8, 5, 1 -> 18
        8, 8, 1 ,1
        8, 5, 5
    ---
    1 -> 1, 2 -> 1, 5 -> 1
    3 -> 2, 4 -> 2, 6 -> 2, 7 -> 

    */
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int c: coins){
            if(c <= amount){
                dp[c] = 1;
            }
        }
        
        for(int a = 1; a<=amount; a++){
            for(int c : coins){
                if(c <= a && dp[a-c] != Integer.MAX_VALUE){
                    dp[a] = Math.min(dp[a], dp[a-c] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];
        
    }
}