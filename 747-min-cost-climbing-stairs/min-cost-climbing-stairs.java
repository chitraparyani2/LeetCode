class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;

        int[] memo = new int[n];

        Arrays.fill(memo, -1);

        memo[0]= cost[0];
        memo[1]=cost[1];

        return Math.min(helper(cost, cost.length-1, memo), helper(cost, cost.length-2, memo));
    }

    public int helper(int[] cost, int n, int[] memo) {

        if(n < 0) {
            return 0;
        }

        if(memo[n] != -1) {
            return memo[n];

        }
        int res = cost[n] + 
            Math.min(helper(cost, n-1, memo), helper(cost, n-2, memo));

        memo[n] = res;

        return Math.min(memo[n], memo[n-1]);
    }
}