class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        
        int sum = 0,preSum = 0,st=0;
        boolean flag = false;
        
        while(st < n) {

            if(st < k && !flag) {
                preSum += cardPoints[st];
                st++;
            } else {
                flag = true;
                preSum -= cardPoints[--st];
                preSum += cardPoints[--n];
            }
                sum = Math.max(sum, preSum);

                if(st == 0) {
                    break;
                }
        }

      return sum;  
    }
}