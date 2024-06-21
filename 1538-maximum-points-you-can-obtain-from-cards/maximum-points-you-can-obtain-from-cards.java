class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int max=0, sum=0, count=0;
        boolean flag = false;

        int i=0, j=cardPoints.length;

        while(i < j) {

            while(i < k) {
                sum += cardPoints[i];
                i++;
            }
             
            while(k > 0) {
                max = Math.max(max, sum);
                sum -= cardPoints[--i];
                sum += cardPoints[--j];
                k--;
            } 

            if(k == 0) {break;}
        }

      return Math.max(max, sum);  
    }
}