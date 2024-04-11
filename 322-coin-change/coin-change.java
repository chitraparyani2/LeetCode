class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] mincoins = new int[amount+1];

        Arrays.fill(mincoins, Integer.MAX_VALUE);

        for(int c : coins) {
            if(c <= amount)
                mincoins[c] = 1;
        }

        mincoins[0] = 0;

        for(int i=1; i<=amount; i++) {
            for(int c : coins) {
                if(i > c && mincoins[i-c] != Integer.MAX_VALUE)
                    mincoins[i] = Math.min(mincoins[i], mincoins[i-c]+1);
            }
        }

        return mincoins[amount] == Integer.MAX_VALUE ? -1:mincoins[amount];
    }
}